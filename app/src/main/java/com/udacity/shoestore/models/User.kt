package com.udacity.shoestore.models

import java.io.Serializable


data class User(val userEmail:String,val password:String):Serializable {
}