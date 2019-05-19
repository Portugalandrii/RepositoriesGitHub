package com.portugal.andrii.mytestgithub

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class GitAdapter(val items: List<Item>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        Glide.with(context).load(items[position].owner.avatar_url).into(vh?.avatar) //Установка рисунка с помощью Glide
        vh?.repositoryName?.text = items[position].full_name
        vh?.description?.text = items[position].description
        vh?.forks?.text = items[position].forks.toString()
        vh?.constraintLayout.setOnClickListener{
            //cоздаем интент
            val element = Intent(context, Element::class.java)
            //передаем поле name с класса items
            element.putExtra("repositoryName",items[position].name)
            //передаем поле login с класса owner с класса items
            element.putExtra("a",items[position].owner.login)
            //старт Activity Element
            startActivity(context,element,Bundle())

        }
    }
}
class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    var avatar = view.avatar
    var repositoryName = view.repository_name
    var description = view.description
    var forks = view.forks
    var constraintLayout = view.constraintLayout
}