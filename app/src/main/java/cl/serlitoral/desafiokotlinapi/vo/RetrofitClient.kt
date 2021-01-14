package cl.serlitoral.desafiokotlinapi.vo


import cl.serlitoral.desafiokotlinapi.domain.iWebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun RetrofitInstance():  iWebService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(iWebService::class.java)
        }
    }
}