package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class RocketsItemModel(
    @SerializedName("active")
    val active: Boolean? = false,
    @SerializedName("boosters")
    val boosters: Int? = 0,
    @SerializedName("company")
    val company: String? = "",
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int? = 0,
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("diameter")
    val diameter: DiameterModel? = DiameterModel(),
    @SerializedName("engines")
    val engines: EnginesModel? = EnginesModel(),
    @SerializedName("first_flight")
    val firstFlight: String? = "",
    @SerializedName("first_stage")
    val firstStage: FirstStageModel? = FirstStageModel(),
    @SerializedName("flickr_images")
    val flickrImages: List<String>? = listOf(),
    @SerializedName("height")
    val height: HeightModel? = HeightModel(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("landing_legs")
    val landingLegs: LandingLegsModel? = LandingLegsModel(),
    @SerializedName("mass")
    val mass: MassModel? = MassModel(),
    @SerializedName("payload_weights")
    val payloadWeights: List<PayloadWeightModel>? = listOf(),
    @SerializedName("rocket_id")
    val rocketId: String? = "",
    @SerializedName("rocket_name")
    val rocketName: String? = "",
    @SerializedName("rocket_type")
    val rocketType: String? = "",
    @SerializedName("second_stage")
    val secondStage: SecondStageModel? = SecondStageModel(),
    @SerializedName("stages")
    val stages: Int? = 0,
    @SerializedName("success_rate_pct")
    val successRatePct: Int? = 0,
    @SerializedName("wikipedia")
    val wikipedia: String? = ""
)