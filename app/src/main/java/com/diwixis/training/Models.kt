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
@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class Training(
    @JsonProperty(value = "trainingType", required = true) val trainingType: String,
    @JsonProperty(value = "exercises", required = true) val exercises: List<Exercise>
) : Parcelable

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class Exercise(
    @JsonProperty(value = "name", required = true) val name: String,
    @JsonProperty(value = "setNumber", required = true) val setNumber: Int,
    @JsonProperty(value = "setCount", required = true) val setCount: Int
) : Parcelable