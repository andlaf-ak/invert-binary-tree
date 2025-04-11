package org.example

import kotlin.random.Random

class BinaryTree<T>(
    val value: T,
    val left: BinaryTree<T>? = null,
    val right: BinaryTree<T>? = null
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BinaryTree<*>) return false
        if (value != other.value) return false

        return (left == other.left) && (right == other.right)
    }

    override fun hashCode(): Int {
        var result = value?.hashCode() ?: 0
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }
}



fun <T> invertBinaryTree(root: BinaryTree<T>?): BinaryTree<T>? {
    if (root == null) {
        return null
    }
    return BinaryTree(root.value, invertBinaryTree(root.right), invertBinaryTree(root.left))
}

fun generateRandomBinaryTreePair(
    depth: Int,
    valueRange: Int = 100,
    currentDepth: Int = 0
): Pair<BinaryTree<Int>?, BinaryTree<Int>?> {
    if (currentDepth >= depth || Random.nextDouble() < 0.3) return Pair(null, null)

    val value = Random.nextInt(valueRange)

    val (leftOriginal, leftInverted) = generateRandomBinaryTreePair(depth, valueRange, currentDepth + 1)
    val (rightOriginal, rightInverted) = generateRandomBinaryTreePair(depth, valueRange, currentDepth + 1)

    val original = BinaryTree(value, leftOriginal, rightOriginal)
    val inverted = BinaryTree(value, rightInverted, leftInverted)

    return Pair(original, inverted)
}


