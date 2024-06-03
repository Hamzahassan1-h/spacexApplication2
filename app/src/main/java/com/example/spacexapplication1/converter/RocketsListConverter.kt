package com.example.spacexapplication1.converter

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.usecase.Rockets.GetRocketsUseCase
import com.example.spacexapplication1.ui.compose.list.Rockets.Rockets
import com.example.spacexapplication1.ui.compose.list.Rockets.RocketsListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RocketsListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetRocketsUseCase.Response, RocketsListModel>() {
    override fun convertSuccess(data: GetRocketsUseCase.Response): RocketsListModel {
        return RocketsListModel(
            items = data.rockets!!.map {
                Rockets(
                    description = it?.description,
                    id = it?.id,
                    rocketName = it?.rocketName,
                    company = it?.company,
                    costPerLaunch = it?.costPerLaunch,
                    country = it?.country
                )
            }
        )
    }


}