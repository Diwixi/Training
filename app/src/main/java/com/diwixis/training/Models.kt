package com.diwixis.training

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
//@Parcelize
//@JsonIgnoreProperties(ignoreUnknown = true)
//data class Training(
//    @JsonProperty(value = "training_type", required = true) val trainingType: String,
//    @JsonProperty(value = "exercises", required = true) val exercises: List<Exercise>
//) : Parcelable
//
//@Parcelize
//@JsonIgnoreProperties(ignoreUnknown = true)
//data class Exercise(
//    @JsonProperty(value = "name", required = true) val name: String,
//    @JsonProperty(value = "sets", required = true) val sets: List<Set>
//) : Parcelable
//
//@Parcelize
//@JsonIgnoreProperties(ignoreUnknown = true)
//data class Set(
//    @JsonProperty(value = "sequence_number", required = true) val sequenceNumber: Int,
//    @JsonProperty(value = "number_of_repetitions", required = true) val numberOfRepetitions: Int
//) : Parcelable