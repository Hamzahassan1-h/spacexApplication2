package com.example.data.Remote.Network.History


import com.google.gson.annotations.SerializedName

data class HistoryItemModel(
    @SerializedName("details")
    val details: String? = "",
    @SerializedName("event_date_unix")
    val eventDateUnix: Int? = 0,
    @SerializedName("event_date_utc")
    val eventDateUtc: String? = "",
    @SerializedName("flight_number")
    val flightNumber: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val title: String? = ""
)