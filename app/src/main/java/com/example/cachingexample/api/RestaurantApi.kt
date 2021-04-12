package com.example.cachingexample.api

import com.example.cachingexample.data.Restaurant
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by A SaMa on 11/04/2021 at 14:38.
 * GGApp
 * tranhuuluong888@gmail.com
 */
interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): Response<List<Restaurant>>
}