package ar.edu.unicen.seminario.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.edu.unicen.seminario.databinding.ActivityMoviesBinding

import com.bumptech.glide.Glide

class MovieActivity: AppCompatActivity() {

    private lateinit var binding : ActivityMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieTitle = intent.getStringExtra("MOVIE_TITLE")
        val movieImage = intent.getStringExtra("MOVIE_IMAGE")
        val movieOverview = intent.getStringExtra("MOVIE_OVERVIEW")
        val movieAverage = intent.getStringExtra("MOVIE_VOTE_AVERAGE")
        val moviegenres = intent.getStringExtra("MOVIE_GENRES")

        binding.title.text=movieTitle
        binding.synopsis.text=movieOverview
        binding.rating.text=movieAverage.toString()
        binding.genres.text=moviegenres

        Glide.with(this).load(movieImage).into(binding.movieImg)

        binding.navegarMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            //combinacion de flag que permite desapilar y volver al main inicial
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)

        }

    }
}