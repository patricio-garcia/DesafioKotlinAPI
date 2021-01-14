package cl.serlitoral.desafiokotlinapi.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val id: Int,
    @ColumnInfo(name = "user_name")
    val name: String,
    @ColumnInfo(name = "user_email")
    val email: String,
    @ColumnInfo(name = "user_phone")
    val phone: String
)