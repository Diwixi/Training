package com.diwixis.training.ui.main

import androidx.lifecycle.ViewModel
import com.diwixis.training.Training

class MainViewModel : ViewModel() {
    fun createTraining(trainingName: String): Training {
        return Training(trainingName, emptyList())
    }
    // TODO: Implement the ViewModel
}
