package com.example.kotlin_firebase_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView:TextView = findViewById(R.id.textView)

        // Realtime Database reference
        //https://fir-kotlin-b3165-default-rtdb.firebaseio.com
        // Get reference form google-serveces.json
        database = Firebase.database.reference

        // Writing custom object to firebase
        val user1 = User("Jack", "123")

        // Write data to Firebase
        database.child("Users").setValue(user1)

        // Reading custom object from firebase
        val pe = object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val u1 = snapshot.getValue<User>()
                textView.text = u1.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }

        database.child("Users").addValueEventListener(pe)


//        // Write data to Firebase
//        database.child("price").setValue("1999 $")
//
//        val postListener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val gold_price = snapshot.value
//                textView.text = gold_price.toString()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        }
//
//        database.child("price").addValueEventListener(postListener)

    }
}