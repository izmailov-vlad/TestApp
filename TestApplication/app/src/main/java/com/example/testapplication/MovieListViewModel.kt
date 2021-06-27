package com.example.testapplication


import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MovieListViewModel (application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable();

    override fun onCleared() {
        compositeDisposable.dispose();
        super.onCleared()
    }

    fun fetchQuestList(movieApi: MovieApi, movies: RecyclerView, context: Context){
         compositeDisposable.add(
             movieApi.getReviews("Ao5GHRLMh0HJRVnC45tfbrjwUYWtqpL4")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                val moviesAdapter = MoviesAdapter(context)
                moviesAdapter.setRepository(it.results)
                movies.adapter = moviesAdapter
            }, {
                Log.e("TAG",it.message.toString())
            }
            ))
    }
}