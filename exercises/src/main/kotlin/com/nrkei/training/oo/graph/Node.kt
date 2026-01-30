package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Path.Companion.filterBy

// Understands its neighbors
class Node {
    companion object {
        private val noVisitedNodes = emptyList<Node>()
    }

    private val links = mutableListOf<Link>()

    infix fun canReach(destination: Node) =
        paths(destination).isNotEmpty()

    infix fun hopCount(destination: Node) =
        path(destination, Path::hopCount).hopCount()

    infix fun cost(destination: Node) = path(destination).cost()

    infix fun path(destination: Node) = path(destination,Path::cost)

    infix fun paths(destination: Node) = paths().filterBy(destination)

    fun paths() = paths(noVisitedNodes)
    val paths get() = paths()

    internal fun paths(visitedNodes: List<Node>): List<Path> {
        if (this in visitedNodes) return emptyList()
        return links.flatMap { it.paths(visitedNodes + this) } + Path(this)
    }

    private fun path(destination: Node, strategy: PathStrategy) =
        paths(destination)
            .minByOrNull { strategy(it).toDouble() }
            ?: throw IllegalArgumentException("Destination cannot be reached")

    infix fun cost(amount: Number) = LinkBuilder(amount.toDouble())

    inner class LinkBuilder internal constructor(private val cost: Double) {
        infix fun to(destination: Node) = destination.also {
            links.add(Link(cost, it))
        }
    }
}