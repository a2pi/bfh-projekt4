package main;

import interfaces.Position;
import interfaces.Tree;

public class TreeTester {

    public static void main(String[] args) {

        Tree<Integer> myTree = new LinkedTree<>();
        Tree<Integer> yourTree = new LinkedTree<>();

        Position<Integer> root = myTree.addRoot(10);

        System.out.println(yourTree.elements().size());


        System.out.println(root.element());

        Position<Integer> child = myTree.insertChild(root , 25);
        Position<Integer> child2 = myTree.insertChild(root , 2);
        Position<Integer> child3 = myTree.insertChild(root , 2);
        Position<Integer> child4 = myTree.insertChild(root , 2);

        Position<Integer> child11 = myTree.insertChild(child , 2);
        Position<Integer> child12 = myTree.insertChild(child , 2);

        System.out.println(child.element());

        System.out.println(myTree.elements());
        System.out.println(myTree.elements().size());

        System.out.println(myTree.positions().size());

        System.out.println(myTree.isExternal(root));
        System.out.println(myTree.isExternal(child));
        System.out.println(myTree.isInternal(root));
        System.out.println(myTree.isInternal(child2));

        System.out.println(myTree.root() == root);
        //System.out.println(yourTree.root() == myTree.root());

        System.out.println(myTree.children(root).size());
        //
        System.out.println(myTree.ancestors(child12).size()); //

        System.out.println(myTree.descendants(root));

        System.out.println(myTree.isExternal(child12));
        System.out.println(myTree.isExternal(child));

        //System.out.println(myTree.root() == yourTree.root()); //

        System.out.println(myTree.size());

        System.out.println(myTree.depth(child12));

        //System.out.println(myTree.height()); //height doesn't work

        System.out.println(myTree.depth(root));

        System.out.println(myTree.toString());

        System.out.println(myTree.descendants(child));

    }
}
