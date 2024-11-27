package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val remote: MockEx1RemoteDataSource,
    private val local: Ex1XmlLocalDataSource
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val localUsers = local.getUsers()
        if (localUsers.isEmpty()) {
            val remoteUsers = remote.getUsers()
            local.saveListUsers(remoteUsers)
            return remoteUsers
        }
        return localUsers
    }

    override fun getItems(): List<Item> {
        val localItems = local.getItems()
        if (localItems.isEmpty()) {
            val remoteItems = remote.getItems()
            local.saveListItems(remoteItems)
            return remoteItems
        }
        return localItems
    }

    override fun getServices(): List<Services> {
        val localServices = local.getServices()
        if (localServices.isEmpty()) {
            val remoteServices = remote.getServices()
            local.saveListServices(remoteServices)
            return remoteServices
        }
        return localServices
    }
}