/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Link.Companion.totalCost

// Understands a specific route from one Node to another
abstract class Path internal constructor() {

    open internal fun prepend(link: Link)  {}

    abstract fun cost(): Double

    abstract fun hopCount(): Int

    class ActualPath internal constructor() : Path() {
        private val links = mutableListOf<Link>()

        override fun prepend(link: Link) { links.add(link) }

        override fun cost() = links.totalCost()

        override fun hopCount() = links.size
    }
}