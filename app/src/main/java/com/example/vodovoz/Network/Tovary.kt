package com.example.vodovoz.Network

import com.google.gson.annotations.SerializedName

data class Tovary (

    @SerializedName("ID"   ) var ID   : Int?            = null,
    @SerializedName("NAME" ) var NAME : String?         = null,
    @SerializedName("data" ) var data : ArrayList<TovaryData> = arrayListOf()

)