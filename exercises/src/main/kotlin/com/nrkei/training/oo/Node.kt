/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo

// Understands its neighbors
class Node {
    private val neighbors = mutableListOf<Node>()
    private val noVisitedNodes get() = mutableListOf<Node>()

    infix fun to(neighbor: Node) = neighbor.also { neighbors.add(it) }

    infix fun canReach(destination: Node) = canReach(destination, noVisitedNodes)

    private fun canReach(destination: Node, visitedNodes: MutableList<Node>): Boolean {
        if (this == destination) return true
        if (this in visitedNodes) return false
        visitedNodes.add(this)
        for (neighbor in neighbors)
            if (neighbor.canReach(destination, visitedNodes)) return true
        return false
    }
}