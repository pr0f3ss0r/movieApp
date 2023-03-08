package com.example.moviedatabaseapp.data.model.tvshow


import androidx.room.*
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

@Entity
data class TvShow(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: List<String>?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("poster_path")
    val posterPath: String?
)


class Converters{
    @TypeConverter
    fun fromString(value: String?): List<String>{
        val gson = Gson()
        val type = object: TypeToken<List<String>>() {}.type
        return  gson.fromJson(value, type)
    }
    @TypeConverter
    fun fromList(list: List<String>?): String{
        val gson = Gson()
        val type = object: TypeToken<List<String>>() {}.type
        return  gson.toJson(list, type)
    }
}
