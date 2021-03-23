package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM mst_user ORDER BY id asc")
    fun readAllData() : LiveData<List<User>>

    @Update
    fun updateData(user : User)

    @Delete
    fun deleteData(id: Int)

    @Query("SELECT * FROM mst_user WHERE id = :id")
    fun getById(id: Int) : LiveData<List<User>>
}