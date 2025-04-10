import org.example.BinaryTree
import org.example.invertBinaryTree
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class BinaryTreeTest {
     @Test
     fun testInvertBinaryTree_withSingleNode_returnsSameValue() {
         val root = BinaryTree(1)
         val result = invertBinaryTree(root)

         assertNotNull(result)
         assertEquals(1, result?.value)
         assertNull(result?.left)
         assertNull(result?.right)
     }
}