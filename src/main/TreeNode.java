package main;

import java.util.ArrayList;
import java.util.List;

import interfaces.Position;

public class TreeNode<E> implements Position<E>{
	protected E element;
	private Integer position;
	protected TreeNode<E> parent;
	protected List<E> children;
	protected int depth = 0;
	protected int height=0;



	//Constructors
	public TreeNode(E element, TreeNode<E> parent)  {
		this.element = element;
		this.parent = parent;
		this.children = new ArrayList<>();

	}

	@Override
	public E element() {
		return element;
	}


}