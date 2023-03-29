package com.lotto.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lotto.domain.model.Numbers
import kotlinx.coroutines.flow.Flow

@Dao
interface NumbersDao {

    @Query("SELECT * FROM numbers")
    fun getNumbers(): Flow<List<Numbers>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(numbers: Numbers)

    @Query("DELETE FROM numbers")
    fun deleteAll()
}