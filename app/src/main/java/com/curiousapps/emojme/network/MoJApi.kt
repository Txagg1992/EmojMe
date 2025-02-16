package com.curiousapps.emojme.network

import com.curiousapps.emojme.domain.MoJis
import com.curiousapps.emojme.domain.Moj
import com.curiousapps.emojme.util.MOJI_URL_EXT
import com.curiousapps.emojme.util.SINGLE_MOJ
import retrofit2.http.GET
import retrofit2.http.Path

interface MoJApi {

    @GET(MOJI_URL_EXT)
    suspend fun fetchAllMojis(): List<MoJis>

    @GET(SINGLE_MOJ)
    suspend fun fetchMeMoj(
        @Path("slug") slug: String
    ): Moj
}