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
        val root = BinaryTree(1,
                        BinaryTree(11,
                            BinaryTree(111),
                            BinaryTree(112)
                        ),
                        BinaryTree(22,
                            BinaryTree(221),
                            BinaryTree(222)
                        )
        )
        val result = invertBinaryTree(root)

        assertNotNull(result)
        assertEquals(1, result?.value)

        assertNotNull(result?.left)
        assertEquals(22, result?.left?.value)
        assertNotNull(result?.left?.left)
        assertEquals(222, result?.left?.left?.value)
        assertNotNull(result?.left?.right)
        assertEquals(221, result?.left?.right?.value)

        assertNotNull(result?.right)
        assertEquals(11, result?.right?.value)
        assertNotNull(result?.right?.left)
        assertEquals(112, result?.right?.left?.value)
        assertNotNull(result?.right?.right)
        assertEquals(111, result?.right?.right?.value)
    }

    @Test
    fun shouldInvertRandomTree() {
        val (original, originalInverted) = generateRandomBinaryTreePair(100, 100, 0)
        val inverted = invertBinaryTree(original)
        assertEquals(originalInverted, inverted)
    }
}