package ar.edu.unicen.seminario.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import ar.edu.unicen.seminario.movies.MovieAdapter
import ar.edu.unicen.seminario.model.MoviesViewModel
import ar.edu.unicen.seminario.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //posterga la inicializacion de la variable
    private lateinit var binding : ActivityMainBinding

    //correcta implementacion para el MainModel
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding ahora tiene acceso a todas las variables de MainActivity
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Configura el GridLayoutManager con 2 columnas
        val layoutManager = GridLayoutManager(this, 2)
        binding.movieslist.layoutManager = layoutManager

        viewModel.getMovies()

        /*  logica que maneja el estado del loader
          * recarga de peliculas
          * informacion de error
         */

        viewModel.loading.observe(this){ loading->
            if(loading){
                binding.title.visibility= View.INVISIBLE
                binding.progressBar.visibility=View.VISIBLE
                binding.buttonCargar.isEnabled=false
            }else{
                binding.title.visibility= View.VISIBLE
                binding.progressBar.visibility=View.INVISIBLE
                binding.buttonCargar.isEnabled=true
            }
        }

        viewModel.movies.observe(this) { movies ->
            binding.movieslist.adapter= MovieAdapter(
                movies?: emptyList(),
                onMovieClick = { })
        }

        binding.buttonCargar.setOnClickListener{ viewModel.getMovies()
        }

        viewModel.error.observe(this){ error->
            if(error){
                binding.error.visibility=android.view.View.VISIBLE
            }
            else{
                binding.error.visibility=android.view.View.INVISIBLE
            }

        }

    }

}
