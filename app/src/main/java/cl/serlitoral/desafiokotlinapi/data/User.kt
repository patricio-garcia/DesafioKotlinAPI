package cl.serlitoral.desafiokotlinapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)

@Entity(tableName = "users_table")
data class UserEntity(
    @PrimaryKey
    @SerializedName("id")
    val userId: Int,
    @SerializedName("name")
    val userName: String,
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("phone")
    val userPhone: String
)