package com.felipersn.clean.domain.usecases.get_coin_detail

import com.felipersn.clean.core.common.Exceptions
import com.felipersn.clean.core.common.Resource
import com.felipersn.clean.data.remote.dto.toCoinDetail
import com.felipersn.clean.domain.model.CoinDetail
import com.felipersn.clean.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinUseCase(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(Exceptions.Unexpected(e.localizedMessage)))
        } catch (e: IOException) {
            emit(Resource.Error(Exceptions.Server()))
        }
    }
}