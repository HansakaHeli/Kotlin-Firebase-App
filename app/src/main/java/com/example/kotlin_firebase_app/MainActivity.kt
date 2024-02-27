package com.example.kotlin_firebase_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Realtime Database reference
        //https://fir-kotlin-b3165-default-rtdb.firebaseio.com
        database = Firebase.database.reference

        // Write data to Firebase
        database.child("price").setValue("1999 $")

    }
}