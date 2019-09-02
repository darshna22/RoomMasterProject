package com.example.darshnak.bottomnavigtaionproj.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.darshnak.bottomnavigtaionproj.room.Converters
import com.example.darshnak.bottomnavigtaionproj.model.Coins
import com.example.darshnak.bottomnavigtaionproj.room.CoinsDao

@Database(entities = [Coins::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinsDao
}
