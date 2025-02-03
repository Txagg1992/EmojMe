package com.curiousapps.emojme.domain


import com.google.gson.annotations.SerializedName

data class MoJis(
    @SerializedName("character")
    var character: String,
    @SerializedName("codePoint")
    var codePoint: String,
    @SerializedName("group")
    var group: String,
    @SerializedName("slug")
    var slug: String,
    @SerializedName("subGroup")
    var subGroup: String,
    @SerializedName("unicodeName")
    var unicodeName: String
)