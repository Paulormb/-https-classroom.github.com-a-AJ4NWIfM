package survey.app.data.model

import com.google.gson.annotations.SerializedName

data class Geographical(
    @SerializedName("nest_id") val nestId : Int,
    @SerializedName("nest_code") val nestCode : String,
    @SerializedName("date") val date : Any,
    @SerializedName("start_time") val startTime : Any,
    @SerializedName("end_time") val endTime : Any,
    @SerializedName("relocated_to") val relocatedTo : String,
    @SerializedName("reason_for_relocation") val reasonForRelocation : String,
    @SerializedName("top_egg_depth") val topEggDepth : Int,
    @SerializedName("bottom_of_nest_depth") val bottomOfNestDepth : Int,
    @SerializedName("distance_to_sea") val distanceToSea : Int,
    @SerializedName("number_of_eggs") val numberOfEggs : Int,
    @SerializedName("gps_latitude") val gpsLatitude : Float,
    @SerializedName("gps_longitude") val gpsLongitude : Float
)