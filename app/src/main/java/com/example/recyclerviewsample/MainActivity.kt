package com.example.recyclerviewsample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.recyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        val adapter = LinkListAdapter()
        binding.recyclerView.also {
            it.adapter = adapter
            it.addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        val linkList = listOf(
            ListItemModel("Google", "https://www.google.com", {}),
            ListItemModel("Yahoo", "https://www.yahoo.com", {}),
            ListItemModel("Bing", "https://www.bing.com", {}),
            ListItemModel("DuckDuckGo", "https://www.duckduckgo.com", {}),
            ListItemModel("Baidu", "https://www.baidu.com", {}),
            ListItemModel("Yandex", "https://www.yandex.com", {}),
            ListItemModel("Ask", "https://www.ask.com", {}),
            ListItemModel("AOL", "https://www.aol.com", {}),
        )
        adapter.submitList(linkList)
    }
}