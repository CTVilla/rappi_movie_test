package ctorres.developer.movievisor.data.remote.dto


import com.google.gson.annotations.SerializedName
import ctorres.developer.movievisor.domain.model.SpokenLanguage

data class SpokenLanguageDto(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String
)

fun SpokenLanguageDto.toSpokenLanguage(): SpokenLanguage {
    return SpokenLanguage(englishName = englishName, iso6391 = iso6391, name = name)
}