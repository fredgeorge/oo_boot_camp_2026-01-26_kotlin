/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.quantities

// Understands a specific metric
class Unit private constructor() {
    companion object {
        private val TEASPOON = Unit()
        private val TABLESPOON = Unit()
        private val OUNCE = Unit()
        private val CUP = Unit()
        private val PINT = Unit()
        private val QUART = Unit()
        private val GALLON = Unit()

        val Number.teaspoons get() = Quantity(this, TEASPOON)
        val Number.tablespoons get() = Quantity(this, TABLESPOON)
        val Number.ounces get() = Quantity(this, OUNCE)
        val Number.cups get() = Quantity(this, CUP)
        val Number.pints get() = Quantity(this, PINT)
        val Number.quarts get() = Quantity(this, QUART)
        val Number.gallons get() = Quantity(this, GALLON)

    }
}