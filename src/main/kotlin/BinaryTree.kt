package org.example

import jdk.incubator.vector.VectorOperators.Binary

class BinaryTree<T>(
    val value: T,
    val left: BinaryTree<T>? = null,
    val right: BinaryTree<T>? = null
)

fun <T> invertBinaryTree(root: BinaryTree<T>?): BinaryTree<T>? {
    if (root == null) {
        return null
    }
    return BinaryTree(root.value, invertBinaryTree(root.right), invertBinaryTree(root.left))
}

