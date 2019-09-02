package com.example.darshnak.bottomnavigtaionproj.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*
 * Purpose:Coins is suppose to handle Coins list item.
 *  Created by darshna on 12 May,2019.
 *  Copyright © 2019. All rights reserved.
 *
 */
@Entity
class Coins : Serializable {
    @PrimaryKey
    @Expose
    @SerializedName("id")
    lateinit var id: String

    @Expose
    @SerializedName("symbol")
    lateinit var symbol: String

    @Expose
    @SerializedName("name")
    lateinit var name: String

    @Expose
    @SerializedName("enable")
    var enable = 0

    @Expose
    @SerializedName("usd_price")
    var usd_price = ""

    @Expose
    @SerializedName("inr_price")
    var inr_price = ""


}
