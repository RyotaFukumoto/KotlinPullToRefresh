package com.example.kotlinpulltorefresh

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.kotlinpulltorefresh.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mCustomAdapter: CatsAdapter
    lateinit var mCatsList: ArrayList<Cat>
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setColorSchemeColors(Color.RED)
        swipeRefreshLayout.setOnRefreshListener {
            // 通信や更新処理を記載する
            Handler(Looper.getMainLooper()).postDelayed( {
                swipeRefreshLayout.isRefreshing = false
            }, 3000)
        }

        // データ一覧の実装
        val hijiki = Cat("ひじき")
        val thukushi = Cat("つくし")

        mCatsList = arrayListOf(hijiki, thukushi)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        // CustomAdapterの生成と設定
        mCustomAdapter = CatsAdapter(mCatsList)
        recyclerView.adapter = mCustomAdapter


    }
}