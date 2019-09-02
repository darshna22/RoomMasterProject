package com.example.darshnak.bottomnavigtaionproj.model.event

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EventResponse {

    @SerializedName("data")
    @Expose
    var data: List<EventData>? = null
    @SerializedName("count")
    @Expose
    var count: Int = 0
    @SerializedName("page")
    @Expose
    var page: Int = 0

}
