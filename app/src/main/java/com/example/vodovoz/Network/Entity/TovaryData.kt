package com.example.vodovoz.Network.Entity

import com.google.gson.annotations.SerializedName


data class TovaryData (

    @SerializedName("ID"                                         ) var ID                                   : String?                  = null,
    @SerializedName("IBLOCK_ID"                                  ) var IBLOCKID                             : String?                  = null,
    @SerializedName("NAME"                                       ) var NAME                                 : String?                  = null,
    @SerializedName("DETAIL_PICTURE"                             ) var DETAILPICTURE                        : String?                  = null,
    @SerializedName("PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE"    ) var PROPERTYTSENAZAEDINITSUTOVARAVALUE   : Int?                     = null,
    @SerializedName("PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE_ID" ) var PROPERTYTSENAZAEDINITSUTOVARAVALUEID : String?                  = null,
    @SerializedName("CATALOG_QUANTITY"                           ) var CATALOGQUANTITY                      : Int?                     = null,
    @SerializedName("CATALOG_VAT"                                ) var CATALOGVAT                           : String?                  = null,
    @SerializedName("EXTENDED_PRICE"                             ) var EXTENDEDPRICE                        : ArrayList<ExtendedPrice> = arrayListOf(),
    @SerializedName("PROPERTY_ZALOG_VALUE"                       ) var PROPERTYZALOGVALUE                   : Int?                     = null,
    @SerializedName("FAVORITE"                                   ) var FAVORITE                             : Boolean?                 = null,
    @SerializedName("KOFFICIENT"                                 ) var KOFFICIENT                           : Int?                     = null,

)