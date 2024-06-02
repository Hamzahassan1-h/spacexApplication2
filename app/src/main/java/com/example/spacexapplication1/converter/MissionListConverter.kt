package com.example.spacexapplication1.converter

import android.content.Context
import com.example.common.state.CommonResultConverter

import com.example.domain.usecase.Missions.GetMissionsUseCase
import com.example.spacexapplication1.ui.compose.list.Missions.Mission
import com.example.spacexapplication1.ui.compose.list.Missions.MissionsListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MissionListConverter @Inject constructor(
    @ApplicationContext private val context: Context
): CommonResultConverter<GetMissionsUseCase.Response, MissionsListModel>() {
    override fun convertSuccess(data: GetMissionsUseCase.Response): MissionsListModel {
        return MissionsListModel(
            items = data.missions!!.map {
                Mission(
                    description = it?.description,
                    missionId = it?.missionId,
                    missionName = it?.missionName,
                )
            }
        )
    }


}