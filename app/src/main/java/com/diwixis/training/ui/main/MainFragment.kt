package com.diwixis.training.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.diwixis.training.*
import com.diwixis.training.ui.training.TrainingFragment
import com.diwixis.training.ui.training.TrainingFragment.Companion.BUNDLE_COMPARISON
import com.diwixis.training.ui.training.TrainingsAdapter
import kotlinx.android.synthetic.main.dialog_input_text.view.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        trainingRecycler.adapter =
            TrainingsAdapter(mutableListOf()) { training ->
                openTraining(training)
            }

        addTrainingButton.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(activity).inflate(R.layout.dialog_input_text, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(activity!!)
                .setView(mDialogView)
                .setTitle("Input Training Name")
            //show dialog
            val mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.okButton.setOnClickListener {
                //dismiss dialog
                (trainingRecycler.adapter as TrainingsAdapter).add(
                    viewModel.createTraining(
                        mDialogView.dialogInputText.text.toString()
                    )
                )
                mAlertDialog.dismiss()
                //get text from EditTexts of custom layout

            }
            //cancel button click of custom layout
            mDialogView.cancelButton.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
        }
    }

    fun openTraining(training: Training) {
        val fragment = TrainingFragment.newInstance().apply {
            arguments = bundle { putParcelable(BUNDLE_COMPARISON, training) }
        }

        fragmentManager?.beginTransaction()
            ?.replace(R.id.container, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
