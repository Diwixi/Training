package com.diwixis.training.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.diwixis.training.R
import com.diwixis.training.TrainingViewModel
import kotlinx.android.synthetic.main.fragment_trainings.*

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
class TrainingsFragment : Fragment() {

    lateinit var viewModel: TrainingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_trainings, container, false)!!

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = TrainingViewModel()
        viewModel.uiData.observeViewModel(this) { model ->
            excercise.text = model.name
            excerciseNumber.text = "${getString(R.string.exercise)} ${model.exerciseSetNumber}"
            previousExcerciseNumber.text =
                "${getString(R.string.previous_value)} ${model.previousExerciseSetCount}"
            picker.value = model.exerciseSetCount
        }

        addNextExerciseButton.setOnClickListener {
            viewModel.nextSet(VmModel(excercise.text.toString(), picker.value))
        }
        editButton.setOnClickListener {
            dialog()
        }
        endTrainingButton.setOnClickListener {
            
        }
    }

    private fun dialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Title")

        val input = EditText(requireContext())
        builder.setView(input)

        builder.setPositiveButton("OK") { _, _ -> viewModel.updateName(input.text.toString()) }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.show()
    }
}

inline fun <T> LiveData<T>.observeViewModel(
    lifecycleOwner: LifecycleOwner,
    crossinline listener: (T) -> Unit
) {
    observe(lifecycleOwner, Observer {
        it?.let(listener)
    })
}

data class VmModel(
    val name: String,
    val exerciseSetCount: Int
)