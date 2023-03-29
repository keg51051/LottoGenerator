package com.lotto.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lotto.domain.model.Numbers

@Database(
    entities = [Numbers::class],
    version = 1
)
abstract class NumbersDB: RoomDatabase() {
    abstract val numbersDao: NumbersDao
}