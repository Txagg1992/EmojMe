package com.curiousapps.emojme.data

import com.curiousapps.emojme.domain.MoJiRepository
import com.curiousapps.emojme.domain.MoJis
import com.curiousapps.emojme.network.MoJApi
import okio.IOException

class MoJiRepositoryImpl(
    private val api: MoJApi
): MoJiRepository {
    override suspend fun fetchAllMojis(): Result<List<MoJis>> {
        try {
            api.fetchAllMojis().let {
                return Result.success(it)
            }
        }catch (e: IOException){
            return Result.failure(e)
        }
    }


}