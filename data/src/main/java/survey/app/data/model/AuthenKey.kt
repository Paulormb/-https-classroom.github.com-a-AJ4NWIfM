package survey.app.data.model

import com.google.gson.annotations.SerializedName

data class AuthenKey(@SerializedName("key") val token : String)