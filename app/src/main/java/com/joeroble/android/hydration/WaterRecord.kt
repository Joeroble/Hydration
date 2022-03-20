package com.joeroble.android.hydration

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class WaterRecord(
    @PrimaryKey
    @NonNull
    val day: String,
    glasses: Int  // not var/val so can use custom getter & setter
    ) {
    companion object {
        const val MAX_GLASSES = 5
    }

    var glasses: Int = glasses
        set(value){
            if (value < 0 || value > MAX_GLASSES){
                throw IllegalArgumentException("Glasses must be between 0 and $MAX_GLASSES")
            }
            field = value
        }
    override fun toString(): String {
        return "Day=$day, Glasses=$glasses"
    }
}