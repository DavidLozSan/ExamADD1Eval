package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import edu.iesam.examaad1eval.features.ex2.domain.Game

@Dao
interface Ex2Dao {

    @Insert
    fun insertAll(vararg games: List<Game>)
}