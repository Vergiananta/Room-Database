package com.example.roomdatabase.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(val repository: UserRepository) : ViewModel() {

    fun addUser(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUser(user)
        }
    }

    fun readAllData() : LiveData<List<User>>{
        val getAll = repository.readAllData
        return getAll
    }

    fun updateData(){

    }

    fun getById(id : Int) {
        val getById = repository.getById(id)
        return getById
    }


}