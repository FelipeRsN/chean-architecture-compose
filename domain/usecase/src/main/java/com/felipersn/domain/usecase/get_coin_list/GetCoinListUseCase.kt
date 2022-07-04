package com.felipersn.domain.usecase.get_coin_list

import com.felipersn.clean.network.dto.toCoin
import com.felipersn.core.utils.Exceptions
import com.felipersn.core.utils.Resource
import com.felipersn.domain.model.Coin
import com.felipersn.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    Exceptions.Unexpected(
                        e.localizedMessage
                    )
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(Exceptions.Server()))
        }
    }
}