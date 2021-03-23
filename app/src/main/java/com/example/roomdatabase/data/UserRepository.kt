package com.example.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData : LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    fun deleteUser(id : Int){
        userDao.deleteData(id)
    }

    fun getById(id: Int){
        userDao.getById(id)
    }

    fun updateData(user : User) {
        userDao.updateData(user)
    }
}