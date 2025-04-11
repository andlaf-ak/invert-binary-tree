package org.example

import jdk.incubator.vector.VectorOperators.Binary

class BinaryTree<T>(var value: T) {
    var left: BinaryTree<T>? = null
    var right: BinaryTree<T>? = null

    constructor(value: T, left: BinaryTree<T>?, right: BinaryTree<T>?) : this(value) {
        this.left = left
        this.right = right
    }
}

fun <T> invertBinaryTree(root: BinaryTree<T>): BinaryTree<T>? {
    val invertedTree = BinaryTree(root.value)
    val tmpLeft = root.left
    val tmpRight = root.right
    invertedTree.left = tmpRight
    invertedTree.right = tmpLeft
    return invertedTree
}

