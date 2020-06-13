package com.cs.home.ui.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs.home.model.home.Banner
import com.cs.home.model.home.Weather
import com.cs.lib_base.utils.BaseContext
import com.cs.lib_net.model.NetResult
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val bannerLiveData = MutableLiveData<List<Banner>>()
    private val weatherLiveData = MutableLiveData<List<Weather>>()

    fun getBannerLiveData(): MutableLiveData<List<Banner>> {
        return bannerLiveData
    }


    fun getBanner() {

        viewModelScope.launch {
            val banner = homeRepository.getBanner()
            if (banner is NetResult.Success) {
                bannerLiveData.postValue(banner.data)
            } else if (banner is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    banner.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    fun getWeatherLiveData(): MutableLiveData<List<Weather>> {
        return weatherLiveData
    }

    fun getWeather(key: String, city: String) {
        viewModelScope.launch {
            val weather = homeRepository.getWeather(key, city)
            if (weather is NetResult.Success) {
                weatherLiveData.postValue(weather.data)
            } else if (weather is NetResult.Error) {

            }
        }
    }

}