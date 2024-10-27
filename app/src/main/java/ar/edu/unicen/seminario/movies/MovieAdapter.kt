package ar.edu.unicen.seminario.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unicen.seminario.activities.MovieActivity
import ar.edu.unicen.seminario.databinding.ItemMovieBinding
import com.bumptech.glide.Glide

class MovieAdapter(
    private val movies : List<Movie>,
    private val onMovieClick:(Movie)->Unit
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.show(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater,parent,false)
        return MovieViewHolder(binding)
    }

    inner class MovieViewHolder(
        private val binding : ItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun show(movie: Movie){

            binding.movieName.text=movie.title
            binding.movieGenre.text=movie.genres

            Glide.with(itemView.context).load(movie.img).into(binding.movieImg)

            binding.root.setOnClickListener{
                onMovieClick(movie)
                val intent = Intent(itemView.context, MovieActivity::class.java)

                /*envio de parametros hacia la proxima pantalla*/
                intent.putExtra("MOVIE_TITLE", movie.title)
                intent.putExtra("MOVIE_IMAGE", movie.img)
                intent.putExtra("MOVIE_OVERVIEW",movie.overview)
                intent.putExtra("MOVIE_VOTE_AVERAGE",movie.voteAverage.toString())
                intent.putExtra("MOVIE_GENRES",movie.genres)

                // Inicia la nueva Activity
                itemView.context.startActivity(intent)
            }

        }
    }

}