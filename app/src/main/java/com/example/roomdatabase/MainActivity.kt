package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.data.UserDatabase
import com.example.roomdatabase.data.UserRepository
import com.example.roomdatabase.data.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel(){
        userViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val userDao = UserDatabase.getDatabase(this@MainActivity).userDao()
                val userRepository = UserRepository(userDao)
                return UserViewModel(userRepository) as T
            }
        }).get(UserViewModel::class.java)
    }
}