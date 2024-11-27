package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(
    private val local: Ex2DbLocalDataSource,
    private val remote: MockEx2RemoteDataSource
) : Ex2Repository {

    override suspend fun getGames(): List<Game> {
        val remote = remote.getGames()
        local.ex2Dao().insertAll(remote)
        return remote
    }
}