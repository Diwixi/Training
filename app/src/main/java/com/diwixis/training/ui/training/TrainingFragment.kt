package com.diwixis.training.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.diwixis.training.R
import com.diwixis.training.ui.main.MainViewModel
import kotlinx.android.synthetic.main.dialog_input_text.view.*
import kotlinx.android.synthetic.main.main_fragment.*

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
class TrainingFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_training, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TrainingViewModel::class.java)

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

    companion object {
        const val BUNDLE_COMPARISON = "BUNDLE_COMPARISON"
        fun newInstance() = TrainingFragment()
    }
}