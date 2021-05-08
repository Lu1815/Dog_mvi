package ni.devotion.catfactsapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DogNetworkEntity(
    @SerializedName("message")
    @Expose
    var message: String,

    @SerializedName("status")
    @Expose
    var status: String
)