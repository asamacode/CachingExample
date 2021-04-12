package com.example.cachingexample.features.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cachingexample.api.RestaurantApi
import com.example.cachingexample.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by A SaMa on 11/04/2021 at 15:21.
 * GGApp
 * tranhuuluong888@gmail.com
 */
@HiltViewModel
class RestaurantViewModel @Inject constructor(
    api: RestaurantApi
) : ViewModel() {

    private val _restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = _restaurantsLiveData

    init {
        viewModelScope.launch {
            val response = api.getRestaurants()
            if (response.isSuccessful) {
                _restaurantsLiveData.value = response.body()
            }
        }
    }
}