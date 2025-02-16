package com.curiousapps.emojme.domain

import dagger.hilt.android.scopes.ActivityScoped


@ActivityScoped
interface MoJiRepository {

    suspend fun fetchAllMojis(): Result<List<MoJis>>

    suspend fun fetchMeMoj(slug: String): Result<Moj>
}