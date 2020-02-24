package com.diwixis.training

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlin.reflect.KClass

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
fun <T : Fragment> KClass<T>.replace(supportFragmentManager: FragmentManager) =
    supportFragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, this.java, null, this.simpleName)
        .commit()