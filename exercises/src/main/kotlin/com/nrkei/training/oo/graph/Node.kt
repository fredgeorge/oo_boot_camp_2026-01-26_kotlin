package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Path.ActualPath

// Understands its neighbors
class Node {
    companion object {
        private val noVisitedNodes = emptyList<Node>()
    }

    private val links = mutableListOf<Link>()

    infix fun canReach(destination: Node) =
        path(destination, noVisitedNodes, Path::cost) != Path.NONE

    infix fun hopCount(destination: Node) =
        path(destination, Path::hopCount).hopCount()

    infix fun cost(destination: Node) = path(destination).cost()

    infix fun path(destination: Node) = path(destination,Path::cost)

    infix fun paths(destination: Node) = paths(destination, noVisitedNodes)

    internal fun paths(destination: Node, visitedNodes: List<Node>): List<Path> {
        if (this == destination) return listOf(ActualPath())
        if (this in visitedNodes) return emptyList()
        return links.flatMap { it.paths(destination, visitedNodes + this) }
    }

    private fun path(destination: Node, strategy: PathStrategy) =
        path(destination, noVisitedNodes, strategy)
            .also { require(it != Path.NONE) { "Destination cannot be reached" } }

    internal fun path(destination: Node, visitedNodes: List<Node>, strategy: PathStrategy): Path {
        if (this == destination) return ActualPath()
        if (this in visitedNodes) return Path.NONE
        return links
            .map { it.path(destination, visitedNodes + this, strategy) }
            .minByOrNull { strategy(it).toDouble() }
            ?: Path.NONE
    }

    infix fun cost(amount: Number) = LinkBuilder(amount.toDouble())

    inner class LinkBuilder internal constructor(private val cost: Double) {
        infix fun to(destination: Node) = destination.also {
            links.add(Link(cost, it))
        }
    }
}