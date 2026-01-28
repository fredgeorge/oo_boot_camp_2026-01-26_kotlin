/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Link.Companion.totalCost

// Understands a specific route from one Node to another
abstract class Path internal constructor() {
    companion object {
        internal val NONE: Path = NoPath()
    }

    internal open fun prepend(link: Link)  {}

    abstract fun cost(): Double

    abstract fun hopCount(): Int

    internal class ActualPath internal constructor() : Path() {
        private val links = mutableListOf<Link>()

        override fun prepend(link: Link) { links.add(link) }

        override fun cost() = links.totalCost()

        override fun hopCount() = links.size
    }

    private class NoPath: Path() {
        override fun cost() = Double.POSITIVE_INFINITY
        override fun hopCount() = Int.MAX_VALUE
    }
}

internal typealias PathStrategy = (Path) -> Number