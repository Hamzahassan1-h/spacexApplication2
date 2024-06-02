package com.example.spacexapplication1.converter

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.usecase.Ships.GetShipsUseCase
import com.example.spacexapplication1.ui.compose.list.Ships.ShipItem
import com.example.spacexapplication1.ui.compose.list.Ships.ShipListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ShipsListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetShipsUseCase.Response, ShipListModel>(){

    override fun convertSuccess(data: GetShipsUseCase.Response): ShipListModel {
        return ShipListModel(
            items = data.ships.map {
                ShipItem(
                    active = it.active,
                    image = it.image,
                    shipType = it.shipId,
                    shipName = it.shipName,
                    shipId = it.shipId,
                    status = it.status,
                    url = it.url,
                    weightLbs = it.weightLbs,
                    yearBuilt = it.yearBuilt
                )
            }
        )
    }
}