package com.chatserver.dd.chat.model
import com.google.gson.annotations.SerializedName


data class Status(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("online")
    val online: Int,
    @SerializedName("server_address")
    val serverAddress: String,
    @SerializedName("server_dateblock")
    val serverDateblock: String,
    @SerializedName("server_daystoblock")
    val serverDaystoblock: Int,
    @SerializedName("server_id")
    val serverId: String,
    @SerializedName("server_location")
    val serverLocation: String,
    @SerializedName("server_maxslots")
    val serverMaxslots: String,
    @SerializedName("server_name")
    val serverName: String,
    @SerializedName("server_type")
    val serverType: String,
    @SerializedName("status")
    val status: String
)

data class Data(
    @SerializedName("b")
    val b: B,
    @SerializedName("p")
    val p: List<P>,
    @SerializedName("s")
    val s: S,
    @SerializedName("t")
    val t: List<Any>
)

data class B(
    @SerializedName("c_port")
    val cPort: String,
    @SerializedName("ip")
    val ip: String,
    @SerializedName("q_port")
    val qPort: String,
    @SerializedName("s_port")
    val sPort: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("type")
    val type: String
)

data class P(
    @SerializedName("name")
    val name: String,
    @SerializedName("pid")
    val pid: Int,
    @SerializedName("score")
    val score: Int,
    @SerializedName("time")
    val time: String
)

data class S(
    @SerializedName("game")
    val game: String,
    @SerializedName("map")
    val map: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: Int,
    @SerializedName("players")
    val players: Int,
    @SerializedName("playersmax")
    val playersmax: Int
)