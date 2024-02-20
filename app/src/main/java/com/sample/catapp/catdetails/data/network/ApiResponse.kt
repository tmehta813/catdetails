package com.sample.catapp.catdetails.data.network

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("weight") val weight: Weight,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("cfa_url") val cfaUrl: String?,
    @SerializedName("vetstreet_url") val vetstreetUrl: String?,
    @SerializedName("vcahospitals_url") val vcahospitalsUrl: String?,
    @SerializedName("temperament") val temperament: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("country_codes") val countryCodes: String,
    @SerializedName("country_code") val countryCode: String,
    @SerializedName("description") val description: String,
    @SerializedName("life_span") val lifeSpan: String,
    @SerializedName("indoor") val indoor: Int,
    @SerializedName("lap") val lap: Int?,
    @SerializedName("alt_names") val altNames: String?,
    @SerializedName("adaptability") val adaptability: Int,
    @SerializedName("affection_level") val affectionLevel: Int,
    @SerializedName("child_friendly") val childFriendly: Int,
    @SerializedName("dog_friendly") val dogFriendly: Int,
    @SerializedName("energy_level") val energyLevel: Int,
    @SerializedName("grooming") val grooming: Int,
    @SerializedName("health_issues") val healthIssues: Int,
    @SerializedName("intelligence") val intelligence: Int,
    @SerializedName("shedding_level") val sheddingLevel: Int,
    @SerializedName("social_needs") val socialNeeds: Int,
    @SerializedName("stranger_friendly") val strangerFriendly: Int,
    @SerializedName("vocalisation") val vocalisation: Int,
    @SerializedName("experimental") val experimental: Int,
    @SerializedName("hairless") val hairless: Int,
    @SerializedName("natural") val natural: Int,
    @SerializedName("rare") val rare: Int,
    @SerializedName("rex") val rex: Int,
    @SerializedName("suppressed_tail") val suppressedTail: Int,
    @SerializedName("short_legs") val shortLegs: Int,
    @SerializedName("wikipedia_url") val wikipediaUrl: String?,
    @SerializedName("hypoallergenic") val hypoallergenic: Int,
    @SerializedName("reference_image_id") val referenceImageId: String?,
    @SerializedName("image") val image: Image?
)

data class Weight(
    @SerializedName("imperial") val imperial: String,
    @SerializedName("metric") val metric: String
)

data class Image(
    @SerializedName("id") val id: String?,
    @SerializedName("width") val width: Int?,
    @SerializedName("height") val height: Int?,
    @SerializedName("url") val url: String
)
