package com.example.myfirstapp.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstapp.presentation.api.CovidResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidViewModel: ViewModel() {

    val covidList : MutableLiveData<CovidModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        covidList.value = CovidLoader
        Singletons.covidApi.getCovidList().enqueue(object : Callback<List<CovidResponse>> {

            override fun onFailure(call: Call<List<CovidResponse>>, t: Throwable) {

                covidList.value = CovidError
            }

            override fun onResponse(call: Call<List<CovidResponse>>, response: Response<List<CovidResponse>>) {
                if (response.isSuccessful && response.body() != null) {
                    val covidResponse = response.body()!!
                    covidList.value = CovidSucess (covidResponse)
                }else {
                    covidList.value = CovidError
                }
            }

        })
    }
}