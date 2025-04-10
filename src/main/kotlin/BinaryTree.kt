package org.example

import jdk.incubator.vector.VectorOperators.Binary

class BinaryTree<T>(var value: T) {
    var left: BinaryTree<T>? = null
    var right: BinaryTree<T>? = null
}

fun <T> invertBinaryTree(root: BinaryTree<T>): BinaryTree<T>? {
    return BinaryTree(root.value);
}
