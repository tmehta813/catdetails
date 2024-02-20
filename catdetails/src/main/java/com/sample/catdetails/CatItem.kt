package com.sample.catdetails

 data class CatItem(
    val weight: Weight,
    val id: String,
    val name: String,
    val cfaUrl: String?,
    val vetstreetUrl: String?,
    val vcahospitalsUrl: String?,
    val temperament: String,
    val origin: String,
    val countryCodes: String,
    val countryCode: String,
    val description: String,
    val lifeSpan: String,
    val indoor: Int,
    val lap: Int?,
    val altNames: String?,
    val adaptability: Int,
    val affectionLevel: Int,
    val childFriendly: Int,
    val dogFriendly: Int,
    val energyLevel: Int,
    val grooming: Int,
    val healthIssues: Int,
    val intelligence: Int,
    val sheddingLevel: Int,
    val socialNeeds: Int,
    val strangerFriendly: Int,
    val vocalisation: Int,
    val experimental: Int,
    val hairless: Int,
    val natural: Int,
    val rare: Int,
    val rex: Int,
    val suppressedTail: Int,
    val shortLegs: Int,
    val wikipediaUrl: String?,
    val hypoallergenic: Int,
    val referenceImageId: String?,
    val image: Image?
)

data class Weight(
    val imperial: String,
    val metric: String
)

data class Image(
    val id: String?,
    val width: Int?,
    val height: Int?,
    val url: String
)