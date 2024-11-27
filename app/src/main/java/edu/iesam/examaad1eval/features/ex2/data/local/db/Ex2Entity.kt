package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.domain.Player

const val TABLE_NAME = "Ex2_games"
const val PRIMARY_KEY = "game_id"

@Entity(tableName = TABLE_NAME)
data class Ex2Entity(
    @PrimaryKey @ColumnInfo(name = PRIMARY_KEY) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @Embedded @ColumnInfo(name = "players") val players: List<Player>
)