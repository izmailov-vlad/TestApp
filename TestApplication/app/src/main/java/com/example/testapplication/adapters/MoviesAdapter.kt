package com.example.testapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.R
import com.example.testapplication.network.Result
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesAdapter(private var context: Context) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var inflater: LayoutInflater = LayoutInflater.from(context);
    private var movies: ArrayList<Result> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    fun setRepository(movies: ArrayList<Result>) {
        this.movies = movies
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = movies.get(position).display_title
        val description = movies.get(position).headline
        Glide.with(context)
            .load(movies[position].multimedia.src)
            .thumbnail(Glide.with(context).load(R.raw.loading))
            .fitCenter()
            .into(holder.image);

        holder.title.text = title
        holder.description.text = description
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.movie_photo
        var title: TextView = itemView.title
        var description: TextView = itemView.description
    }

}