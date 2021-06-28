package com.example.mvvm_practices_design_parttern.ui.profile

import android.content.Context
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_practices_design_parttern.databinding.ItemViewBinding
import com.example.mvvm_practices_design_parttern.model.Blog

class UserAdapter(val viewModel: UserViewModel, val arrayList: ArrayList<Blog>, val context: Context) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(val binding: ItemViewBinding, val viewModel: UserViewModel) : RecyclerView.ViewHolder(binding.root) {
        fun bind(blog: Blog) {
            binding.apply {
                title.text = blog.title
                delete.setOnClickListener {
                    viewModel.remove(blog)
                    notifyChange()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        if (arrayList.size == 0) {
            Toast.makeText(context, "List is Empty", Toast.LENGTH_LONG).show()
        } else {
        }
        return arrayList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //  val root =LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        //  return UserViewHolder()
        TODO()
    }

}
