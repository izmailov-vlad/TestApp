package com.example.testapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.testapplication.MovieApp
import com.example.testapplication.MovieListViewModel
import com.example.testapplication.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var movieListViewModel: MovieListViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieListViewModel = ViewModelProviders.of(this)
            .get(MovieListViewModel::class.java)

        fetchList()
    }

    private fun fetchList() {
        movieListViewModel.fetchQuestList((application as MovieApp).movieApi, movies, this)
    }
}