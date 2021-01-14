package cl.serlitoral.desafiokotlinapi.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import cl.serlitoral.desafiokotlinapi.data.model.UserEntity

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: List<UserEntity>)

    @Query("SELECT * FROM user_table")
    fun getUsers(): LiveData<List<UserEntity>>

    @Database(entities = [UserEntity::class], version = 1)
    abstract class UserDB: RoomDatabase() {
        abstract fun userDao(): UserDAO
    }

    class UserApplication: Application() {
        companion object {
            var userDatabase: UserDB? = null
        }

        override fun onCreate() {
            super.onCreate()

            userDatabase = Room.databaseBuilder(this, UserDB::class.java, "user_db").build()
        }
    }
}