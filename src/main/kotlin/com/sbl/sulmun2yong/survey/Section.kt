package com.sbl.sulmun2yong.survey

import com.sbl.sulmun2yong.survey.question.Question

data class Section(
    val id: Long,
    val title: String,
    val description: String?,
    val questions: List<Question>,
)
