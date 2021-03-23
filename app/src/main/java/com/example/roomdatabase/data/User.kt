package com.example.roomdatabase.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mst_user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    @Embedded
    val address: Address
)

data class Address(
    val address : String,
    val HomeNumber : Int
)