package ctorres.developer.movievisor.data.remote.dto


import com.google.gson.annotations.SerializedName
import ctorres.developer.movievisor.domain.model.Genre

data class GenreDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

fun GenreDto.toGenre() : Genre {
    return Genre(id = id, name = name)
}