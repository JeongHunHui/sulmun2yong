package com.sbl.sulmun2yong.survey.question

class SingleSelectionQuestion(
    override val id: Long,
    override val title: String,
    override val image: String?,
    override val description: String?,
    private val selections: Selections,
) : Question {
    override val questionType: QuestionType = QuestionType.SINGLE_SELECTION

    override fun getInfo() = QuestionInfo(id, questionType, title, image, description, selections.getInfo())

    override fun isValidResponse(response: List<String>) = response.size == 1 && selections.isContains(response)
}
