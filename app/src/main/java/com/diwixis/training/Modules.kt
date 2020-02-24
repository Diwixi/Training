package com.diwixis.training

import com.diwixis.training.ui.MainActivity
import com.diwixis.training.ui.TrainingViewModel
import com.diwixis.training.ui.exerciseBuilder.ExercisesFragment
import com.diwixis.training.ui.showTraining.TrainingShowFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
val appModule = module {
    scope<MainActivity> {
        scoped { TrainingShowFragment() }
        scoped { ExercisesFragment() }
    }
}

val viewModels = module {
    viewModel { TrainingViewModel() }
}