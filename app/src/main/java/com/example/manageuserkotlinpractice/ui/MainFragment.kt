package com.example.manageuserkotlinpractice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.manageuserkotlinpractice.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), IMainView, UserAdapter.UserAdapterListener {

    companion object {
        fun newInstance(): Fragment {
            var fragment: Fragment = MainFragment()
            var args: Bundle = Bundle()

            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var presenter: MainPresenter
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onRestoreInstanceState()

        initInstance()
    }

    private fun onRestoreInstanceState() {

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun initInstance() {
        initPresenter()
        initAdapter()
    }

    private fun initPresenter() {
        presenter = MainPresenter()
    }

    private fun initAdapter() {
        userAdapter = UserAdapter(presenter.loadUserList(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewInstance()
    }

    private fun initViewInstance() {
        initPresenterView()
        initUserList()
        initAddButton()
        initClearAllButton()
    }

    private fun initPresenterView() {
        presenter.attachView(this)
    }


    private fun initUserList() {
        rvUserList.adapter = userAdapter
    }

    private fun initAddButton() {
        btnAddUser.setOnClickListener {
            presenter.addUser(etUsername.text.toString())
            etUsername.text?.clear()
        }
    }

    private fun initClearAllButton() {
        tvClearAll.setOnClickListener {
            presenter.clearAllUser()
        }
    }

    override fun showPleaseInputUser() {
        etUsername.error = "Please input username"
    }

    override fun updateUserList(userList: ArrayList<String>?) {
        userAdapter.updateUserList(userList)
        userAdapter.notifyDataSetChanged()
    }

    override fun onClickDeleteUser(position: Int) {
        presenter.deleteUser(position)
    }
}