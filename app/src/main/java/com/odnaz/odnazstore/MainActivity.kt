package com.odnaz.odnazstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth!!.currentUser
        if (currentUser == null) {
            loginActivity()
        }
    }

    fun loginActivity() {
        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_main, menu)
        return  true
    }

        override fun onOptionsItemSelected(item: MenuItem?) = when (item!!.itemId){
        R.id.action_signout ->{
            auth!!.signOut()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }
}
