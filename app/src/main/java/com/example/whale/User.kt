package com.example.whale

class User {

    var fullName: String? = null
    var age : String? = null
    var email : String? = null

    fun User() {}

    fun User(fullName: String?, age: String, email: String) {
        this.fullName = fullName
        this.age = age
        this.email = email
    }
}