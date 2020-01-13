package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.UnemptyTreeException;
import interfaces.Position;
import interfaces.Tree;

import javax.xml.stream.FactoryConfigurationError;

public class LinkedTree<E> implements Tree<E> {

	int size;
	TreeNode<E> root;


	/**
	 * Constructor for a Linked Tree
	 */
	public LinkedTree() {
		root = null;
		size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	/**
	 * @return boolean to see if tree is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * @return int height The height of a tree
	 * @throws EmptyTreeException
	 */
	@Override
	public int height() throws EmptyTreeException {
		if(isEmpty())
			throw new EmptyTreeException();
		else
			return heightOf(root);
	}

	/**
	 * helping method for height()
	 *
	 * @param p position of node
	 * @return max depth of tree
	 */
	private int heightOf(Position<E> p) {
		if(isExternal(p))
			return 0;
		else {
			int h = 0;
			for(Position<E> childPosition : children(p)) {
				h = Math.max(h, heightOf(childPosition));
			}
			return h + 1;
		}
	}



	//This method doesn't do anything

	public List<E> elementsOf(Position<E> p, ArrayList<E> list) {
		for (Position<E> child : children(p)) {
			list.add(child.element());
			// if child has also children
			if (isInternal(child))
				elementsOf(child, list);
		}
		return list;
	}

	@Override
	public List<E> elements() {
		ArrayList<E> elements = new ArrayList<>(size());
		if(isEmpty()) return elements;
		else
		{elements.add(this.root.element());
		elementsOf(root(), elements);
		return elements;}
	}


	public List<Position<E>> positionOf(Position<E> p, ArrayList<Position<E>> positionsList) {
		for (Position<E> child : children(p)) {
			positionsList.add(child);
			if (isInternal(child))
				positionOf(child, positionsList);
		}
		return positionsList;
	}

	@Override
	public List<Position<E>> positions() {
		ArrayList<Position<E>> list = new ArrayList<>(this.size());
		if (isEmpty())
			return list;
		list.add(root);
		positionOf(root, list);
		return list;

	}

//	private ChilderntoArray(Position<E> p){
//
//		for (Position<E> k: children(p)){
//			positionsArray.add(k);
//			ChilderntoArray(k);
//		}
//	}

	@Override
	public Position<E> root() throws EmptyTreeException {
		if (root == null) throw new EmptyTreeException();
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws InvalidPositionException {
		TreeNode<E> t = (TreeNode<E>) p;
		return t.parent;
	}

	@Override
	public List<Position<E>> children(Position<E> p) throws InvalidPositionException {
		TreeNode t = (TreeNode) p;//risiko Casting Exception, isValif(p) instanceof
		return t.children;
	}

	public List<Position<E>> descendantsOf(Position<E> p, ArrayList<Position<E>> list) {
		if (isInternal(p)) {
			// add child to list and check if the child has also children
			for (Position<E> child : children(p)) {
				list.add(child);
				// call recursive method, check for internal is above
				descendantsOf(child, list);
			}
		}
		return list;
	}


	@Override
	public List<Position<E>> descendants(Position<E> p) {

		if (!isValid(p))
			throw new InvalidPositionException();

		ArrayList<Position<E>> list = new ArrayList<>(this.size());
		return descendantsOf(p, list);
	}


	public List<Position<E>> ancestorsOf(Position<E> p, ArrayList<Position<E>> list) {
		if (isRoot(p))
			return list;
		list.add(parent(p));
		ancestorsOf(parent(p), list);
		return list;
	}

	@Override
	public List<Position<E>> ancestors(Position<E> p) {

		if (!isValid(p))
			throw new InvalidPositionException();


		ArrayList<Position<E>> list = new ArrayList<>(this.size());
		return ancestorsOf(p, list);

	}

	@Override
	public boolean isRoot(Position<E> p) throws InvalidPositionException {
		return p == root();
	}

	@Override
	public boolean isInternal(Position<E> p) throws InvalidPositionException {

		TreeNode<E> t = (TreeNode<E>) p;
		return t.children.size() > 0;
	}

	@Override
	public boolean isExternal(Position<E> p) throws InvalidPositionException {

		TreeNode<E> t = (TreeNode<E>) p;
		return t.children.size() == 0;

	}

	//Node muss depth selber wissen
	@Override
	public int depth(Position<E> p) throws InvalidPositionException {
		if (((TreeNode<E>) p) == root) return 0;
		else {
			return ((TreeNode<E>) p).depth;
		}
		//return ((TreeNode<E>) p).depth;
	}

	@Override
	public Position<E> addRoot(E e) {
		if (!isEmpty()) throw new UnemptyTreeException();
		size = 1;
		root = new TreeNode<E>(e, null);
		root.parent = null;
		root.depth = 0;
		return root;
	}

	@Override
	public Position<E> insertChild(Position<E> p, E e) {
		TreeNode<E> t = new TreeNode(e, (TreeNode<E>) p);
		if (isEmpty())
			throw new InvalidPositionException();
		else {
			((TreeNode<E>) p).children.add((E) t);
			//positionList.add(t); //must be removed
			size++;
			t.depth = t.parent.depth + 1;
		}
		return t;
	}

	@Override
	public E removeLeaf(Position<E> p) {
		E tempElement = p.element();
		if (isInternal(p)) {
			throw new InvalidPositionException();
		} else {
			((TreeNode<E>) p).parent.children.remove(p);
		}
		return tempElement;
	}

	@Override
	public E replaceElement(Position<E> p, E e) throws InvalidPositionException {
		return ((TreeNode<E>) p).element = e;
	}

	@Override
	public void swapElements(Position<E> p, Position<E> q) throws InvalidPositionException {
		E tempElement = ((TreeNode<E>) p).element;
		((TreeNode<E>) p).element = ((TreeNode<E>) q).element;
		((TreeNode<E>) q).element = tempElement;

	}


	@Override
	public void traversePreOrder(Consumer<Position<E>> visit) {
		// TODO Auto-generated method stub

		//visit.accept(preOrder(root()));

	}
/* Use:

	traversePreOrder(preOrder(Position<E> p)){
	p.accept(root.children)
}
*/

	/*This method takes a Node and pass on ist children to a consumer to print them. The method will call itself again
	 in every node of the children array.

	*/
	public Consumer<List<E>> preOrder(Position<E> p) {

		//Create a new Consumer object
		Consumer<List<E>> c = new Consumer<List<E>>() {

			@Override
			public void accept(List<E> t) {
				for (E k: t)
				{
					if(isExternal((TreeNode<E>) k))
						break; //not sure if will work.
					else
					preOrder((TreeNode<E>) k); //recursion
					System.out.println(k);

				}
			}

		};
		c.accept(((TreeNode<E>) p).children);



		return c;

		}




	/*public void preOrder(Position<E> p) {

		Consumer tPublisher = t -> System.out.println();
	}
	*/

	@Override
	public void traversePostOrder(Consumer<Position<E>> visit) {
//	// TODO Auto-generated method stub
//		visit = p -> {
//			System.out.println(p); //here is our Traverse Logic

	}



	public boolean isValid(Position<E> p) {
		if( p==null || !(p instanceof Position))
		    return false;
		else
			return true;


	}


	@Override
	public String toString() {
		if(isEmpty())
			return "";
		return stringOf(root);
	}


	public String stringOf(Position<E> p) {
		String children = "";
		String parent = p.element().toString();
		boolean First = true;

		// check if p has children
		if(isInternal(p)) {
			// loop through children
			for(Position<E> child : children(p)) {
				if(First)
					First = false;
					// generate a space between 2 children
				else
					children += " ";
				//recursively check for children of the child
				children += stringOf(child);
			}
			return parent + " (" + children + ")";
		} else {
			return parent;
		}
	}

}


