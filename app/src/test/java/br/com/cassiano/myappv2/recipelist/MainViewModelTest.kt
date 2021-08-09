package br.com.cassiano.myappv2.recipelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel.Navigation
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel.Navigation.Recipes
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val navigationEventMock: Observer<Navigation> = mockk(relaxed = true)

    private lateinit var viewModel: MainViewModel

    @Before
    fun `Setup test`() {
        viewModel = MainViewModel()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.run {
            navigationEvent.observeForever(navigationEventMock)
        }
    }

    @Test
    fun `Test navigation() behaviour`() {
        viewModel.navigate(Recipes)
        verify { navigationEventMock.onChanged(Recipes) }
    }
}