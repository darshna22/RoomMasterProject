package com.example.darshnak.bottomnavigtaionproj.room
import androidx.room.*
import com.example.darshnak.bottomnavigtaionproj.model.Coins

/**
 * Created by Darshna Kumari on 11,June,2019.
 */
@Dao
interface CoinsDao {

    @get:Query("SELECT * from Coins")
    val allCoinsList: MutableList<Coins>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(coins: Coins)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(coinsList: MutableList<Coins>)


    @Update
    fun updateCoinList(coins: Coins)

    @Delete
    fun deleteRow(coins: Coins)


    @Query("DELETE FROM Coins")
    fun deleteAll()
}
