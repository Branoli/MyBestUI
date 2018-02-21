package com.example.cuser.mybestui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    //private lateinit var adapter: AdapterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        my_recycler_view.layoutManager = linearLayoutManager


        Thread(Runnable {
            val client = OkHttpClient()
            val request = Request.Builder()
                    .url("https://api.github.com/users/Branoli/repos")
                    .build()
            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()
            val repos = Gson().fromJson(responseText, GitHubRepositoryInfo.List::class.java)

            runOnUiThread {
                val adapter = AdapterMainActivity(repos)
                my_recycler_view.adapter = adapter
            }
            android.util.Log.d("Repos", repos.joinToString { it.name })
        }).start()

        //val myDataset = arrayOf("1", "2", "3", "4", "5")
    }
}
