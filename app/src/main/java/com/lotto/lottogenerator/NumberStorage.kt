package com.lotto.lottogenerator

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
class NumberStorage {
    @PrimaryKey(autoGenerate = true)
    val id = 0
    val numbers = arrayOf<Int>()
}