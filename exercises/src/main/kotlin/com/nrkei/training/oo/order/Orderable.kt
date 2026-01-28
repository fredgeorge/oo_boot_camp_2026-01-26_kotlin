/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.order

// Understands sequences of specific homogeneous elements
interface Orderable<T> {
    fun isBetterThan(other: T): Boolean
}

fun <T : Orderable<T>> List<T>.bestOrNull() =
    this.reduceOrNull { champion, challenger ->
        if (challenger.isBetterThan(champion)) challenger else champion
    }