package com.sbl.sulmun2yong.survey.question

data class QuestionInfo(
    val id: Long,
    val questionType: QuestionType,
    val title: String,
    val image: String?,
    val description: String?,
    val selections: SelectionsInfo?,
)
