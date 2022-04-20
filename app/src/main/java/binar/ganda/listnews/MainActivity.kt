package binar.ganda.listnews

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.ganda.listnews.adapter.NewsAdapter
import binar.ganda.listnews.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapternews : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapternews = NewsAdapter()

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = adapternews

        getDataNews()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getDataNews() {
        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        viewModel.getLivedataNews().observe(this, Observer {
            if (it != null) {
                adapternews.setDataNews(it)
                adapternews.notifyDataSetChanged()
                Log.d("test", it.toString())
            }
        })
        viewModel.callApiNews()
    }


}