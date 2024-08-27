package com.example.vodovoz.Network

import com.google.gson.annotations.SerializedName


data class Items (

    @SerializedName("status"  ) var status  : String?           = null,
    @SerializedName("message" ) var message : String?           = null,
    @SerializedName("TOVARY"  ) var TOVARY  : ArrayList<Tovary> = arrayListOf()

)