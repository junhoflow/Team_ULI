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

        var questList : ArrayList<ThingsTodo> = arrayListOf<ThingsTodo>(
            ThingsTodo("엄마카드로 학원비 결제하기", "200p"),
              ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
              ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
              ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"))

        //var todoList = arrayListOf<ThingsTodo>(
          //  ThingsTodo("엄마카드로 학원비 결제하기", "200p"),
          //  ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
          //  ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
          //  ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p")
       // )
    }

}