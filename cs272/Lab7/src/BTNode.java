public class BTNode<E>
{
   private E data;
   private BTNode<E> left, right;   


   public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight)
   {
      data = initialData;
      left = initialLeft;
      right = initialRight;
   }       
   
   
   public E getData( )   
   {
      return data;
   }
   
   
   public BTNode<E> getLeft( )
   {
      return left;                                               
   } 
   
   
   public E getLeftmostData( )
   {
      if (left == null)
         return data;
      else
         return left.getLeftmostData( );
   }
      
   
   public BTNode<E> getRight( )
   {
      return right;                                               
   } 


   //  !!! this may need some work
   public E getRightmostData( )
   {
      if (right == null)
         return data;
      else
         return right.getRightmostData( );
   }

   
   public boolean isLeaf( )
   {
      return (left == null) && (right == null);                                               
   } 

   
   public void inorderPrint( )
   {
      if (left != null)
         left.inorderPrint( );
      System.out.println(data);
      if (right != null)
         right.inorderPrint( );
   }  


   public void preorderPrint( )
   {
      System.out.println(data);
      if (left != null)
         left.preorderPrint( );
      if (right != null)
         right.preorderPrint( );
   } 
   
      
   public void postorderPrint( )
   {
      if (left != null)
         left.postorderPrint( );
      if (right != null)
         right.postorderPrint( );
      System.out.println(data);
   }   


   // inorder print with indentations
   
   public void print(int depth)
   {
      int i;
   
      // Print the indentation and the data from the current node:
      for (i = 1; i <= depth; i++)
         System.out.print("    ");
      System.out.println(data);

      // Print the left subtree (or a dash if there is a right child and no left child)   
      if (left != null)
         left.print(depth+1);
      else if (right != null)
      {
         for (i = 1; i <= depth+1; i++)
            System.out.print("    ");
         System.out.println("--");
      }

      // Print the right subtree (or a dash if there is a left child and no left child)  
      if (right != null)
         right.print(depth+1);
      else if (left != null)
      {
         for (i = 1; i <= depth+1; i++)
            System.out.print("    ");
         System.out.println("--");
      }
   }
   

   public BTNode<E> removeLeftmost( )
   {
      if (left == null)
         return right;
      else
      {
         left = left.removeLeftmost( );
         return this;
      }
   }


   public BTNode<E> removeRightmost( )
   {
      if (right == null)
         return left;
      else
      {
         right = right.removeRightmost( );
         return this;
      }
   }
       
   
   public void setData(E newData)   
   {
      data = newData;
   }                                                               
   
   
   public void setLeft(BTNode<E> newLeft)
   {                    
      left = newLeft;
   }
    
    
   public void setRight(BTNode<E> newRight)
   {                    
      right = newRight;
   }  
    
    
   public static <E> BTNode<E> treeCopy(BTNode<E> source)
   {
      BTNode<E> leftCopy, rightCopy;

      if (source == null)
         return null;
      else
      {
         leftCopy = treeCopy(source.left);
         rightCopy = treeCopy(source.right);
         return new BTNode<E>(source.data, leftCopy, rightCopy);
      }
   }
   
   // return the number of nodes in the tree
   public static <E> long treeSize(BTNode<E> root)
   {
      if (root == null)
         return 0;
      else
         return 1 + treeSize(root.left) + treeSize(root.right);
   }   

}
           
