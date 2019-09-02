package com.example.darshnak.bottomnavigtaionproj.room

import androidx.room.Room
import android.content.Context

class DatabaseClient private constructor(private val mCtx: Context?) {

    //our app database object
    val appDatabase: AppDatabase

    init {

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx!!.applicationContext, AppDatabase::class.java, "coin_database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()// use to execute task on main thread
            .build()

    }

    companion object {
        private var mInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(mCtx: Context?): DatabaseClient {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance as DatabaseClient
        }
    }


}
