package com.example.manageuserkotlinpractice.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.manageuserkotlinpractice.R
import kotlinx.android.synthetic.main.item_user_list.view.*


class UserAdapter(userList: ArrayList<String>?, listener: UserAdapterListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    interface UserAdapterListener {
        fun onClickDeleteUser(position: Int)
    }

    private var userList: ArrayList<String>? = userList
    private var context: Context? = null

    var listener: UserAdapterListener? = listener

    fun updateUserList(userList : ArrayList<String>?) {
        this.userList = userList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_user_list,
                parent,
                false
            )
            , listener
        )
    }

    override fun getItemCount(): Int {
        return userList?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvUsername.text = userList?.get(position)
    }

    class ViewHolder(itemView: View, listener: UserAdapterListener?) :
        RecyclerView.ViewHolder(itemView) {
        var tvUsername = itemView.tvUsername
        var tvClear = itemView.tvClear

        init {
            tvClear.setOnClickListener {
                listener?.onClickDeleteUser(adapterPosition)
            }
        }
    }
}