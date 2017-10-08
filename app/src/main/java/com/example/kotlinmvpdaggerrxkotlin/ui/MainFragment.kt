package com.example.kotlinmvpdaggerrxkotlin.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.kotlinmvpdaggerrxkotlin.GithubApp
import com.example.kotlinmvpdaggerrxkotlin.R
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.kotlinmvpdaggerrxkotlin.data.model.GithubAccount


class MainFragment : Fragment(), MainScreenView {

    @Inject
    lateinit var mainScreenPresenter: MainScreenPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GithubApp.instance!!.appComponent!!.inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        mainScreenPresenter!!.setView(this)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ed_search_term.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(textView: TextView, actionId: Int, keyEvent: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mainScreenPresenter.geGithubAccountInfo(ed_search_term.text.toString())
                    return true
                }
                return false
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainScreenPresenter!!.clearTasks()
    }


    override fun showAccountInfo(githubAccount: GithubAccount?) {
        if (githubAccount?.name == null) {
            tv_result.setText(R.string.not_found);
        } else {
            tv_result.setText("${githubAccount.name} \n ${githubAccount.createdAt}")
        }
    }

    override fun showError(err: String) {
        val builder = AlertDialog.Builder(getContext())
        builder.setMessage("Something unexpected happened!")
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id -> })
        val alert = builder.create()
        alert.show()
    }


    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }



    companion object {

        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}