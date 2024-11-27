package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1XmlLocalDataSource(private val context: Context) {

    val sharedPref = context.getSharedPreferences("db-exam", Context.MODE_PRIVATE)


    fun saveListUsers(users: List<User>) {

    }

    fun getUsers(): List<User> {
        return TODO()
    }

    fun saveListItems(items: List<Item>) {

    }

    fun getItems(): List<Item> {
        return TODO()
    }

    fun saveListServices(services: List<Services>) {

    }

    fun getServices(): List<Services> {
        return TODO()
    }
}