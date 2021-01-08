package survey.app.data.model

import com.google.gson.annotations.SerializedName

data class MorningSurvey(
    @SerializedName("survey_id") val id : Int,
    @SerializedName("area") val area : String,
    @SerializedName("beach") val beach : String,
    @SerializedName("sector") val sector : String,
    @SerializedName("subsector") val subsector : String,
    @SerializedName("emergence_event") val emergenceEvent : String,
    @SerializedName("nest") val nest : Boolean,
    @SerializedName("distance_to_sea") val distanceToSea : Int,
    @SerializedName("track_type") val trackType : String,
    @SerializedName("non_nesting_attempts") val nonNestingAttempts : Int,
    @SerializedName("gps_latitude") val gpsLatitude : Float,
    @SerializedName("gps_longitude") val gpsLongitude : Float,
    @SerializedName("tags") val tags : String,
    @SerializedName("comments") val comments : String,
    @SerializedName("nest_code") val nestCode : String
)