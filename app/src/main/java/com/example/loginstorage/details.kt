package com.example.loginstorage


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.TextView


lateinit var name:TextView
private var nEditor: SharedPreferences.Editor? = null
class details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        nPre = PreferenceManager.getDefaultSharedPreferences(this);
        nEditor = nPre?.edit();
        name=findViewById(R.id.name)
        var string =intent.getStringExtra("name")
        name.setText(string.toString());
    }

    fun Logout(v:View){
          nPre = PreferenceManager.getDefaultSharedPreferences(this);
          nEditor!!.clear()
          nEditor!!.commit();
         var intent = Intent(this,MainActivity::class.java)
         startActivity(intent)
    }
}