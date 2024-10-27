package ar.edu.unicen.seminario.dto

import com.google.gson.annotations.SerializedName

class GenreListDto (
    @SerializedName("genres")
    val genres : List<GenreDto>
)
{
}