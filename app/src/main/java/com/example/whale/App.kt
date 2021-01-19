package com.example.whale

import android.app.Application

class App : Application() {
    companion object {
        var addingfriend: Int = 0
        var leader_quest = 0

        var total_quest_ = 0
        var finish_quest_ = 0
        var total_quest1 = 0
        var finish_quest1 = 0
        var total_quest2 = 0
        var finish_quest2 = 0
        var total_quest3 = 0
        var finish_quest3 = 0
        var total_quest4 = 0
        var finish_quest4 = 0
        var total_quest5 = 0
        var finish_quest5 = 0
        var total_quest6 = 0
        var finish_quest6 = 0

        var name: String = ""
        var name3: String = ""


        var name_1: String = ""
        var name_2: String = ""
        var name_3: String = ""
        var name_4: String = ""
        var name_5: String = ""
        var name_6: String = ""


        //팔로워 별 이름 넣는거
        var follower_1 = arrayListOf<String>()
        var follower_2 = arrayListOf<String>()
        var follower_3 = arrayListOf<String>()
        var follower_4 = arrayListOf<String>()
        var follower_5 = arrayListOf<String>()
        var follower_6 = arrayListOf<String>()

        var questListFollower = arrayListOf<String>()
        var pointListFollower= arrayListOf<Int>()

        //팔로워 별 추가됐는지 안됐는지
        var true_1 = 0
        var true_2 = 0
        var true_3 = 0
        var true_4 = 0
        var true_5 = 0
        var true_6 = 0

        //유저 별 총 포인트
        var point = 0

        //리더가 퀘스트 선택한거 포인트 다 더해주는 변수
        var addPoint = 0

        //고래방생 수
        var whaleBye = 0

        var who: Int = 0

        var refreshing: Int = 1
        var refreshing2: Int = 1
    }

}