package com.example.whale

import android.app.Application

class App : Application() {
    var count : Int = 0

    fun setValue(x: Int){
        this.count = x
    }

    fun getValue(): Int {
        return count
    }
}