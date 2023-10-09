package com.peter.baekmooneibulyeoilta

abstract class Money(protected val amount: Int) {

    abstract fun times(multiplier: Int): Money

    abstract fun currency(): String

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount && this.javaClass == other.javaClass
    }

    companion object {
        // 팩토리 메서드
        fun dollar(amount: Int): Dollar {
            return Dollar(amount)
        }

        // 팩토리 메서드
        fun franc(amount: Int): Franc {
            return Franc(amount)
        }
    }
}