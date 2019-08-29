package com.example.manageuserkotlinpractice.ui

interface IMainPresenter {
    fun clearAllUser()
    fun addUser(username: String)
    fun loadUserList(): ArrayList<String>?
    fun deleteUser(userPosition: Int)
}