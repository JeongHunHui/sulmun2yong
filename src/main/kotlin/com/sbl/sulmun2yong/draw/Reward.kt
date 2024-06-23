package com.sbl.sulmun2yong.draw

data class Reward(
    val rewardInfos: List<RewardInfo>,
) {
    fun getTotalCount() = rewardInfos.size
}
