package com.portugal.andrii.mytestgithub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_element.*
import retrofit2.Call
import retrofit2.Response

class Element : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element)
        fullname.setText(intent.getStringExtra("repositoryName"))
        listsubscribers.layoutManager = LinearLayoutManager(this)
        GitInterface.create().getSubscrabers(intent.getStringExtra("a"),intent.getStringExtra("repositoryName"))
            .enqueue(object :retrofit2.Callback<List<Logins>>{
                override fun onFailure(call: Call<List<Logins>>, t: Throwable) {
                }
                override fun onResponse(call: Call<List<Logins>>, response: Response<List<Logins>>) {
                   count.setText(response.body()?.size.toString())
                   listsubscribers.adapter = response.body()?.let { LoginAdapter(it,this@Element) }

                }

            })
    }
}
