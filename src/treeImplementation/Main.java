package treeImplementation;

import org.omg.Messaging.SyncScopeHelper;

public class Main {
    public static void main(String arga[]){
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        intTree.traverseInOrder();
        System.out.println();

        System.out.println(intTree.get(27));
        System.out.println(intTree.get(2799));

        System.out.println("Min value is : "+intTree.min());
        System.out.println("Max value is : "+intTree.max());

        intTree.delete(27);

        System.out.println("Deleted tree :");
        intTree.traverseInOrder();
        System.out.println();
    }
}
