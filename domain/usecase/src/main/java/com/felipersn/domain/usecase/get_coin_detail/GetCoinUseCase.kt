package com.felipersn.domain.usecase.get_coin_detail

import com.felipersn.clean.network.dto.toCoinDetail
import com.felipersn.core.utils.Exceptions
import com.felipersn.core.utils.Resource
import com.felipersn.domain.model.CoinDetail
import com.felipersn.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> =
        flow {
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