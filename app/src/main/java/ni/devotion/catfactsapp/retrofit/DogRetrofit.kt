package ni.devotion.catfactsapp.retrofit

import retrofit2.http.GET

interface DogRetrofit {
     @GET("random")
     suspend fun get(): List<DogNetworkEntity>
}