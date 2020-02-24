package com.diwixis.training.ui.exerciseBuilder

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.diwixis.training.R
import com.diwixis.training.ui.TrainingViewModel
import kotlinx.android.synthetic.main.fragment_exercise.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.core.KoinComponent

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
class ExercisesFragment : Fragment(R.layout.fragment_exercise), KoinComponent {

    private val viewModel by sharedViewModel<TrainingViewModel>()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

        editButton.setOnClickListener { showDialog() }

        endTrainingButton.setOnClickListener {}
    }

    private fun showDialog() {
        val input = EditText(requireContext())

        AlertDialog.Builder(requireContext()).apply {
            setTitle("Title")
            setView(input)
            setPositiveButton("OK") { _, _ -> viewModel.updateName(input.text.toString()) }
            setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
            show()
        }
    }
}

inline fun <T> LiveData<T>.observeViewModel(
    lifecycleOwner: LifecycleOwner,
    crossinline listener: (T) -> Unit
) {
    observe(lifecycleOwner, Observer { it?.let(listener) })
}

data class VmModel(
    val name: String,
    val exerciseSetCount: Int
)