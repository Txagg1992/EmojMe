package com.curiousapps.emojme.network

import com.curiousapps.emojme.domain.MoJis
import com.curiousapps.emojme.util.MOJI_URL_EXT
import retrofit2.http.GET

interface MoJApi {

    @GET(MOJI_URL_EXT)
    suspend fun fetchAllMojis(): List<MoJis>
}