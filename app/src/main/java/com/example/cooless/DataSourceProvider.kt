package com.example.cooless

import com.example.cooless.API.CloverlyInterface
import com.example.cooless.POJOs.OffsetLocation
import com.example.cooless.POJOs.OffsetMatch
import com.example.cooless.POJOs.OffsetRequest
import com.example.cooless.POJOs.OffsetWeight
import com.example.cooless.model.OffsetOption
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DataSourceProvider {

    val offsetDataSource: OffsetDataSource by lazy { OffsetDataSourceImpl(APIProvider.offsetService) }
}

interface OffsetDataSource {

    fun getOffsetOptions(from: String, mass: Int): Single<List<OffsetOption>>
}

class OffsetDataSourceImpl(private val service: CloverlyInterface) : OffsetDataSource {
    override fun getOffsetOptions(from: String, mass: Int): Single<List<OffsetOption>> {
        val offsetRequest = OffsetRequest(
            OffsetWeight(mass, "kg"),
            OffsetMatch(OffsetLocation(from))
        )

        return service.getOffset(offsetRequest)
            .subscribeOn(Schedulers.io())
            .map {
                listOf(
                    OffsetOption(it.slug, it.offset.OffsetName, it.totalCostCents / 100f)
                )
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}