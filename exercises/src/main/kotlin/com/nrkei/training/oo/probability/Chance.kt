/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.probability

import com.nrkei.training.oo.order.Orderable

// Understands the likelihood of something specific occurring
class Chance(likelihoodAsFraction: Number) : Orderable<Chance> {
    companion object {
        private const val CERTAIN_FRACTION = 1.0
        private const val EPSILON = 1e-10
    }

    init {
        require(likelihoodAsFraction.toDouble() in 0.0..CERTAIN_FRACTION)
        { "Likelihood value must be between 0.0 and 1.0" }
    }

    private val fraction = likelihoodAsFraction.toDouble()

    override fun equals(other: Any?) =
        this === other || other is Chance && this.equals(other)

    private fun equals(other: Chance) =
        ((this.fraction - other.fraction) / EPSILON) < EPSILON

    override fun hashCode() = (fraction / EPSILON).toLong().hashCode()

    operator fun not() = Chance(CERTAIN_FRACTION - fraction)

    infix fun and(other: Chance) = Chance(this.fraction * other.fraction)

    // Implemented with DeMorgan's Law https://en.wikipedia.org/wiki/De_Morgan%27s_laws
    infix fun or(other: Chance) = !(!this and !other)

    override fun isBetterThan(other: Chance) = this.fraction < other.fraction
}