package ar.edu.unicen.seminario.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unicen.seminario.movies.Movie
import ar.edu.unicen.seminario.repository.ActivityMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepository: ActivityMoviesRepository
): ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get()= _loading

    private val _error = MutableLiveData<Boolean>()
    val error : LiveData<Boolean> get() = _error

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>get()=_movies

    fun getMovies(){

        viewModelScope.launch {
            _loading.value=true
            _error.value=false
            _movies.value= null

            val movies : List<Movie>? = moviesRepository.getMovies()
            _loading.value=false
            _movies.value= movies
            _error.value= (movies == null)
        }
    }
}