package com.example.manageuserkotlinpractice.ui


class MainPresenter : IMainPresenter {

    var view: MainFragment? = null

    private var userList: ArrayList<String>? = null

    init {
        userList = ArrayList<String>()
    }

    fun attachView(view: MainFragment) {
        this.view = view
    }

    override fun loadUserList(): ArrayList<String>? {
        return userList
    }

    override fun clearAllUser() {
        userList?.clear()
        view?.updateUserList(loadUserList())
    }

    override fun addUser(username: String) {
        if (username.isEmpty()) {
            view?.showPleaseInputUser()
        } else {
            userList?.add(username)
            view?.updateUserList(loadUserList())
        }
    }

    override fun deleteUser(userPosition: Int) {
        userList?.removeAt(userPosition)
        view?.updateUserList(loadUserList())
    }
}