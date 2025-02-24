/*
 * Justin Wu
 * 2/20/25
 * Pd. 3
 * Program to create the Binary Search Tree class, a way to store sorted data. Code all methods implemented in BST interface and test them.
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
      BST tree = new BST();
      tree.add("O"); tree.add("R"); tree.add("C"); tree.add("H"); tree.add("A"); tree.add("R"); tree.add("D");
      tree.add("Q"); tree.add("U"); tree.add("I"); tree.add("N"); tree.add("C"); tree.add("E");

      System.out.println("In Order: ");
      tree.printInOrder();
      System.out.println();
      System.out.println("Pre Order: ");
      tree.printPreOrder();
      System.out.println();
      System.out.println("Post Order: ");
      tree.printPostOrder();
      System.out.println();
	
    } //end main
 } //end class