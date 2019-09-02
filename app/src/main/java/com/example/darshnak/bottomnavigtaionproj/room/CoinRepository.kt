package com.example.darshnak.bottomnavigtaionproj.room

import android.os.AsyncTask
import com.example.darshnak.bottomnavigtaionproj.MainActivity
import com.example.darshnak.bottomnavigtaionproj.model.Coins
import com.example.darshnak.bottomnavigtaionproj.utility.ThreadManager
import java.util.concurrent.ExecutionException

/**
 * Created by Darshna Kumari on 11,June,2019.
 */

class CoinRepository(application: MainActivity) {
    private val coinsDao: CoinsDao

    val allCoinListData: List<Coins>
        @Throws(ExecutionException::class, InterruptedException::class)
        get() = GetAllAsyncTask(coinsDao).execute().get()


    init {
        coinsDao = DatabaseClient.getInstance(application)
            .appDatabase
            .coinDao()
    }


    fun insert(coin: Coins) {
        ThreadManager.instance?.doWork(object : ThreadManager.CustomRunnable() {


            override fun onBackground() {
                coinsDao.insert(coin)

            }

            override fun onUi() {
                super.onUi()
            }
        })
    }

    fun insertAll(list: MutableList<Coins>) {
        ThreadManager.instance?.doWork(object : ThreadManager.CustomRunnable() {


           override fun onBackground() {
                coinsDao.insertAll(list)
            }

            override fun onUi() {
                super.onUi()
            }
        })
    }

    fun updateCoinList(coins: Coins) {

        ThreadManager.instance?.doWork(object : ThreadManager.CustomRunnable() {


            override fun onBackground() {
                coinsDao.updateCoinList(coins)

            }

            override fun onUi() {
                super.onUi()
            }
        })
    }
    fun deleteRow(coin: Coins) {
        ThreadManager.instance?.doWork(object : ThreadManager.CustomRunnable() {


            override fun onBackground() {
                coinsDao.deleteRow(coin)

            }

            override fun onUi() {
                super.onUi()
            }
        })
    }

    fun deleteAll() {

        ThreadManager.instance?.doWork(object : ThreadManager.CustomRunnable() {


            override fun onBackground() {
                coinsDao.deleteAll()

            }

            override fun onUi() {
                super.onUi()
            }
        })
    }






    private class GetAllAsyncTask internal constructor(private val mAsyncTaskDao: CoinsDao) :
        AsyncTask<Void, Void, List<Coins>>() {
        private val mCoinRepository: CoinRepository? = null


        override fun doInBackground(vararg voids: Void): List<Coins> {
            return mAsyncTaskDao.allCoinsList
        }


    }

}
