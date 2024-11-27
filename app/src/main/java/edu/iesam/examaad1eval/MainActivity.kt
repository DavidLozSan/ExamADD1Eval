package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1() {
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
        val localDataSource = Ex1XmlLocalDataSource(this@MainActivity)
        val remoteDataSource = MockEx1RemoteDataSource()
        val ex1DataRepository = Ex1DataRepository(remoteDataSource, localDataSource)

        Log.d("@Ex1", ex1DataRepository.getUsers().toString())
        Log.d("@Ex1", ex1DataRepository.getItems().toString())
        Log.d("@Ex1", ex1DataRepository.getServices().toString())
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch(Dispatchers.IO) {
            //llamar a Room

            val localDataSource = Room.databaseBuilder(
                this@MainActivity,
                Ex2DbLocalDataSource::class.java, "database-name"
            ).build()

            val remoteDataSource = MockEx2RemoteDataSource()
            val ex2DataRepository = Ex2DataRepository(localDataSource, remoteDataSource)

            Log.d("Ex2", ex2DataRepository.getGames().toString())
        }


    }
}