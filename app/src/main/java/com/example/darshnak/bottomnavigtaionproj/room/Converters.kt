package com.example.darshnak.bottomnavigtaionproj.room

import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.lang.reflect.Type
import java.util.ArrayList

/**
 * Created by Darshna Kumari on 12,June,2019.
 */

object Converters {
    @TypeConverter
    fun fromString(value: String): ArrayList<String>? {
        val listType = object : TypeToken<ArrayList<String>>() {

        }.type
        return Gson().fromJson<ArrayList<String>>(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
