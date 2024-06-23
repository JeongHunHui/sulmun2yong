package com.sbl.sulmun2yong.response

import com.sbl.sulmun2yong.member.Gender
import com.sbl.sulmun2yong.member.Member

data class Participant private constructor(
    val id: Long,
    val memberId: Long?,
    val gender: Gender?,
    val age: Int?,
    val job: String?,
    val phoneNumber: String?,
) {
    companion object {
        fun createMember(
            id: Long,
            member: Member,
        ) = Participant(
            id = id,
            memberId = member.id,
            gender = member.gender,
            age = member.age,
            job = member.job,
            phoneNumber = member.phoneNumber,
        )

        fun createAnonymous(
            id: Long,
            gender: Gender?,
            age: Int?,
            job: String?,
            phoneNumber: String?,
        ) = Participant(id = id, memberId = null, gender = gender, age = age, job = job, phoneNumber = phoneNumber)
    }
}
