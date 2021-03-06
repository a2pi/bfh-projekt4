package interfaces;

import java.util.function.Consumer;

import exceptions.InvalidPositionException;

public interface BinaryTree<E> extends Tree<E> {

	public Position<E> leftChild(Position<E> p) throws InvalidPositionException;

	public Position<E> rightChild(Position<E> p) throws InvalidPositionException;

	public Position<E> sibling(Position<E> p) throws InvalidPositionException;

	public boolean hasLeft(Position<E> p) throws InvalidPositionException;

	public boolean hasRight(Position<E> p) throws InvalidPositionException;

	public boolean hasSibling(Position<E> p) throws InvalidPositionException;

	public Position<E> insertLeft(Position<E> p, E e) throws InvalidPositionException;

	public Position<E> insertRight(Position<E> p, E e) throws InvalidPositionException;

	public void insertChildren(Position<E> p, E e1, E e2) throws InvalidPositionException;

	public void traverseInOrder(Consumer<Position<E>> visit);
}
