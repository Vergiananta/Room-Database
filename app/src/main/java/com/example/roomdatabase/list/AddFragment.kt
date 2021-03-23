package com.example.roomdatabase.list

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        add_button.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val firstName = input_firstname.text.toString()
        val lastName = input_lastname.text.toString()
        val age = input_age.text

        if (inputCheck(firstName, lastName, age)){
            //mebuat object user
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))

            //add data to database
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Success added", Toast.LENGTH_LONG).show()

            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName : String, lastName : String, age : Editable) : Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddFragment()
    }
}