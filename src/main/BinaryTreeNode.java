package main;

import interfaces.BinaryTree;
import interfaces.Position;

public class BinaryTreeNode<E> implements Position<E> {

    E element;
    protected BinaryTreeNode<E> left, right, parent;
    protected int depth;



    public BinaryTreeNode(E e) {

        this.element = e;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.depth = 0;
    }



    @Override
    public E element() {
        return element;
    }
}
