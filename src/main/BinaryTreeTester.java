package main;

import interfaces.BinaryTree;
import interfaces.Position;

public class BinaryTreeTester {

    public static void main(String[] args) {

        LinkedBinaryTree<Integer> numTree = new LinkedBinaryTree<>();
        Position<Integer> nroot = numTree.addRoot(1);

        //children from root
        Position<Integer> nchild1 = numTree.insertChild(nroot, 6);
        Position<Integer> nchild2 = numTree.insertChild(nroot, 7);

        //children from roots first child
        Position<Integer> nchild11 = numTree.insertChild(nchild1, 8);
        Position<Integer> nchild12 = numTree.insertChild(nchild1, 80);
        //netos 1 from root
        Position<Integer> nchild121 = numTree.insertChild(nchild11, 5);
        //Position<Integer> nchild111 = numTree.insertChild(nchild11, 50);

        //children from root second child
        Position<Integer> nchild21 = numTree.insertChild(nchild2, 9);
        Position<Integer> nchild22 = numTree.insertChild(nchild2, 90);


        System.out.println(numTree.toString());
        System.out.println("the tree size is: "+ numTree.size());



    }
}
