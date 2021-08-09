package br.com.cassiano.myappv2.recipelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.cassiano.myappv2.commonstest.CoroutinesTestRule
import br.com.cassiano.myappv2.domain.model.Recipe
import br.com.cassiano.myappv2.feature.recipeslist.view.recipes.RecipesViewModel
import br.com.cassiano.myappv2.usecase.RecipesUseCase
import io.mockk.called
import io.mockk.coEvery
import io.mockk.coVerifyOrder
import io.mockk.mockk
import java.net.SocketTimeoutException
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RecipesViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutinesTestRule()

    private val progressBarVisibilityMock: Observer<Boolean> = mockk(relaxed = true)
    private val onDataResultMock: Observer<List<Recipe>> = mockk(relaxed = true)
    private val onDataErrorMock: Observer<Boolean> = mockk(relaxed = true)
    private val recipesUseCaseMock : RecipesUseCase = mockk(relaxed = true)
    private lateinit var viewModel: RecipesViewModel

    @Before
    fun `Setup test`() {
        viewModel = RecipesViewModel(recipesUseCaseMock)
        setupLiveDataObservables()
    }

    private fun setupLiveDataObservables() {
        viewModel.apply {
            progressBarVisibility.observeForever(progressBarVisibilityMock)
            onDataResult.observeForever(onDataResultMock)
            onDataError.observeForever(onDataErrorMock)
        }
    }

    @Test
    fun `Test getData() when it succeeds`() {
        coEvery { recipesUseCaseMock.execute() } returns listOf(Recipe.mock())

        viewModel.getData()

        coVerifyOrder {
            progressBarVisibilityMock.onChanged(true)
            onDataErrorMock.onChanged(false)
            onDataResultMock.onChanged(listOf(Recipe.mock()))
            progressBarVisibilityMock.onChanged(false)
        }
    }

    @Test
    fun `Test getData() when it fails`() {
        coEvery { recipesUseCaseMock.execute() } throws SocketTimeoutException()

        viewModel.getData()

        coVerifyOrder {
            progressBarVisibilityMock.onChanged(true)
            onDataResultMock wasNot called
            onDataErrorMock.onChanged(true)
            progressBarVisibilityMock.onChanged(false)
        }
    }

}