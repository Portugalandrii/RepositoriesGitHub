package com.portugal.andrii.mytestgithub

data class GitHub(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)