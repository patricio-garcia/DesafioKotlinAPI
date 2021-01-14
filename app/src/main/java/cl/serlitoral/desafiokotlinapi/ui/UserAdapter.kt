package cl.serlitoral.desafiokotlinapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.serlitoral.desafiokotlinapi.data.model.User
import cl.serlitoral.desafiokotlinapi.databinding.UserItemBinding

class UserAdapter: RecyclerView.Adapter<UserVH>() {

    private var items = listOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context))
        return  UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(list: List<User>) {
        items = list
        notifyDataSetChanged()
    }
}

class UserVH(val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: User) {
        binding.tvName.text = item.name
        binding.tvEmail.text = item.email
        binding.tvPhone.text = item.phone
    }
}