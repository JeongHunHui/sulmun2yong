package com.sbl.sulmun2yong

import com.sbl.sulmun2yong.draw.ImmediateDraw
import com.sbl.sulmun2yong.draw.Reward
import com.sbl.sulmun2yong.draw.RewardInfo
import com.sbl.sulmun2yong.member.Gender
import com.sbl.sulmun2yong.member.Member
import com.sbl.sulmun2yong.response.Answer
import com.sbl.sulmun2yong.response.Participant
import com.sbl.sulmun2yong.survey.Section
import com.sbl.sulmun2yong.survey.Survey
import com.sbl.sulmun2yong.survey.question.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class Sulmun2yongApplicationTests {
    @Test
    fun contextLoads() {
    }

    @Test
    fun `totalTest`() {
        val draw =
            ImmediateDraw(
                id = 1,
                targetCount = 10,
                reward =
                    Reward(
                        rewardInfos =
                            listOf(
                                RewardInfo(
                                    name = "스타벅스 아이스아메리카노 T 기프티콘",
                                    count = 5,
                                ),
                                RewardInfo(
                                    name = "BBQ 순살 황금올리브",
                                    count = 2,
                                ),
                            ),
                    ),
            )

        val member =
            Member(
                id = 1,
                gender = Gender.MALE,
                age = 25,
                job = "student",
                phoneNumber = "010-5378-8920",
            )

        val sections =
            listOf(
                Section(
                    id = 1,
                    title = "설문 제작 여부 조사",
                    description = null,
                    questions =
                        listOf(
                            SingleSelectionQuestion(
                                id = 1,
                                title = "설문을 제작한 경험이 있습니까?",
                                image = null,
                                description = null,
                                selections = Selections(selections = listOf(Selection("네"), Selection("아니요")), allowsOther = false),
                            ),
                        ),
                ),
                Section(
                    id = 2,
                    title = "설문 제작 경험 조사",
                    description = null,
                    questions =
                        listOf(
                            MultipleSelectionQuestion(
                                id = 2,
                                title = "설문을 제작할 때 어떤 점이 불편했나요?",
                                image = null,
                                description = null,
                                selections =
                                    Selections(
                                        selections = listOf(Selection("좋은 질문 만들기"), Selection("참가자 모집")),
                                        allowsOther = true,
                                    ),
                            ),
                            TextQuestion(
                                id = 3,
                                title = "왜 그렇게 생각했나요?",
                                image = null,
                                description = null,
                            ),
                        ),
                ),
                Section(
                    id = 3,
                    title = "설문 참여 경험 조사",
                    description = null,
                    questions =
                        listOf(
                            TextQuestion(
                                id = 4,
                                title = "설문에 참여하면서 어떤 점이 붏편했나요?",
                                image = null,
                                description = null,
                            ),
                        ),
                ),
            )

        val survey =
            Survey(
                id = 1,
                title = "설문 경험 조사",
                description = "설문을 제작하고 참여한 경험을 조사합니다.",
                sections = sections,
                endDate = LocalDate.parse("2024-06-30"),
                isPublished = true,
                makerId = 1,
                drawId = 1,
            )

        val participant1 = Participant.createMember(id = 1, member = member)
        val participant2 =
            Participant.createAnonymous(
                id = 2,
                gender = Gender.FEMALE,
                age = 31,
                job = "developer",
                phoneNumber = "010-1234-5678",
            )

        val response1 =
            survey.participate(
                id = 1,
                participantId = 1,
                answers =
                    listOf(
                        Answer(1, listOf("네")),
                        Answer(2, listOf("참가자 모집", "리워드 지급")),
                        Answer(3, listOf("참가자 모집을 위한 홍보 창구가 한정적이고, 리워드를 보내는 과정이 번거롭다.")),
                        Answer(4, listOf("설문의 소요 시간을 몰라서 답답했다.")),
                    ),
            )

        val response2 =
            survey.participate(
                id = 2,
                participantId = 2,
                answers =
                    listOf(
                        Answer(1, listOf("아니요")),
                        Answer(4, listOf("설문 당첨 결과가 나중에 나와서 답답하다.")),
                    ),
            )

        val responses = listOf(response1, response2)

        println(draw.draw(1, 1))

        assertThrows<IllegalArgumentException> {
            draw.draw(2, 1)
        }

        assertThrows<IllegalArgumentException> {
            draw.draw(1, 2)
        }

        println(draw.draw(2, 2))
    }
}
