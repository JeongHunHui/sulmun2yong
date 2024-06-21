package com.sbl.sulmun2yong.survey.question

class TextQuestion(
    override val id: Long,
    override val title: String,
    override val image: String?,
    override val description: String?,
) : Question {
    override val questionType: QuestionType = QuestionType.TEXT

    override fun getInfo() = QuestionInfo(id, questionType, title, image, description, null)

    override fun isValidResponse(response: List<String>) = response.size == 1
}
