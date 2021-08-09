package br.com.cassiano.myappv2.domain.repository

import br.com.cassiano.myappv2.data.api.ServiceApi
import br.com.cassiano.myappv2.data.response.RecipeResponse
import br.com.cassiano.myappv2.domain.model.Recipe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RecipesRepositoryImplTest {

    private val apiMock: ServiceApi = mockk(relaxed = true)

    private lateinit var repository: RecipesRepository

    @Before
    fun `Setup test`() {
        repository = RecipesRepositoryImpl(apiMock)
    }

    @Test
    fun `Test getRecipes() behaviour`() = runBlocking {
        coEvery { apiMock.getRecipes() } returns listOf(RecipeResponse.mock())

        val result = repository.getRecipes()

        Assert.assertEquals(result, listOf(Recipe.mock()))
        coVerify { apiMock.getRecipes() }
    }
}