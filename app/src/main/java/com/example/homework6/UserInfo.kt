package com.example.homework6

import android.os.Parcelable
import java.io.Serializable

data class UserInfo(var firstName:String, var lastName:String, var email:String, var birthDate:String,
                    var sex :String): Serializable