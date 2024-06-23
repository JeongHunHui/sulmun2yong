package com.sbl.sulmun2yong.draw

class ImmediateDraw(val id: Long, private val targetCount: Int, private val reward: Reward) {
    private val rewardBoard: RewardBoard = RewardBoard(targetCount, reward)
    private val drawRecords: MutableList<DrawRecord> = mutableListOf()

    fun draw(
        chooseNumber: Int,
        participantId: Long,
    ): RewardInfo? {
        if (drawRecords.any { it.participantId == participantId }) {
            throw IllegalArgumentException("Already draw")
        }
        if (drawRecords.any { it.number == chooseNumber }) {
            throw IllegalArgumentException("Already choose number")
        }
        drawRecords.add(DrawRecord(participantId, chooseNumber))
        val winningInfo = rewardBoard.getWinningInfo(chooseNumber)
        return winningInfo?.rewardInfo
    }
}
