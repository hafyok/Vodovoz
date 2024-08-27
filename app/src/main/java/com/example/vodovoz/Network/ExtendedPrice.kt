package com.example.vodovoz.Network

import com.google.gson.annotations.SerializedName

data class ExtendedPrice (

    @SerializedName("PRICE"         ) var PRICE        : Int? = null,
    @SerializedName("OLD_PRICE"     ) var OLDPRICE     : Int? = null,
    @SerializedName("QUANTITY_FROM" ) var QUANTITYFROM : Int? = null,
    @SerializedName("QUANTITY_TO"   ) var QUANTITYTO   : Int? = null

)