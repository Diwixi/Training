package com.diwixis.training

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
data class UiModel(
    val name: String,
    val exerciseSetNumber: Int,
    val exerciseSetCount: Int,
    val previousExerciseSetCount: Int
)

data class TrainingModel(
    val name: String,
    val sets: List<ExerciseSet>
)

data class ExerciseSet(
    val count: Int
)