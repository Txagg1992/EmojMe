package com.curiousapps.emojme.data

import com.curiousapps.emojme.domain.MoJiRepository
import com.curiousapps.emojme.domain.MoJis
import com.curiousapps.emojme.domain.Moj
import com.curiousapps.emojme.network.MoJApi
import okio.IOException
import javax.inject.Inject

class MoJiRepositoryImpl @Inject constructor (
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

    override suspend fun fetchMeMoj(slug: String): Result<Moj> {
        try {
            api.fetchMeMoj(slug).let {
                return Result.success(it)
            }
        }catch (e: IOException){
            return Result.failure(e)
        }
    }


}