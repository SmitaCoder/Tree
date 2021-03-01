package treeImplementation;

import org.omg.PortableInterceptor.INACTIVE;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder(){
        if(root!=null){
            root.traverseInOrder();
        }
    }

    public TreeNode get(int value){
        if(root!=null){
            return root.get(value);
        }
        return null;
    }

    public void delete(int value){
        root = delete(root, value);
    }

    //It returns the root of subtree that we may need to replace when we do delete
    //If the node was nt the one we need to delete then we get the same node back
    public TreeNode delete(TreeNode subtreeRoot, int value){
        if(subtreeRoot == null){
            return subtreeRoot;
        }
        if(value < subtreeRoot.getData()){
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(),value));
        }
        else if(value > subtreeRoot.getData()){
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(),value));
        }
        else {
            //If it was not < or > than the root that means it is equal to the value and we have found the node we wish
            // to delete, hence we return the subtreeRoot. So lets delete it below for Case # 1 and 2
            //Case # 1 - when the node is leaf node and as 0 child and does not need the nodes below it to be rearranged
            //Case # 2 - when the node has 1 child only then it needs the leaf node(left or right) to be rearranged
            // and moved to deleted node's position
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();//you may return null for case 1 and right child for case 2
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();//you may return null for case 1 and left child for case 2
            }
            //Case 3 - Node has 2 subtrees
            //Below line replaces the data to min value from the right subtree of the node which we are deleting
            subtreeRoot.setData(subtreeRoot.getRightChild().min());
            //Below line deletes the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(),subtreeRoot.getData()));
        }
        return subtreeRoot;
    }

    public int min(){
        if(root == null){
            //return root.getData();
            return Integer.MIN_VALUE;
        }
        else{
            return root.min();
        }
    }

    public int max(){
        if(root == null){
            //return root.getData();
            return Integer.MAX_VALUE;
        }
        else{
            return root.max();
        }
    }
}
