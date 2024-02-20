package com.sample.catapp.catdetails.presentation

import com.sample.catdetails.CatItem
import com.sample.catdetails.Image
import com.sample.catapp.catdetails.data.network.ApiResponse
import com.sample.catapp.catdetails.data.network.Weight

object CatBreedMapper {

    fun mapToUiCatItems(apiResponses: List<ApiResponse>): List<CatItem> {
        return apiResponses.map { apiResponse ->
            mapApiResponseToUiCatData(apiResponse)
        }
    }

    private fun mapApiResponseToUiCatData(apiResponse: ApiResponse): CatItem {
        return CatItem(
            weight = getWeight(apiResponse.weight),
            id = apiResponse.id,
            name = apiResponse.name,
            cfaUrl = apiResponse.cfaUrl,
            vetstreetUrl = apiResponse.vetstreetUrl,
            vcahospitalsUrl = apiResponse.vcahospitalsUrl,
            temperament = apiResponse.temperament,
            origin = apiResponse.origin,
            countryCodes = apiResponse.countryCodes,
            countryCode = apiResponse.countryCode,
            description = apiResponse.description,
            lifeSpan = apiResponse.lifeSpan,
            indoor = apiResponse.indoor,
            lap = apiResponse.lap,
            altNames = apiResponse.altNames ?: "",
            adaptability = apiResponse.adaptability,
            affectionLevel = apiResponse.affectionLevel,
            childFriendly = apiResponse.childFriendly,
            dogFriendly = apiResponse.dogFriendly,
            energyLevel = apiResponse.energyLevel,
            grooming = apiResponse.grooming,
            healthIssues = apiResponse.healthIssues,
            intelligence = apiResponse.intelligence,
            sheddingLevel = apiResponse.sheddingLevel,
            socialNeeds = apiResponse.socialNeeds,
            strangerFriendly = apiResponse.strangerFriendly,
            vocalisation = apiResponse.vocalisation,
            experimental = apiResponse.experimental,
            hairless = apiResponse.hairless,
            natural = apiResponse.natural,
            rare = apiResponse.rare,
            rex = apiResponse.rex,
            suppressedTail = apiResponse.suppressedTail,
            shortLegs = apiResponse.shortLegs,
            wikipediaUrl = apiResponse.wikipediaUrl,
            hypoallergenic = apiResponse.hypoallergenic,
            referenceImageId = apiResponse.referenceImageId,
            image = getImage(apiResponse.image)
        )
    }

    private fun getWeight(weight: Weight): com.sample.catdetails.Weight {
        return com.sample.catdetails.Weight(
            imperial = weight.imperial,
            metric = weight.metric
        )
    }

    private fun getImage(image: com.sample.catapp.catdetails.data.network.Image?): Image? {
        if (image == null) return null
        return Image(
            id = image.id,
            width = image.width,
            height = image.height,
            url = image.url
        )
    }
}
