package com.diwixis.training

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diwixis.training.ui.VmModel

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
class TrainingViewModel : ViewModel() {
    private var trainingModel = TrainingModel("Жим", emptyList())
    private val uiDataVm: MutableLiveData<UiModel> = MutableLiveData()
    val uiData: LiveData<UiModel> get() = uiDataVm

    init {
        uiDataVm.value = postData()
    }

    private fun postData() = UiModel(
        trainingModel.name,
        trainingModel.sets.size.inc(),
        if (trainingModel.sets.isNotEmpty()) trainingModel.sets.last().count - 2 else 12,
        if (trainingModel.sets.isNotEmpty()) trainingModel.sets.last().count else 0
    )

    fun nextSet(data: VmModel) {
        trainingModel = trainingModel.copy(
            name = data.name,
            sets = trainingModel.sets.plus(ExeciseSet(data.exerciseSetCount))
        )
        uiDataVm.value = postData()
    }

    fun updateName(name: String) {
        trainingModel = trainingModel.copy(name = name)
        uiDataVm.value = postData()
    }
}

data class UiModel(
    val name: String,
    val exerciseSetNumber: Int,
    val exerciseSetCount: Int,
    val previousExerciseSetCount: Int
)

data class TrainingModel(
    val name: String,
    val sets: List<ExeciseSet>
)

data class ExeciseSet(
    val count: Int
)