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
        var follower_2 = arrayListOf<String>("https://postfiles.pstatic.net/MjAyMTAxMThfMTgg/MDAxNjEwOTY5NTM1MTU0.NAEGuGN-ixjgIeg_USFEBQ1urrqYlKKU513rS3LySTgg.eWdBucFeiiJuqFHa6OLz62FnV2Cigm2sEnA4Hbo6748g.JPEG.tikibird/profile2.jpg?type=w773")
        var follower_3= arrayListOf<String>("https://postfiles.pstatic.net/MjAyMTAxMThfMTAx/MDAxNjEwOTY5NTM3NzQw.XAfWuXZpG7Bq7e5gdBiClWDABqABneTYwQWPmvKKnQgg.rs--sxiwnxdZ65SlMJexhueTZ1Iy61BEgLMcn9ZG450g.JPEG.tikibird/profile3.jpg?type=w773")
        var follower_4= arrayListOf<String>("https://postfiles.pstatic.net/MjAyMTAxMThfODkg/MDAxNjEwOTY5NTMzNTAz.MGxf7QgGbyQvozyWMHLJ57DlcrCGI5hNbSFCMg7McL4g.ZvtijW8nXAcMWvKOJCdxkO3w5q9Y9UW6XfmbGpVNC9Yg.JPEG.tikibird/profile1.jpg?type=w773")
        var follower_5 = arrayListOf<String>("https://postfiles.pstatic.net/MjAyMTAxMThfMTgg/MDAxNjEwOTY5NTM1MTU0.NAEGuGN-ixjgIeg_USFEBQ1urrqYlKKU513rS3LySTgg.eWdBucFeiiJuqFHa6OLz62FnV2Cigm2sEnA4Hbo6748g.JPEG.tikibird/profile2.jpg?type=w773")
        var follower_6= arrayListOf<String>("https://postfiles.pstatic.net/MjAyMTAxMThfMTAx/MDAxNjEwOTY5NTM3NzQw.XAfWuXZpG7Bq7e5gdBiClWDABqABneTYwQWPmvKKnQgg.rs--sxiwnxdZ65SlMJexhueTZ1Iy61BEgLMcn9ZG450g.JPEG.tikibird/profile3.jpg?type=w773")

        //팔로워 별 추가됐는지 안됐는지
        var true_1 = 0
        var true_2 = 0
        var true_3 = 0
        var true_4 = 0
        var true_5 = 0
        var true_6 = 0

        var questList = arrayListOf<String>()
    }

}