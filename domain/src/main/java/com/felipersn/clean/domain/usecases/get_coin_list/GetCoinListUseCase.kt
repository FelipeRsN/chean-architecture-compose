package com.felipersn.clean.domain.usecases.get_coin_list

import com.felipersn.clean.core.common.Exceptions
import com.felipersn.clean.core.common.Resource
import com.felipersn.clean.data.remote.dto.toCoin
import com.felipersn.clean.domain.model.Coin
import com.felipersn.clean.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinListUseCase(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error(Exceptions.Unexpected(e.localizedMessage)))
        } catch (e: IOException) {
            emit(Resource.Error(Exceptions.Server()))
        }
    }
}