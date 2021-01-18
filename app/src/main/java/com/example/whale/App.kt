package com.example.whale

import android.app.Application

class App : Application() {
    companion object
    {
        var addingfriend : Int = 0
        var leader_quest = 0
        var total_quest = 0
        var finish_quest = 0
        var name: String = ""

//팔로워 별 이름 넣는거
        var follower_1 = arrayListOf<String>("example@naver.com")
        var follower_2= arrayListOf<String>()
        var follower_3= arrayListOf<String>()
        var follower_4= arrayListOf<String>()
        var follower_5= arrayListOf<String>()
        var follower_6= arrayListOf<String>()

        var questList = arrayListOf<String>()
    }

}