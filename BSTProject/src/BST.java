import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;
    private int size;

    public BST (){
        root = null;
        size = 0;
    }//end constructor


    public int size(){
        return size;
    } //end method size


    public boolean isEmpty(){
        return (root==null);
    }//end method isEmpty


    public void add(Comparable newVal){
        size++;
        if (root == null)
            root = new TreeNode(newVal, null, null);
        else if (newVal.compareTo(root.getValue())<=0)
            addHelper(newVal, root.getLeft(), root);
        else
            addHelper(newVal, root.getRight(), root);
    } //end add

    private void addHelper(Comparable val, TreeNode child, TreeNode parent){
        if (child == null){
            if (val.compareTo(parent.getValue())<=0)
                parent.setLeft(new TreeNode(val, null, null));
            else    
                parent.setRight(new TreeNode(val, null, null));
        }//end if
        else if (val.compareTo(child.getValue())<=0)
            addHelper(val, child.getLeft(), child);
        else   
            addHelper(val, child.getRight(), child);
    } //end addHelper

    public boolean find(Comparable toFind){
        return true;
    } //end method find

	public boolean replace(Comparable old, Comparable toAdd){
        return true;
    }//end method replace

	public boolean delete(Comparable old){
        return true;
    }

	public void printInOrder(){
        if (root!=null){
            printInHelper(root.getLeft());
            System.out.print(root.getValue() + ", ");
            printInHelper(root.getRight());
        }//end if
    }//end method printInOrder

    private void printInHelper(TreeNode subroot){
        if (subroot!=null){
            printInHelper(subroot.getLeft());
            System.out.print(subroot.getValue() + ", " );
            printInHelper(subroot.getRight());
        }//end if
    }//end helper method printInHelper

	public void printPreOrder(){
        if (root!=null){
            System.out.print(root.getValue() + ", ");
            printPreHelper(root.getLeft());
            printPreHelper(root.getRight());
        }//end if
    } //emd method printPreOrder
	
    private void printPreHelper(TreeNode subroot){
        if (subroot!=null){
            System.out.print(subroot.getValue() + ", ");
            printPreHelper(subroot.getLeft());
            printPreHelper(subroot.getRight());
        }//end if
    }//end helper method printPreHelper

	public void printPostOrder(){
        if (root!=null){
            printPostHelper(root.getLeft());
            printPostHelper(root.getRight());
            System.out.print(root.getValue() + ", ");
        }//end if
    } //end method printPostOrder

    private void printPostHelper(TreeNode subroot){
        if (subroot!=null){
            printPostHelper(subroot.getLeft());
            printPostHelper(subroot.getRight());
            System.out.print(subroot.getValue() + ", ");
        }//end if
    }//end helper method printPostHelper
	

} //end class BST