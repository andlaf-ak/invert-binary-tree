package org.example

import jdk.incubator.vector.VectorOperators.Binary

class BinaryTree<T>(var value: T) {
    var left: BinaryTree<T>? = null
    var right: BinaryTree<T>? = null
}

fun <T> invertBinaryTree(root: BinaryTree<T>): BinaryTree<T>? {
    if (root.left != null) {
       val invertedTree = BinaryTree(root.value)
       val tmp = root.left
       invertedTree.left = null
       invertedTree.right = tmp
       return invertedTree
    }
    return BinaryTree(root.value)
}
