package com.example.loginstorage




import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


var nPre: SharedPreferences? = null
private var nEditor: SharedPreferences.Editor? = null
lateinit var email:EditText
lateinit var pass:EditText
lateinit var ncheck:CheckBox
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nPre = PreferenceManager.getDefaultSharedPreferences(this);
        nEditor = nPre?.edit();
        ncheck=findViewById(R.id.remember);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password)
        checkSharedPreferences();

    }

    fun checkSharedPreferences(){
        val check = nPre?.getString(getString(R.string.chekbox),"False");
        val name = nPre?.getString(getString(R.string.name),"False");
        val password = nPre!!.getString(getString(R.string.password), "")
        email.setText(name);
        pass.setText(password);
        if(check.equals("True")){
            ncheck.setChecked(true);
            var intent = Intent(this,details::class.java)
            intent.putExtra("name",name.toString())
            startActivity(intent)
        }else {
            ncheck.setChecked(false);
        }
    }

    fun Login(v:View){
        nEditor?.putString(getString(R.string.chekbox),"True");
        nEditor?.commit();
        val name: String = email.getText().toString()
        nEditor!!.putString(getString(R.string.name), name)
        nEditor!!.commit()
        val password: String = pass.getText().toString()
        nEditor!!.putString(getString(R.string.password), password)
        nEditor!!.commit()
        var intent = Intent(this,details::class.java)
        intent.putExtra("name",name.toString())
        startActivity(intent)
    }

}