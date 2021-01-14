package cl.serlitoral.desafiokotlinapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.serlitoral.desafiokotlinapi.databinding.ActivityMainBinding
import cl.serlitoral.desafiokotlinapi.databinding.UserItemBinding
import cl.serlitoral.desafiokotlinapi.ui.UserAdapter
import cl.serlitoral.desafiokotlinapi.ui.UserViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UserAdapter()
        binding.rvUsers.adapter = adapter

        viewModel.userList.observe(this, {
            it?.let {
                adapter.update(it)
            }
        })
    }
}