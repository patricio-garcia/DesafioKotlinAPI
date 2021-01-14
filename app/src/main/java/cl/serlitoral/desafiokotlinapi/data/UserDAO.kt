package cl.serlitoral.desafiokotlinapi.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import cl.serlitoral.desafiokotlinapi.data.model.UserEntity

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun intertUser(userEntity: List<UserEntity>)

    @Query("SELECT * FROM users_table")
    fun getUsers(): LiveData<List<UserEntity>>

    @Database(entities = [UserEntity::class], version = 1)
    abstract class UserDatabse: RoomDatabase() {
        abstract fun userDao(): UserDAO
    }

    class UserApplication: Application() {
        companion object {
            var userDatabase: UserDatabse? = null
        }

        override fun onCreate() {
            super.onCreate()

            userDatabase = Room.databaseBuilder(this, UserDatabse::class.java, "user_db").build()
        }
    }
}