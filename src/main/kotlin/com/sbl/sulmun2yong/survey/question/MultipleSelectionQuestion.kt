package com.sbl.sulmun2yong.survey.question

class MultipleSelectionQuestion(
    override val id: Long,
    override val title: String,
    override val image: String?,
    override val description: String?,
    private val selections: Selections,
) : Question {
    override val questionType: QuestionType = QuestionType.MULTIPLE_SELECTION

    override fun getInfo() = QuestionInfo(id, questionType, title, image, description, selections.getInfo())

    override fun isValidResponse(response: List<String>) = response.isNotEmpty() && selections.isContains(response)
}
