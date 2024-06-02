package com.example.spacexapplication1.converter

import android.content.Context
import com.example.common.state.CommonResultConverter

import com.example.domain.usecase.Launches.GetLaunchesUseCase
import com.example.spacexapplication1.ui.compose.list.Launches.Launches
import com.example.spacexapplication1.ui.compose.list.Launches.LaunchesListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LaunchesListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetLaunchesUseCase.Response, LaunchesListModel>(){

    override fun convertSuccess(
        data: GetLaunchesUseCase.Response
    ): LaunchesListModel {
        return LaunchesListModel(
            items = data.launches!!.map {
                Launches(
                    details = it?.details,
                    flightNumber = it?.flightNumber,
                    launchSuccess = it?.launchSuccess,
                    launchYear = it?.launchYear,
                    missionName = it?.missionName,

                    )
            }
        )
    }

}