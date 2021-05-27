package id.ownkitchen.buyer.retrofit

import id.ownkitchen.buyer.model.LoginModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("photos")
    fun getPhotos():Call<List<LoginModel>>
}