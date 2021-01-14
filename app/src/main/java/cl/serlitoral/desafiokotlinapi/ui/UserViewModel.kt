package cl.serlitoral.desafiokotlinapi.ui

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.serlitoral.desafiokotlinapi.data.mapDB2API
import cl.serlitoral.desafiokotlinapi.domain.Repo
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val repo = Repo()

    val userList = Transformations.map(repo.userList) { entities ->
        entities.map { mapDB2API(it) }
    }

    init {
        viewModelScope.launch {
            repo.loadFromApi2DB()
        }
    }
}