package com.peter.baekmooneibulyeoilta

class Dollar(val amount: Int) {

    fun times(multiplier: Int): Dollar {
        val res = amount * multiplier
        return Dollar(res)
    }
}