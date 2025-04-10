import org.example.BinaryTree
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
        val root = BinaryTree(1)
        root.left = BinaryTree(2)
        val result = invertBinaryTree(root)

        assertNotNull(result)
        assertEquals(1, result?.value)
        assertNull(result?.left)
        assertNotNull(result?.right)
    }


    @Test
    fun shouldInvertBinaryTreeWithOneRightChild(){
        val root = BinaryTree(1)
        root.right = BinaryTree(2)
        val result = invertBinaryTree(root)

        assertNotNull(result)
        assertEquals(1, result?.value)
        assertNotNull(result?.left)
        assertNull(result?.right)
    }

    @Test
    fun shouldInvertBinarySmallTrivialBinaryTree(){
        val root = BinaryTree(1)
        root.left = BinaryTree(2)
        root.right = BinaryTree(3)
        val result = invertBinaryTree(root)

        assertNotNull(result)
        assertEquals(1, result?.value)
        assertNotNull(result?.left)
        assertEquals(3, result?.left?.value)
        assertNotNull(result?.right)
        assertEquals(2, result?.left?.value)
    }

}