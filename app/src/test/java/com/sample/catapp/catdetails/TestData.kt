package com.sample.catapp.catdetails

import com.sample.catapp.catdetails.data.network.ApiResponse
import com.sample.catapp.catdetails.data.network.Image
import com.sample.catapp.catdetails.data.network.Weight

fun getMockResponseForApiResponse(): List<ApiResponse> {
    return listOf(
        ApiResponse(
            weight = Weight(imperial = "10", metric = "5"),
            id = "0",
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
            image = Image(
                id = "1",
                width = 100,
                height = 100,
                url = "https://example.com/cat.jpg"
            )
        )
    )
}
