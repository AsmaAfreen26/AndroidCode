package  com.example.googlebooks.datasources

import com.google.gson.annotations.SerializedName


data class Pdf (

  @SerializedName("isAvailable"  ) var isAvailable  : Boolean? = null,
  @SerializedName("acsTokenLink" ) var acsTokenLink : String?  = null

)