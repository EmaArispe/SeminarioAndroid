package ar.edu.unicen.seminario.dto

import ar.edu.unicen.seminario.movies.Movie
import com.google.gson.annotations.SerializedName

data class ActivityMoviesDto (

    @SerializedName("id")
    val id : Int,
    @SerializedName("original_title")
    val original_title:String,
    @SerializedName("poster_path")
    val poster_path : String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("vote_average")
    val vote_average : Double,
    @SerializedName("genre_ids")
    val genre_ids : List<Int>
    )

{
    /*Convierte dto en Movie*/
    fun toActivityMovies(genresMap: Map<Int, String>): Movie {

        val genres = if (genre_ids.isNullOrEmpty()) {
            "Unknown" // valor por defecto si no se encuentran generos
        } else {
            genre_ids.mapNotNull { genresMap[it] } //mapeo y concatenacion a un solo string
                .joinToString(", ")
        }

        return Movie(
            id = id,
            title = original_title,
            img = "https://image.tmdb.org/t/p/original/"+poster_path,
            overview = overview,
            voteAverage = vote_average,
            genres = genres //genero completo
        )
    }
}

