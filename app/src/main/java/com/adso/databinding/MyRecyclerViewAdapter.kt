package com.adso.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.adso.databinging.R
import com.adso.databinging.databinding.CardItemBinding
import com.google.firebase.firestore.auth.User


class MyRecyclerViewAdapter

    (private val usersList:List<User>,
     private val clickListener: (User)->Unit
) : RecyclerView.Adapter<MyViewHolder>()

{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // inflating our layout file for each item of recycler view.

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : CardItemBinding = DataBindingUtil.
        inflate(layoutInflater, R.layout.card_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our list size.
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
// on below line we are adding click listener
        // to our recycler view item.
        holder.bind(usersList[position],clickListener)
    }


}

// on below line we are creating a view holder class.

class MyViewHolder(val binding: CardItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(user: User, clickListener: (User) -> Unit){
        binding.nameTextView.text = user.name
        binding.emailTextView.text = user.email

        binding.listItemLayout.setOnClickListener{
            clickListener(user)
        }

    }


}