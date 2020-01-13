package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.UnemptyTreeException;
import interfaces.BinaryTree;
import interfaces.Position;

public class LinkedBinaryTree<E> implements BinaryTree<E>{

	BinaryTreeNode root;
	private int size;




	//Empty tree constructor
	public LinkedBinaryTree(){
		root = null;
	}



	public int heightOf(BinaryTreeNode<E> p){

		int count = 0;

		if (isExternal(p))
			return 0;
		else{
            count++;
			heightOf(p.left);
			heightOf(p.right);
		}
		return count;
	}


	@Override
	public int height()  {
		int h = (int) (Math.log(size())/Math.log(2));
		return h;
		//return 1 + Math.max(heightOf(root.left),heightOf(root.left));
	}

	public List<E> elementsOf(Position<E> p, ArrayList<E> list) {
		for(Position<E> child : children(p)) {
			list.add(child.element());
			// if child has also children
			if(isInternal(child))
				elementsOf(child, list);
		}
		return list;
	}

	@Override
	public List<E> elements() {
		ArrayList<E> list = new ArrayList<>();
		if(isEmpty())
			return list;
		list.add(root().element());
		elementsOf(root(), list);
		return list;
	}

	public List<Position<E>> positionsOf(Position<E> p, ArrayList<Position<E>> list) {
		for(Position<E> child : children(p)) {
			list.add(child);
			// if child has also children
			if(isInternal(child))
				positionsOf(child, list);
		}
		return list;
	}

	@Override
	public List<Position<E>> positions() {
		ArrayList<Position<E>> list = new ArrayList<>();
		if(isEmpty())
			return list;
		list.add(root);
		positionsOf(root, list);
		return list;
	}

	@Override
	public Position<E> root() {
		if(this.isEmpty()) throw new EmptyTreeException();
		return this.root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws InvalidPositionException {
		if (isRoot(p)) {throw new InvalidPositionException();}
		BinaryTreeNode<E> node = (BinaryTreeNode<E>) p;
		return node.parent;
	}


@Override
public List<Position<E>> children(Position<E> p) {
	List<Position<E>> childrenTemp = new ArrayList<>();
		if(hasLeft((Position<E>) p) == false)
			throw new InvalidPositionException();
		else
			childrenTemp.add(leftChild(p));
		if (hasRight((Position<E>) p))
			childrenTemp.add(rightChild(p));

		return childrenTemp;


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
	public List<Position<E>> descendants(Position<E> p) throws InvalidPositionException {
		if(isValid(p))
			throw new InvalidPositionException();

		ArrayList<Position<E>> list = new ArrayList<>(size());
		return descendantsOf(p, list);
	}

	public List<Position<E>> ancestorsOf(Position<E> p, ArrayList<Position<E>> list) {
		if(isRoot(p))
			return list;
		list.add(parent(p));
		ancestorsOf(parent(p), list);
		return list;
	}

	@Override
	public List<Position<E>> ancestors(Position<E> p) throws InvalidPositionException {
		if(isValid(p))
			throw new InvalidPositionException();

		ArrayList<Position<E>> list = new ArrayList<>(this.size());
		return ancestorsOf(p, list);
	}

	@Override
	public boolean isRoot(Position<E> p) throws InvalidPositionException {
		return ((BinaryTreeNode<E>) p).parent == null;
	}

	@Override
	public boolean isInternal(Position<E> p) throws InvalidPositionException {
		BinaryTreeNode<E> t = (BinaryTreeNode<E>) p;
		return (t.left != null) && (t.right != null);
	}

	@Override
	public boolean isExternal(Position<E> p) throws InvalidPositionException {
		BinaryTreeNode<E> t = (BinaryTreeNode<E>) p;
		return (t.left == null) && (t.right == null);
	}

	@Override
	public int depth(Position<E> p) throws InvalidPositionException {
		if(((BinaryTreeNode<E>) p)== root) return 0;
		else {return depth(parent(p)) + 1;}
	}

	@Override
	public Position<E> addRoot(E e) {
		if(root!=null) {throw new UnemptyTreeException();}
		size = 1;
		root = new BinaryTreeNode(e);
		this.root=root;
		return root;
	}

	@Override
	public Position<E> insertChild(Position<E> p, E e) throws InvalidPositionException {
		if(isExternal(p) || !hasLeft(p))
			return insertLeft(p, e);
		else if(!hasRight(p))
			return insertRight(p, e);
		else
			throw new InvalidPositionException();
	}



    public E removeLeaf(Position<E> p){
        if(isValid(p)) throw new InvalidPositionException();
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) p;
        E element = node.element();
        if (node.left != null || node.right != null) throw new InvalidPositionException();
        if (isRoot(node)) {
            root.parent = null; // this assumes you have such a variable...
        } else if (node.parent.left == node) {
            node.parent.left = null;
        } else {
            node.parent.right = null;
        }


        return element;
    }









	@Override
	public E replaceElement(Position<E> p, E e)  {
		if (isValid(p)) throw new InvalidPositionException();
		BinaryTreeNode<E> node = (BinaryTreeNode<E>) p;
		//var temp = node.element();
		((BinaryTreeNode<E>) p).element=e;
		E newElement = ((BinaryTreeNode<E>) p).element;
        return newElement;
	}

	@Override
	public void swapElements(Position<E> p, Position<E> q) throws InvalidPositionException {
		if( isValid(p) || isValid(q))
			throw new InvalidPositionException();
		BinaryTreeNode<E> n1 = (BinaryTreeNode<E>) p;
		BinaryTreeNode<E> n2 = (BinaryTreeNode<E>) q;
		E temp = n1.element;
		n1.element = n2.element;
		n2.element = temp;
		
	}

	@Override
	public void traversePreOrder(Consumer<Position<E>> visit) {

	List<Position<E>> myList = this.positions();
	Consumer<Position<E>> myVisit = c -> {

	};

	}

	public void preOrder(Position<E> p, Consumer<Position<E>> visit){

		BinaryTreeNode<E> t = (BinaryTreeNode<E>)p;
		preOrder(root(), visit);



			}

	@Override
	public void traversePostOrder(Consumer<Position<E>> visit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;

	}

	@Override
	public Position<E> leftChild(Position<E> p) throws InvalidPositionException {
		BinaryTreeNode<E> node = (BinaryTreeNode<E>) p;
		return node.left;
	}

	@Override
	public Position<E> rightChild(Position<E> p) throws InvalidPositionException {
		BinaryTreeNode<E> node = (BinaryTreeNode<E>) p;
		return node.right;
	}

	@Override
	public Position<E> sibling(Position<E> p)  {
		//check if the Position is null or if there is no
		if( isValid(p) || !(hasLeft(parent(p)) && hasRight(parent(p)) || hasLeft(p) && !hasRight(p)))
			throw new InvalidPositionException();
		else {
			BinaryTreeNode<E> child = (BinaryTreeNode<E>) p;
			BinaryTreeNode<E> parent = child.parent;

			if(parent.left != child)
				return parent.left;
			else
				return parent.right;
		}
	}

	@Override
	public boolean hasLeft(Position<E> p) throws InvalidPositionException {
		return ((BinaryTreeNode<E>) p).left!=null;
	}

	@Override
	public boolean hasRight(Position<E> p) throws InvalidPositionException {
		return ((BinaryTreeNode<E>) p).right != null;
	}

	@Override
	public boolean hasSibling(Position<E> p)   {
        if(isValid(p))
            throw new InvalidPositionException();
        BinaryTreeNode t = ((BinaryTreeNode<E>)p);
        if(hasRight(t.parent) && hasLeft(t.parent))
            return true;
        else
            return false;


        }





	@Override
	public Position<E> insertLeft(Position<E> p, E e) throws InvalidPositionException {
		if(hasLeft(p))
			throw new InvalidPositionException();
		else {
			BinaryTreeNode<E> t = (BinaryTreeNode<E>) p;
			t.left = new BinaryTreeNode<E>(e);
			t.left.parent = t;
			size++;
			//t.depth = t.parent.depth + 1;
			return t.left;
		}
	}

	public Position<E> insertRight(Position<E> p, E e) throws InvalidPositionException {
		if(hasRight(p))
			throw new InvalidPositionException();
		else {
			BinaryTreeNode<E> t = (BinaryTreeNode<E>) p;
			t.right = new BinaryTreeNode<E>(e);
			t.right.parent = t;
			size++;
			//t.depth = t.parent.depth + 1;
			return t.right;
		}
	}

	@Override
	public void insertChildren(Position<E> p, E e1, E e2) throws InvalidPositionException{
			insertLeft(p,e1);
			insertRight(p,e2);

	}

	@Override
	public void traverseInOrder(Consumer<Position<E>> visit) {
		// TODO Auto-generated method stub

	}


	public void inOrder(Position<E> p) throws InvalidPositionException {


}



	/*public void inOrder(Position<E> p) throws InvalidPositionException {
		if(p == null || isEmpty())
			throw new InvalidPositionException();
		BinaryTreeNode<E> node = (BinaryTreeNode<E>)p;
		if(hasLeft(p))
			inOrder(leftChild(p));
		System.out.print(node.element + " ");
		if(hasRight(p))
			inOrder(rightChild(p));
	}
	*/


	public boolean isValid(Position<E> p) {
		if(p instanceof Position)
			return false;
		else
			return true;


	}

	@Override
    public String toString() {
        if(isEmpty())
        return "";
        else
        return stringOf2(root);
    }

	/**
	 * helping method of toString()
	 *
	 * @param p position of node
	 * @return building of the tree in form of a String
	 */



//Problem: the children only will be printed if both are filled.
  public String stringOf(Position<E> p) {
        String children = "";
        //save the element from the root
        String element = p.element().toString();
        boolean isFirst = true;

        // check if p has minimally one child
        if(isInternal(p)) {
            // loop through children list and put a space after the first child
            for(Position<E> child : children(p)) {
                if(isFirst)
                    isFirst = false;
                else {
                    // set space if there is more than one children
                    children += " ";
                }
                // check for children of child
                children += stringOf(child);
            }
            return element + " (" + children + ")";
        } else {
            return element;
        }
    }


    public String stringOf2(Position<E> p) {

      String element= p.element().toString();
      String children = "";
      if(isInternal(p)){
          children+=stringOf2(leftChild(p));
          children+=stringOf2(rightChild(p));

        /*  for (int i = 0; i < children(p).size(); i++) {
              System.out.println(children(p).get(i));
              children+=stringOf2(children(p).get(i));
        }
        */



          return element+=" ("+ children +") ";


      }
      else
      return p.element().toString();


    }




}
