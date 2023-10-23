package com.example.firstcomposesteps

interface Pager<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}