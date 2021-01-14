package cl.serlitoral.desafiokotlinapi.domain

import cl.serlitoral.desafiokotlinapi.data.model.User
import retrofit2.Response
import retrofit2.http.GET


interface iWebService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}