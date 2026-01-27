/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.quantities

// Understands a specific metric
class Unit private constructor() {
    companion object {
        val TEASPOON = Unit()
        val TABLESPOON = Unit()
        val OUNCE = Unit()
        val CUP = Unit()
        val PINT = Unit()
        val QUART = Unit()
        val GALLON = Unit()
    }
}