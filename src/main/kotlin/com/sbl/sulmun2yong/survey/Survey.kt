package com.sbl.sulmun2yong.survey

import com.sbl.sulmun2yong.response.Answer
import com.sbl.sulmun2yong.response.Response
import java.time.LocalDate

data class Survey(
    val id: Long,
    val title: String,
    val description: String,
    val sections: List<Section>,
    val endDate: LocalDate,
    val isPublished: Boolean,
    val makerId: Long,
    val drawId: Long?,
) {
    fun participate(
        id: Long,
        participantId: Long,
        answers: List<Answer>,
    ): Response {
        if (!isPublished) {
            throw IllegalStateException("Cannot participate in an unpublished survey")
        }

        if (LocalDate.now() > endDate) {
            throw IllegalStateException("Cannot participate in a survey that has ended")
        }

        return Response(id, this.id, participantId, answers)
    }
}
