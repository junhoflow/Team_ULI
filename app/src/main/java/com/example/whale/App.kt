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
        var whichOne: String = ""
        var name2: String = ""

//팔로워 별 이름 넣는거
        var follower_1 = arrayListOf<String>("example@naver.com")
        var follower_2 = arrayListOf<String>()
        var follower_3= arrayListOf<String>()
        var follower_4= arrayListOf<String>()
        var follower_5 = arrayListOf<String>()
        var follower_6= arrayListOf<String>()

        var questListFollower= arrayListOf<String>()

        //팔로워 별 추가됐는지 안됐는지
        var true_1 = 0
        var true_2 = 0
        var true_3 = 0
        var true_4 = 0
        var true_5 = 0
        var true_6 = 0

        var questList1 = arrayListOf<String>()
        var questList2 = arrayListOf<String>()
        var questList3 = arrayListOf<String>()
        var questList4 = arrayListOf<String>()
        var questList5 = arrayListOf<String>()
        var questList6 = arrayListOf<String>()
        var who : Int = 0
    }

}