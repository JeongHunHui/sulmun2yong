package com.sbl.sulmun2yong.response

data class Response(
    val id: Long,
    val surveyId: Long,
    val participantId: Long,
    val answers: List<Answer>,
)
