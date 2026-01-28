package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Path.ActualPath

// Understands its neighbors
class Node {
    companion object {
        private const val UNREACHABLE = Double.POSITIVE_INFINITY
        private val noVisitedNodes = emptyList<Node>()
    }
    private val links = mutableListOf<Link>()

    infix fun canReach(destination: Node) =
        cost(destination, noVisitedNodes, Link.LEAST_COST) != UNREACHABLE

    infix fun hopCount(destination: Node) = cost(destination, Link.FEWEST_HOPS).toInt()

    infix fun cost(destination: Node) = cost(destination, Link.LEAST_COST)

    infix fun path(destination: Node) = path(destination, noVisitedNodes)
        .also { require(it != Path.NONE) { "Destination cannot be reached" } }

    internal fun path(destination: Node, visitedNodes: List<Node>): Path {
        if (this == destination) return ActualPath()
        if (this in visitedNodes) return Path.NONE
        return links
            .map { it.path(destination, visitedNodes + this) }
            .minByOrNull { it.cost() }
            ?: Path.NONE
    }

    private fun cost(destination: Node, strategy: CostStrategy) =
        cost(destination, noVisitedNodes, strategy)
        .also { require(it != UNREACHABLE) { "Destination cannot be reached" } }

    internal fun cost(destination: Node, visitedNodes: List<Node>, strategy: CostStrategy): Double {
        if (this == destination) return 0.0
        if (this in visitedNodes) return UNREACHABLE
        return links
            .minOfOrNull { it.cost(destination, visitedNodes + this, strategy) }
            ?: UNREACHABLE
    }

    infix fun cost(amount: Number) = LinkBuilder(amount.toDouble())

    inner class LinkBuilder internal constructor(private val cost: Double) {
        infix fun to(destination: Node) = destination.also{
            links.add(Link(cost, it))
        }
    }
}