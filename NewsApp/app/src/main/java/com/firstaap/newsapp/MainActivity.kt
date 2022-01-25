package com.firstaap.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val recyclerView: RecyclerView = findViewById(R.id.myRecyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

                val articlesList= ArrayList<NewArticle>()

                articlesList.add(NewArticle("The Apple Watch Series 7 is on sale for \$349 right now","https://s.yimg.com/os/creatr-uploaded-images/2022-01/6b0145c0-6bde-11ec-bfef-53db839eabc8"))
                articlesList.add(NewArticle("AirPods Pro 2 may come with lossless audio and a charging case that makes sound","https://cdn.vox-cdn.com/thumbor/LkMPRSMRNHGspL9xe3rGP-LgI0A=/0x146:2040x1214/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/19336099/cwelch_191031_3763_0003.jpg"))
                articlesList.add(NewArticle("Apple Watch's Life-Saving Potential Highlighted in Suspenseful '911' Ad","https://images.macrumors.com/t/PvHWwlMR5LrYla3IjTpwcep860o=/1600x/article-new/2022/01/apple-watch-911-ad.jpeg"))
                articlesList.add(NewArticle("Hong Kong media outlet Citizen News to shut down: ‘We are helpless’ - Global News", "https://globalnews.ca/wp-content/uploads/2022/01/CP146496222-e1641137237512.jpg?quality=85&strip=all&w=720&h=379&crop=1"))
                articlesList.add(NewArticle("NS COVID-19 roundup: delays in PCR tests results, hospitals impose tighter visitor restrictions - CTV News Atlantic", "https://www.ctvnews.ca/content/dam/ctvnews/en/images/2020/12/26/covid-19-test-1-5245545-1627388066486.jpg"))

                val adapter = CustomAdapter(articlesList)

                recyclerView.adapter = adapter

    }
}