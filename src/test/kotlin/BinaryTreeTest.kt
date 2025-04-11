import org.example.BinaryTree
import org.example.generateRandomBinaryTreePair
import org.example.invertBinaryTree
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class BinaryTreeTest {
     @Test
     fun shouldInvertBinaryTreeWithOnlyRoot() {
         val root = BinaryTree(1)
         val result = invertBinaryTree(root)

         assertNotNull(result)
         assertEquals(1, result?.value)
         assertNull(result?.left)
         assertNull(result?.right)
     }

    @Test
    fun shouldInvertBinaryTreeWithOneLeftChild(){
        val root = BinaryTree(1, BinaryTree(2))

        val result = invertBinaryTree(root)

        assertNotNull(result)
        assertEquals(1, result?.value)
        assertNull(result?.left)
        assertNotNull(result?.right)
    }


    @Test
    fun shouldInvertBinaryTreeWithOneRightChild(){
        val root = BinaryTree(1, null, BinaryTree(2))

        val result = invertBinaryTree(root)

        assertNotNull(result)
        assertEquals(1, result?.value)
        assertNotNull(result?.left)
        assertNull(result?.right)
    }

    @Test
    fun shouldInvertBinarySmallTrivialBinaryTree(){
        val root = BinaryTree(1, BinaryTree(2), BinaryTree(3))

        val result = invertBinaryTree(root)

        assertNotNull(result)
        assertEquals(1, result?.value)
        assertNotNull(result?.left)
        assertEquals(3, result?.left?.value)
        assertNotNull(result?.right)
        assertEquals(2, result?.right?.value)
    }

    @Test
    fun shouldInvertBinarySmallNonTrivialBinaryTree(){
        val tree = BinaryTree(1,
                        BinaryTree(11,
                            BinaryTree(111),
                            BinaryTree(112)
                        ),
                        BinaryTree(22,
                            BinaryTree(221),
                            BinaryTree(222)
                        )
        )
        val expectedInvertedTree = BinaryTree(1,
                                        BinaryTree(22,
                                                BinaryTree(222),
                                                BinaryTree(221)),
                                        BinaryTree(11,
                                            BinaryTree(112),
                                            BinaryTree(111)
                                        )
        )
        val invertedTree = invertBinaryTree(tree)

        assertEquals(expectedInvertedTree, invertedTree)
    }

    @Test
    fun shouldInvertRandomTree() {
        val (original, originalInverted) = generateRandomBinaryTreePair(10, 100, 0)
        val inverted = invertBinaryTree(original)
        assertEquals(originalInverted, inverted)
    }
}