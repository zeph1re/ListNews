package binar.ganda.listnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.ganda.listnews.model.ResponseDataNewsItem
import binar.ganda.listnews.network.RetorfitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    lateinit var liveDataNews : MutableLiveData<List<ResponseDataNewsItem>>

    init {
        liveDataNews = MutableLiveData()
    }

    fun getLivedataNews() : MutableLiveData<List<ResponseDataNewsItem>> {
        return liveDataNews
    }

    fun callApiNews() {
        RetorfitClient.instance.getAllNews()
        .enqueue(object : Callback<List<ResponseDataNewsItem>>{
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful){
                    liveDataNews.postValue(response.body())
                }else{
                    liveDataNews.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                liveDataNews.postValue(null)
            }

        })
    }
}