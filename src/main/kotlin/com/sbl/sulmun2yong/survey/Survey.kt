package com.sbl.sulmun2yong.survey

import java.util.Date

data class Survey(
    private val id: Long,
    private val title: String,
    private val description: String,
    private val sections: List<Section>,
    private val endDate: Date,
    private val isPublished: Boolean,
    private val makerId: Long,
)
