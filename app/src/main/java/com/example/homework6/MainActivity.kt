package com.example.homework6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    public  final val myResultCode  = 1
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Homework6)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        binding.editBtn.setOnClickListener {
            var i = Intent(this, SecondActivity::class.java);
            startActivityForResult(i, myResultCode)


        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if ( resultCode == RESULT_OK) {

                var userInfo = data.getSerializableExtra("userInfo") as UserInfo
                binding.name.text = userInfo.firstName.toString()
                binding.lastName.text = userInfo.lastName.toString()
                binding.email.text = userInfo.email.toString()
                binding.birthData.text = userInfo.birthDate.toString()
                binding.sex.text = userInfo.sex.toString()


            }
        }else
        {
            Toast.makeText(applicationContext, "data aris null", Toast.LENGTH_SHORT).show()
        }
    }
}
