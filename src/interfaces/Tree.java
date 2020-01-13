package interfaces;

import java.util.List;
import java.util.function.Consumer;

import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.UnemptyTreeException;

public interface Tree<E> extends Collection<E> {

	public int height() throws EmptyTreeException;

	public List<E> elements();

	public List<Position<E>> positions();

	public Position<E> root() throws EmptyTreeException;

	public Position<E> parent(Position<E> p) throws InvalidPositionException;

	public List<Position<E>> children(Position<E> p) throws InvalidPositionException;

	public List<Position<E>> descendants(Position<E> p) throws InvalidPositionException;

	public List<Position<E>> ancestors(Position<E> p) throws InvalidPositionException;

	public boolean isRoot(Position<E> p) throws InvalidPositionException;

	public boolean isInternal(Position<E> p) throws InvalidPositionException;

	public boolean isExternal(Position<E> p) throws InvalidPositionException;

	public int depth(Position<E> p) throws InvalidPositionException;

	public Position<E> addRoot(E e) throws UnemptyTreeException;

	public Position<E> insertChild(Position<E> p, E e) throws InvalidPositionException;

	public E removeLeaf(Position<E> p) throws InvalidPositionException;

	public E replaceElement(Position<E> p, E e) throws InvalidPositionException;

	public void swapElements(Position<E> p, Position<E> q) throws InvalidPositionException;

	public void traversePreOrder(Consumer<Position<E>> visit);

	public void traversePostOrder(Consumer<Position<E>> visit);
}
