package com.portugal.andrii.mytestgithub

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitInterface {
@GET("search/repositories")
fun getRepository(@Query("q") query: String): Call<GitHub>
@GET("repos/{reposname}/{projectname}/subscribers")
fun getSubscrabers(@Path("reposname")query: String,@Path("projectname")project: String): Call<List<Logins>>

    companion object {   // сингитон - статический объект одиночка, для обращения к которому не требуется создание класса

        var BASE_URL = "https://api.github.com/"

        fun create() : GitInterface {    //эта функция реализует интерфейс BankService с помощью класса Retrofit

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(GitInterface::class.java)

        }
    }
}