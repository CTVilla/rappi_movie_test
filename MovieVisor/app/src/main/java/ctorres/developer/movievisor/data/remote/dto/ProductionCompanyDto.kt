package ctorres.developer.movievisor.data.remote.dto


import com.google.gson.annotations.SerializedName
import ctorres.developer.movievisor.domain.model.ProductionCompany

data class ProductionCompanyDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)

fun ProductionCompanyDto.toProductionCompany(): ProductionCompany {
    return ProductionCompany(id= id, logoPath = logoPath, name = name, originCountry = originCountry)
}