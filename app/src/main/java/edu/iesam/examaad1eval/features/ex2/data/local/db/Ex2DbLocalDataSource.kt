package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Ex2Entity::class], version = 2)
abstract class Ex2DbLocalDataSource : RoomDatabase() {
    abstract fun ex2Dao(): Ex2Dao
}