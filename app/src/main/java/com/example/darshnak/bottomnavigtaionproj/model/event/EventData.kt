package com.example.darshnak.bottomnavigtaionproj.model.event

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class EventData :Serializable {
    @PrimaryKey
    @Expose
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("type")
    @Expose
    var type = ""
    @SerializedName("title")
    @Expose
    var title = ""
    @SerializedName("description")
    @Expose
    var description = ""
    @SerializedName("organizer")
    @Expose
    var organizer = ""
    @SerializedName("start_date")
    @Expose
    var startDate = ""
    @SerializedName("end_date")
    @Expose
    var endDate = ""
    @SerializedName("website")
    @Expose
    var website = ""
    @SerializedName("email")
    @Expose
    var email = ""
    @SerializedName("venue")
    @Expose
    var venue = ""
    @SerializedName("address")
    @Expose
    var address = ""
    @SerializedName("city")
    @Expose
    var city = ""
    @SerializedName("country")
    @Expose
    var country = ""
    @SerializedName("screenshot")
    @Expose
    public final var screenshot = ""

}
