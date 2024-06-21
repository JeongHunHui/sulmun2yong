package com.sbl.sulmun2yong.survey.question

class Selections(private val selections: List<Selection>, private val allowsOther: Boolean) {
    fun isContains(input: List<String>): Boolean {
        if (input.isEmpty()) {
            return false
        }
        if (allowsOther) {
            return true
        }
        return selections.map { it.content }.containsAll(input)
    }

    fun getInfo() = SelectionsInfo(selections, allowsOther)
}
