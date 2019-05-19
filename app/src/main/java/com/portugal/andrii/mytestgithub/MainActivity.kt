package com.portugal.andrii.mytestgithub

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import android.view.inputmethod.InputMethodManager
import android.app.Activity


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnClickListener(){
           //скрываем клавиатуру (38,39)
            val inputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0)

            var input = searchText.text.toString().trim()

            if (input.isNullOrBlank()){
                        Toast.makeText(this@MainActivity, "ERROR!", Toast.LENGTH_SHORT).show()
            }
              else{

                var gitHub = GitInterface.create().getRepository(input!!)
                gitHub.enqueue(object : retrofit2.Callback<GitHub> {
                    override fun onFailure(call: Call<GitHub>, t: Throwable) {
                    }
                    override fun onResponse(call: Call<GitHub>, response: Response<GitHub>) {

                        recyclerView2.layoutManager=LinearLayoutManager(this@MainActivity)
                        var adapter:GitAdapter= GitAdapter(response.body()!!.items, this@MainActivity)
                        recyclerView2.adapter = adapter
                    }

                })

              }


            }
        }


    }
