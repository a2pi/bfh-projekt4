//package main;
//
//import exceptions.EmptyTreeException;
//import exceptions.InvalidPositionException;
//import exceptions.UnemptyTreeException;
//import interfaces.Position;
//import interfaces.Tree;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.function.Consumer;
//
//public class MyTree implements Tree {
//    int n = 0;
//    private TreeNode root;
//
//    // Constructor
//public MyTree(){
//    root = null;
//}
//
//
//public void addNode(TreeNode newNode){
//
//    if (root == null)
//    {
//        root = newNode;
//        return;
//    }
//
//    else{
//            List<TreeNode> queue = new ArrayList<TreeNode>();
//            queue.add(root);
//
//        }
//
//    }
//
//    @Override
//    public Position addRoot(Object E) throws UnemptyTreeException {
//        root = new TreeNode(E);
//        n++;
//        return root;
//
//    }
//
//    @Override
//    public int height() throws EmptyTreeException {
//        return 0;
//    }
//
//    @Override
//    public List elements() {
//        return null;
//    }
//
//    @Override
//    public List<Position> positions() {
//        return null;
//    }
//
//    @Override
//    public Position root() throws EmptyTreeException {
//        return null;
//    }
//
//    @Override
//    public Position parent(Position p) throws InvalidPositionException {
//        return null;
//    }
//
//    @Override
//    public List<Position> children(Position p) throws InvalidPositionException {
//        return null;
//    }
//
//    @Override
//    public List<Position> descendants(Position p) throws InvalidPositionException {
//        return null;
//    }
//
//    @Override
//    public List<Position> ancestors(Position p) throws InvalidPositionException {
//        return null;
//
//    }
//
//    @Override
//    public boolean isRoot(Position p) throws InvalidPositionException {
//        return false;
//    }
//
//    @Override
//    public boolean isInternal(Position p) throws InvalidPositionException {
//        return false;
//    }
//
//    @Override
//    public boolean isExternal(Position p) throws InvalidPositionException {
//        return false;
//    }
//
//    @Override
//    public int depth(Position p) throws InvalidPositionException {
//        return 0;
//    }
//
//    @Override
//    public Position insertChild(Position p, Object o) throws InvalidPositionException {
//        return null;
//    }
//
//    @Override
//    public Object removeLeaf(Position p) throws InvalidPositionException {
//        return null;
//    }
//
//    @Override
//    public Object replaceElement(Position p, Object o) throws InvalidPositionException {
//        return null;
//    }
//
//    @Override
//    public void swapElements(Position p, Position q) throws InvalidPositionException {
//
//    }
//
//    @Override
//    public void traversePostOrder(Consumer visit) {
//
//    }
//
//    @Override
//    public void traversePreOrder(Consumer visit) {
//
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//}
