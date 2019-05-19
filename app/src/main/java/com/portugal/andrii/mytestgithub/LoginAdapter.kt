package com.portugal.andrii.mytestgithub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.logins.view.*


class LoginAdapter(val logins:List<Logins>,val context: Context): RecyclerView.Adapter<ViewHolder1>(){
    override fun onCreateViewHolder(vg: ViewGroup, position: Int): ViewHolder1 {
       return ViewHolder1(LayoutInflater.from(context).inflate(R.layout.logins,vg,false))
    }

    override fun getItemCount(): Int {
        return logins.size
    }

    override fun onBindViewHolder(vh: ViewHolder1, p1: Int) {
        vh?.login.text = logins.get(p1).login
    }


}

class ViewHolder1 (view: View):RecyclerView.ViewHolder(view){
    var login = view.login
}