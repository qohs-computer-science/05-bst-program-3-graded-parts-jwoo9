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
      System.out.println("Tree Empty: " + tree.isEmpty());
      System.out.println("Tree Size: " + tree.size());
      tree.add("O"); tree.add("R"); tree.add("C"); tree.add("H"); tree.add("A"); tree.add("R"); tree.add("D");
      tree.add("Q"); tree.add("U"); tree.add("I"); tree.add("N"); tree.add("C"); tree.add("E");


      System.out.println("Initial prints after add: ");
      printStatus(tree);
      System.out.println("\n");

      //start deletes
      System.out.println("Testing Deletes");
      System.out.println("Deleting O (Root): " + tree.delete("O"));
      printStatus(tree);
      System.out.println("Deleting X (Doesn't exist): " + tree.delete("X"));
      System.out.println();
      System.out.println("Deleting H (Two children): " + tree.delete("H"));
      printStatus(tree);
      System.out.println("Deleting N (Only right child): " + tree.delete("N"));
      printStatus(tree);
      System.out.println("Deleting U (Leaf): " + tree.delete("U"));
      printStatus(tree);
      System.out.println("Deleting R (Only left child): " + tree.delete("R"));
      printStatus(tree);
      
      //start finds
      System.out.println("Testing Finds");
      System.out.println("Find Q: " + tree.find("Q"));
      System.out.println("Find L: " + tree.find("L"));
      System.out.println("Find C: " + tree.find("C"));
      System.out.println("Find N: " + tree.find("N"));
      System.out.println("Find E: " + tree.find("E"));

      //start replaces
      System.out.println("Testing replace");
      System.out.println("Replace I with X: " + tree.replace("I", "X"));
      printStatus(tree);
      System.out.println("Replace M (doesn't exist) with L" + tree.replace("M", "L"));
      printStatus(tree);
      System.out.println("Replace E with J: " + tree.replace("E", "J"));
      printStatus(tree);
      System.out.println("Replace L with O: " + tree.replace("L", "O"));
      printStatus(tree);

    } //end main


    public static void printStatus(BST tree){
      System.out.println("In Order: ");
      tree.printInOrder();
      System.out.println();
      System.out.println("Pre Order: ");
      tree.printPreOrder();
      System.out.println();
      System.out.println("Post Order: ");
      tree.printPostOrder();
      System.out.println();
      System.out.println("Tree Empty: " + tree.isEmpty());
      System.out.println("Tree Size: " + tree.size());
      System.out.println("\n");
    }//end method printStatus


 } //end class