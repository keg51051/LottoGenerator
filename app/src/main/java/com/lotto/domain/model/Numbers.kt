package com.lotto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Numbers(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val numbers: List<Int>,
    val timestamp: Long
)
