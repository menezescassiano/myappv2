package br.com.cassiano.myappv2.extension

import android.app.Activity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import br.com.cassiano.myappv2.R

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, expression: (T?) -> Unit) {
    liveData.observe(this, Observer(expression))
}

fun Activity.defaultNavController(
    @NavigationRes navGraphId: Int
) = findNavController(R.id.fragment_container).apply {
    graph = navInflater.inflate(navGraphId)
}

fun NavController.defaultNavigate(
    @IdRes resId: Int,
    args: Bundle? = null,
    popStack: Boolean = false,
    navOptionsBuilder: NavOptions.Builder = defaultNavOptionsBuilder()
) {
    val navOptions = navOptionsBuilder
        .apply { if (popStack) setPopUpTo(graph.id, true) }
        .build()

    navigate(resId, args, navOptions)
}

fun defaultNavOptionsBuilder() = NavOptions.Builder()
    .setEnterAnim(R.anim.fast_fade_in)
    .setExitAnim(R.anim.fast_fade_out)

inline fun <reified VM : ViewModel> Fragment.activityViewModel(): Lazy<VM> = lazy {
    ViewModelProvider(requireActivity()).get(VM::class.java)
}

inline fun ViewModel.safeRun(
    onSuccess: () -> Unit,
    onError: (Exception) -> Unit = {}
) {
    try {
        onSuccess()
    } catch (ex: Exception) {
        onError(ex)
    }
}