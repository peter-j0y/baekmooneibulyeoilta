package com.peter.baekmooneibulyeoilta

class Dollar(amount: Int) : Money(amount) {
    override fun times(multiplier: Int): Money {
        return Dollar(amount * multiplier)
    }

    override fun currency(): String {
        return "USD"
    }
}