package com.sample.catapp.catdetails.presentation.viewmodel

import com.sample.catdetails.CatItem
import com.sample.catapp.catdetails.data.network.NetworkResult
import com.sample.catapp.catdetails.domain.usecase.FetchListUseCase
import com.sample.catapp.catdetails.getMockResponseForApiResponse
import com.sample.catapp.catdetails.presentation.CatIntents
import com.sample.catapp.catdetails.presentation.viewmodel.CatInfoViewModel.Companion.PAGE_SIZE
import com.sample.catapp.catdetails.presentation.viewmodel.CatInfoViewModel.Companion.order
import com.sample.catapp.dispatcher.AppCoroutineDispatcher
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class CatInfoViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private lateinit var viewModel: CatInfoViewModel
    private val coroutineDispatcher = mockk<AppCoroutineDispatcher>()
    private val fetchListUseCase = mockk<FetchListUseCase>(relaxed = true)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun before() {
        Dispatchers.setMain(mainThreadSurrogate)
        every { coroutineDispatcher.io } returns Dispatchers.Main
        viewModel = CatInfoViewModel(coroutineDispatcher, fetchListUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    fun testFireIntentForFetchingData() {
        val mockApiResponseList = getMockResponseForApiResponse()
        coEvery {
            fetchListUseCase.invoke(
                viewModel.pageNo,
                order,
                pageLimit = PAGE_SIZE
            )
        } returns NetworkResult.Success(mockApiResponseList)
        viewModel.fireIntent(CatIntents.FetchCatList)
        coVerify { fetchListUseCase.invoke(any(), any(), any()) }
    }

    @Test
    fun testFireIntentForSetupDetailObject() {
        val mockApiResponseList = getMockResponseForApiResponse()
        coEvery {
            fetchListUseCase.invoke(
                viewModel.pageNo,
                order,
                pageLimit = PAGE_SIZE
            )
        } returns NetworkResult.Success(mockApiResponseList)
        viewModel.fireIntent(CatIntents.SelectCat(getMockCatItem()))
        assertTrue(viewModel.catDetailsState.value!!.id == "1")
    }

    @Test
    fun testException() {
        coEvery {
            fetchListUseCase.invoke(
                viewModel.pageNo,
                order,
                pageLimit = PAGE_SIZE
            )
        } answers {
            NetworkResult.Error(1, "Error")
        }
        viewModel.fireIntent(CatIntents.SelectCat(getMockCatItem()))
        assertTrue(viewModel.uiState.value.isError)
    }

    @Test
    fun testInitialisation() {
        assertTrue(viewModel.uiState.value.isLoading)
        assertFalse(viewModel.uiState.value.isError)
    }


    @Test
    fun `test setLoadingFalse`() = runTest {
        // Mock the MutableStateFlow
        viewModel.setLoadingFalse()

        // Verify that the state is updated correctly
        assertFalse(viewModel.uiState.value.isLoading)
    }


    private fun getMockCatItem(): CatItem {
        return CatItem(
            weight = com.sample.catdetails.Weight(imperial = "10", metric = "5"),
            id = "1",
            name = "Mock Cat",
            cfaUrl = "https://example.com",
            vetstreetUrl = "https://example.com",
            vcahospitalsUrl = "https://example.com",
            temperament = "Calm",
            origin = "Test",
            countryCodes = "US",
            countryCode = "US",
            description = "Mock description",
            lifeSpan = "10 years",
            indoor = 1,
            lap = 1,
            altNames = "Alternate Names",
            adaptability = 3,
            affectionLevel = 4,
            childFriendly = 5,
            dogFriendly = 4,
            energyLevel = 3,
            grooming = 2,
            healthIssues = 1,
            intelligence = 3,
            sheddingLevel = 2,
            socialNeeds = 4,
            strangerFriendly = 3,
            vocalisation = 2,
            experimental = 0,
            hairless = 0,
            natural = 0,
            rare = 0,
            rex = 0,
            suppressedTail = 0,
            shortLegs = 0,
            wikipediaUrl = "https://en.wikipedia.org/wiki/Cat",
            hypoallergenic = 0,
            referenceImageId = "1",
            image = com.sample.catdetails.Image(
                id = "1",
                width = 100,
                height = 100,
                url = "https://example.com/cat.jpg"
            )
        )

    }

}
