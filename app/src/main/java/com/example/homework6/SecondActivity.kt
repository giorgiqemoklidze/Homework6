package com.example.homework6

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.homework6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Homework6)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    fun init(){
         var sex ="male"
        if (binding.radioGroup.checkedRadioButtonId == -1) {
           sex=""
        }else{ if (binding.maleBtn.isChecked) {
            sex = "Male"
        } else if (binding.femaleBtn.isChecked) {
            sex = "Female"
        }
        }

        binding.submitBtn.setOnClickListener {

            var userInfo = UserInfo(binding.nameET.text.toString(),binding.lastNameET.text.toString(),binding.emailET.text.toString(),binding.birthDateET.text.toString(),sex)


            var intent = Intent()
            intent.putExtra("userInfo",userInfo)
            setResult(Activity.RESULT_OK,intent)
            finish()


        }
    }




}