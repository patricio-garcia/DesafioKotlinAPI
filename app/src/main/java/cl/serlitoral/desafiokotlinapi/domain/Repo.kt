package cl.serlitoral.desafiokotlinapi.domain

import android.util.Log
import cl.serlitoral.desafiokotlinapi.data.UserDAO
import cl.serlitoral.desafiokotlinapi.data.mapAPI2DB
import cl.serlitoral.desafiokotlinapi.vo.RetrofitClient

class Repo {

    private val userDatabse = UserDAO.UserApplication.userDatabase!!
    val userList = userDatabse.userDao().getUsers()

    suspend fun loadFromApi2DB() {
        val response = RetrofitClient.RetrofitInstance().getUsers()

        when(response.isSuccessful) {
            true -> {
                response.body()?.let { userList ->
                    val r = userList.map { mapAPI2DB(it) }
                    userDatabse.userDao().insertUser(r)
                }
            }
            false -> {
                Log.d("Repo Error: ", "${response.errorBody()}")
            }
        }
    }
}