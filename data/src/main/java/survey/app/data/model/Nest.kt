package survey.app.data.model

import com.google.gson.annotations.SerializedName

data class Nest(
    @SerializedName("nest_code") val code: String,
    @SerializedName("beach") val beach: String,
    @SerializedName("sector") val sector: String,
    @SerializedName("subsector") val subsector: String,
    @SerializedName("protection_measures") val protectionMeasures: String,
    @SerializedName("inundated_during_incubation") val inundatedDuringIncubation: Boolean,
    @SerializedName("predated_during_incubation") val predatedDuringIncubation: Boolean,
    @SerializedName("date_of_first_hatching") val dateOfFirstHatching: Any,
    @SerializedName("date_of_last_hatching") val dateOfLastHatching: Any,
    @SerializedName("inundated_during_hatching") val inundatedDuringHatching: Boolean,
    @SerializedName("predated_during_hatching") val predatedDuringHatching: Boolean,
    @SerializedName("affected_by_light_pollution") val affectedByLightPollution: Boolean,
    @SerializedName("excavation_date") val excavationDate: Any,
    @SerializedName("excavation_bottom_of_nest_depth") val excavationBottomOfNestDepth: Any,
    @SerializedName("hatched_eggs") val hatchedEggs: Int,
    @SerializedName("pipped_dead_hatchlings") val pippedDeadHatchlings: Int,
    @SerializedName("pipped_live_hatchlings") val pippedLiveHatchlings: Int,
    @SerializedName("no_embryos_in_unhatched_eggs") val noEmbryosInUnhatchedEggs: Int,
    @SerializedName("dead_embryos_in_unhatched_eggs_eye_spot") val deadEmbryosInUnhatchedEggsEyeSpot: Int,
    @SerializedName("dead_embryos_in_unhatched_eggs_early") val deadEmbryosInUnhatchedEggsEarly: Int,
    @SerializedName("dead_embryos_in_unhatched_eggs_middle") val deadEmbryosInUnhatchedEggsMiddle: Int,
    @SerializedName("dead_embryos_in_unhatched_eggs_late") val deadEmbryosInUnhatchedEggsLate: Int,
    @SerializedName("live_embryos_in_unhatched_eggs") val deadEmbryosInUnhatchedEggs: Int,
    @SerializedName("dead_hatchlings_in_nest") val deadHatchlingsInNest: Int,
    @SerializedName("live_hatchlings_in_nest") val liveHatchlingsInNest: Int,
    @SerializedName("excavation_comments") val excavationComments: String,
    @SerializedName("general_comments") val generalComments: String
)