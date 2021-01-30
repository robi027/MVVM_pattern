package com.example.mvvm_pattern.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_pattern.R
import com.example.mvvm_pattern.data.api.ApiHelper
import com.example.mvvm_pattern.data.api.RetrofitBuilder
import com.example.mvvm_pattern.data.model.Meal
import com.example.mvvm_pattern.ui.main.viewmodel.MainViewModel
import com.example.mvvm_pattern.ui.base.ViewModelFactory
import com.example.mvvm_pattern.ui.main.adapter.MainAdapter
import com.example.mvvm_pattern.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProviders.of(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
                .get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recycleView.addItemDecoration(
            DividerItemDecoration(
                recycleView.context,
                (recycleView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recycleView.adapter = adapter
    }

    private fun setupObservers() {
        val query: MutableMap<String, String> = mutableMapOf()
        query.put("s", "");
        viewModel.getMeals(query).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        resource.data?.let { meals -> retrieveList(meals.meals) }
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

    private fun retrieveList(meals: List<Meal>) {
        adapter.apply {
            addMeals(meals)
            notifyDataSetChanged()
        }
    }
}