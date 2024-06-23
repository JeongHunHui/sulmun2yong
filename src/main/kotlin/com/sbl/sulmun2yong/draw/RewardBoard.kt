package com.sbl.sulmun2yong.draw

import kotlin.random.Random

data class RewardBoard(val targetCount: Int, val reward: Reward) {
    private val winningInfos: List<WinningInfo>

    init {
        val randomPositions = mutableSetOf<Int>()
        while (randomPositions.size < reward.getTotalCount()) {
            randomPositions.add(Random.nextInt(0, targetCount))
        }

        winningInfos =
            reward.rewardInfos.map {
                val number = randomPositions.random()
                randomPositions.remove(number)
                WinningInfo(it, number)
            }
    }

    fun getWinningInfo(number: Int): WinningInfo? {
        return winningInfos.find { it.number == number }
    }
}
