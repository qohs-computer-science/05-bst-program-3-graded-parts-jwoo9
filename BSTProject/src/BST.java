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
        if (root == null)
            return false;   
        else if (root.getValue().equals(toFind))
            return true;
        else if (toFind.compareTo(root.getValue())<0)
            return findHelper(toFind, root.getLeft());
        else
            return findHelper(toFind,root.getRight());
    } //end method find


    private boolean findHelper(Comparable val, TreeNode child){
        if (child==null)
            return false;
        else if (child.getValue().equals(val))
            return true;
        else if (val.compareTo(child.getValue())<0)
            return findHelper(val, child.getLeft());
        else
            return findHelper(val,child.getRight());
    }//end method findHelper


	public boolean replace(Comparable old, Comparable toAdd){
        if (find(old)){
            delete(old);
            add(toAdd);
            return true;
        }//end if
        else{
            add(toAdd);
            return false;
        }//end else
    }//end method replace


	public boolean delete(Comparable old){
        if (root==null)
            return false;
        if (root.getValue().equals(old)){
            if (root.getLeft()!=null && root.getRight() != null)
            {
                TreeNode temp = root.getLeft();
                TreeNode temp2 = temp;
                while (temp2.getRight()!=null)
                {
                    temp2 = temp2.getRight();
                }//end while
                temp2.setRight(root.getRight());
                root.setRight(null); root.setLeft(null);
                root = temp;
            } //end inner if BOTH CHILDREN EXIST
            else if (root.getLeft()!=null && root.getRight() == null){
                TreeNode temp = root.getLeft();
                root.setLeft(null);
                root=temp;
            }//end inner if ONLY LEFT CHILD
            else if (root.getLeft()==null && root.getRight()!=null){
                TreeNode temp = root.getRight();
                root.setRight(null);
                root=temp;
            }//end inner if ONLY RIGHT CHILD
            else{
                root=null;
            }//end inner else NO CHILDREN
            size--;
            return true;
        }//end outer if
        else if (old.compareTo(root.getValue())<0){
            return deleteHelper(old, root,root.getLeft());
        }//end outer else if
        else{
            return deleteHelper(old, root, root.getRight());
        }//end outer else
    } //end method delete


    private boolean deleteHelper(Comparable value, TreeNode parent, TreeNode child){
        if (child == null)
            return false;
        
        if (child.getValue().equals(value)){
            if (child.getLeft()!=null && child.getRight()!=null){
                TreeNode temp = child.getLeft();
                if (value.compareTo(parent.getValue())<0)
                    parent.setLeft(temp);
                else 
                    parent.setRight(temp);
                while (temp.getRight()!=null){
                    temp=temp.getRight();
                }//end while
                temp.setRight(child.getRight());
            }//end inner if BOTH CHILDREN EXIST
            else if (child.getLeft()!=null && child.getRight()==null){
                if (value.compareTo(parent.getValue())<0)
                    parent.setLeft(child.getLeft());
                else 
                    parent.setRight(child.getLeft());
                child.setLeft(null);
            }//end inner if ONLY LEFT CHILD
            else if (child.getLeft()==null && child.getRight()!=null){
                if (value.compareTo(parent.getValue())<0)
                    parent.setLeft(child.getRight());
                else 
                    parent.setRight(child.getRight());
            }//end inner if ONLY RIGHT CHILD
            else{
                if (value.compareTo(parent.getValue())<0)
                parent.setLeft(null);
            else 
                parent.setRight(null);
            }//end inner else NO CHILDREN
            size--;
            return true;
        }//end outer if 
        else if (value.compareTo(child.getValue())<0)
            return deleteHelper(value,child,child.getLeft());
        else
            return deleteHelper(value,child,child.getRight());
    }//end method deleteHelper


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