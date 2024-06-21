package com.sbl.sulmun2yong.survey.question

interface Question {
    val id: Long
    val questionType: QuestionType
    val title: String
    val image: String?
    val description: String?

    fun getInfo(): QuestionInfo

    fun isValidResponse(response: List<String>): Boolean
}
