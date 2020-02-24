package com.diwixis.training.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import com.diwixis.training.R
import com.diwixis.training.replace
import com.diwixis.training.ui.exerciseBuilder.ExercisesFragment
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class MainActivity : AppCompatActivity(R.layout.main_activity), KoinComponent, LifecycleObserver {
    val trainingViewModel by viewModel<TrainingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory(lifecycleScope)
        super.onCreate(savedInstanceState)

        ExercisesFragment::class.replace(supportFragmentManager)
    }
}