package com.diwixis.training

import android.os.Bundle

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
inline fun bundle(body: Bundle.() -> Unit) = Bundle().apply(body)