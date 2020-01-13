package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import main.LinkedBinaryTree;

import org.junit.jupiter.api.Test;

import main.LinkedBinaryTree;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.UnemptyTreeException;
import interfaces.BinaryTree;
import interfaces.Position;
import interfaces.Tree;

public class LinkedBinaryTreeTest {

	@Test
	public void test1() {
		BinaryTree<Integer> tree = new LinkedBinaryTree<>();

		// empty tree
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(0, tree.elements().size());
		assertEquals(0, tree.positions().size());
		assertEquals("", tree.toString());

		// 1
		Position<Integer> root = tree.addRoot(1);
		assertFalse(tree.isInternal(root));
		assertTrue(tree.isExternal(root));
		assertFalse(tree.isEmpty());
		assertEquals(1, tree.size());
		assertEquals(0, tree.height());
		assertEquals(1, tree.elements().size());
		assertEquals(1, tree.positions().size());
		assertEquals(root, tree.root());
		assertEquals((Integer) 1, root.element());
		assertEquals(0, tree.depth(root));
		assertEquals(0, tree.ancestors(root).size());
		assertEquals(0, tree.descendants(root).size());
		assertEquals("1", tree.toString());

		// 1 (2)
		Position<Integer> child1 = tree.insertChild(root, 2);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child1));
		assertTrue(tree.isExternal(child1));
		assertFalse(tree.isEmpty());
		assertEquals(2, tree.size());
		assertEquals(1, tree.height());
		assertEquals(child1, tree.children(tree.root()).get(0));
		assertEquals((Integer) 2, child1.element());
		assertEquals(2, tree.elements().size());
		assertEquals(2, tree.positions().size());
		assertEquals(1, tree.depth(child1));
		assertEquals(1, tree.ancestors(child1).size());
		assertEquals(0, tree.descendants(child1).size());
		assertEquals(1, tree.descendants(root).size());
		assertEquals("1 (2)", tree.toString());

		// 1 (2 3)
		Position<Integer> child2 = tree.insertChild(root, 3);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child2));
		assertTrue(tree.isExternal(child2));
		assertFalse(tree.isEmpty());
		assertEquals(3, tree.size());
		assertEquals(1, tree.height());
		assertEquals(child2, tree.children(tree.root()).get(1));
		assertEquals((Integer) 3, child2.element());
		assertEquals(3, tree.elements().size());
		assertEquals(3, tree.positions().size());
		assertEquals(1, tree.depth(child2));
		assertEquals(1, tree.ancestors(child2).size());
		assertEquals(0, tree.descendants(child2).size());
		assertEquals(2, tree.descendants(root).size());
		assertEquals("1 (2 3)", tree.toString());

		// 1 (2 3 (5))
		Position<Integer> child21 = tree.insertChild(child2, 5);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child21));
		assertTrue(tree.isExternal(child21));
		assertFalse(tree.isEmpty());
		assertEquals(4, tree.size());
		assertEquals(2, tree.height());
		assertEquals(child21, tree.children(child2).get(0));
		assertEquals((Integer) 5, child21.element());
		assertEquals(4, tree.elements().size());
		assertEquals(4, tree.positions().size());
		assertEquals(2, tree.depth(child21));
		assertEquals(2, tree.ancestors(child21).size());
		assertEquals(0, tree.descendants(child21).size());
		assertEquals(3, tree.descendants(root).size());
		assertEquals("1 (2 3 (5))", tree.toString());

		// 1 (2 3 (5 6))
		Position<Integer> child22 = tree.insertChild(child2, 6);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child22));
		assertTrue(tree.isExternal(child22));
		assertFalse(tree.isEmpty());
		assertEquals(5, tree.size());
		assertEquals(2, tree.height());
		assertEquals(child22, tree.children(child2).get(1));
		assertEquals((Integer) 6, child22.element());
		assertEquals(5, tree.elements().size());
		assertEquals(5, tree.positions().size());
		assertEquals(2, tree.depth(child22));
		assertEquals(2, tree.ancestors(child22).size());
		assertEquals(0, tree.descendants(child22).size());
		assertEquals(4, tree.descendants(root).size());
		assertEquals("1 (2 3 (5 6))", tree.toString());

		// 1 (2 3 (5 6 (8)))
		Position<Integer> child221 = tree.insertChild(child22, 8);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child221));
		assertTrue(tree.isExternal(child221));
		assertFalse(tree.isEmpty());
		assertEquals(6, tree.size());
		assertEquals(3, tree.height());
		assertEquals(child221, tree.children(child22).get(0));
		assertEquals((Integer) 8, child221.element());
		assertEquals(6, tree.elements().size());
		assertEquals(6, tree.positions().size());
		assertEquals(3, tree.depth(child221));
		assertEquals(3, tree.ancestors(child221).size());
		assertEquals(0, tree.descendants(child221).size());
		assertEquals(5, tree.descendants(root).size());
		assertEquals("1 (2 3 (5 6 (8)))", tree.toString());

		tree.replaceElement(child2, 9);
		assertEquals("1 (2 9 (5 6 (8)))", tree.toString());

		tree.swapElements(child21, child22);
		assertEquals("1 (2 9 (6 5 (8)))", tree.toString());
	}

	@Test
	public void test3() {
		BinaryTree<Integer> tree = new LinkedBinaryTree<>();

		// empty tree
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(0, tree.elements().size());
		assertEquals(0, tree.positions().size());
		assertEquals("", tree.toString());

		// 1
		Position<Integer> root = tree.addRoot(1);
		assertFalse(tree.isInternal(root));
		assertTrue(tree.isExternal(root));
		assertFalse(tree.isEmpty());
		assertEquals(1, tree.size());
		assertEquals(0, tree.height());
		assertEquals(1, tree.elements().size());
		assertEquals(1, tree.positions().size());
		assertEquals(root, tree.root());
		assertEquals((Integer) 1, root.element());
		assertEquals(0, tree.depth(root));
		assertEquals(0, tree.ancestors(root).size());
		assertEquals(0, tree.descendants(root).size());
		assertEquals("1", tree.toString());

		// 1 (2)
		Position<Integer> child1 = tree.insertLeft(root, 2);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child1));
		assertTrue(tree.isExternal(child1));
		assertFalse(tree.isEmpty());
		assertEquals(2, tree.size());
		assertEquals(1, tree.height());
		assertEquals(child1, tree.leftChild(tree.root()));
		assertEquals((Integer) 2, child1.element());
		assertEquals(2, tree.elements().size());
		assertEquals(2, tree.positions().size());
		assertEquals(1, tree.depth(child1));
		assertEquals(1, tree.ancestors(child1).size());
		assertEquals(0, tree.descendants(child1).size());
		assertEquals(1, tree.descendants(root).size());
		assertEquals("1 (2)", tree.toString());

		// 1 (2 3)
		Position<Integer> child2 = tree.insertRight(root, 3);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child2));
		assertTrue(tree.isExternal(child2));
		assertFalse(tree.isEmpty());
		assertEquals(3, tree.size());
		assertEquals(1, tree.height());
		assertEquals(child2, tree.rightChild(tree.root()));
		assertEquals((Integer) 3, child2.element());
		assertEquals(3, tree.elements().size());
		assertEquals(3, tree.positions().size());
		assertEquals(1, tree.depth(child2));
		assertEquals(1, tree.ancestors(child2).size());
		assertEquals(0, tree.descendants(child2).size());
		assertEquals(2, tree.descendants(root).size());
		assertEquals("1 (2 3)", tree.toString());

		// 1 (2 3 (5))
		Position<Integer> child21 = tree.insertLeft(child2, 5);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child21));
		assertTrue(tree.isExternal(child21));
		assertFalse(tree.isEmpty());
		assertEquals(4, tree.size());
		assertEquals(2, tree.height());
		assertEquals(child21, tree.leftChild(child2));
		assertEquals((Integer) 5, child21.element());
		assertEquals(4, tree.elements().size());
		assertEquals(4, tree.positions().size());
		assertEquals(2, tree.depth(child21));
		assertEquals(2, tree.ancestors(child21).size());
		assertEquals(0, tree.descendants(child21).size());
		assertEquals(3, tree.descendants(root).size());
		assertEquals("1 (2 3 (5))", tree.toString());

		// 1 (2 3 (5 6))
		Position<Integer> child22 = tree.insertRight(child2, 6);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child22));
		assertTrue(tree.isExternal(child22));
		assertFalse(tree.isEmpty());
		assertEquals(5, tree.size());
		assertEquals(2, tree.height());
		assertEquals(child22, tree.rightChild(child2));
		assertEquals((Integer) 6, child22.element());
		assertEquals(5, tree.elements().size());
		assertEquals(5, tree.positions().size());
		assertEquals(2, tree.depth(child22));
		assertEquals(2, tree.ancestors(child22).size());
		assertEquals(0, tree.descendants(child22).size());
		assertEquals(4, tree.descendants(root).size());
		assertEquals("1 (2 3 (5 6))", tree.toString());

		// 1 (2 3 (5 6 (8)))
		Position<Integer> child221 = tree.insertRight(child22, 8);
		assertTrue(tree.isInternal(root));
		assertFalse(tree.isExternal(root));
		assertFalse(tree.isInternal(child221));
		assertTrue(tree.isExternal(child221));
		assertFalse(tree.isEmpty());
		assertEquals(6, tree.size());
		assertEquals(3, tree.height());
		assertEquals(child221, tree.rightChild(child22));
		assertEquals((Integer) 8, child221.element());
		assertEquals(6, tree.elements().size());
		assertEquals(6, tree.positions().size());
		assertEquals(3, tree.depth(child221));
		assertEquals(3, tree.ancestors(child221).size());
		assertEquals(0, tree.descendants(child221).size());
		assertEquals(5, tree.descendants(root).size());
		assertEquals("1 (2 3 (5 6 (8)))", tree.toString());

		tree.replaceElement(child2, 9);
		assertEquals("1 (2 9 (5 6 (8)))", tree.toString());

		tree.swapElements(child21, child22);
		assertEquals("1 (2 9 (6 5 (8)))", tree.toString());

		StringBuffer sb1 = new StringBuffer();
		tree.traversePreOrder(p -> sb1.append(p.element().toString() + " "));
		assertEquals("1 2 9 6 5 8 ", sb1.toString());
		StringBuffer sb2 = new StringBuffer();
		tree.traversePostOrder(p -> sb2.append(p.element().toString() + " "));
		assertEquals("2 6 8 5 9 1 ", sb2.toString());
		StringBuffer sb3 = new StringBuffer();
		tree.traverseInOrder(p -> sb3.append(p.element().toString() + " "));
		assertEquals("2 1 6 9 5 8 ", sb3.toString());
	}

	@Test
	public void test2() {
		Tree<Integer> tree = new LinkedBinaryTree<>();
		Position<Integer> p = tree.addRoot(0);
		for (int i = 1; i < 100; i++) {
			p = tree.insertChild(p, i);
			assertFalse(tree.isEmpty());
			assertEquals(i + 1, tree.size());
			assertEquals(i, tree.height());
			assertEquals(i + 1, tree.elements().size());
			assertEquals(i + 1, tree.positions().size());
			assertEquals(i, tree.depth(p));
			assertEquals(i, tree.ancestors(p).size());
			assertEquals(0, tree.descendants(p).size());
			assertEquals(i, tree.descendants(tree.root()).size());
		}
	}

	@Test
	public void test4() {
		BinaryTree<Integer> tree = new LinkedBinaryTree<>();
		Position<Integer> p = tree.addRoot(0);
		for (int i = 1; i < 100; i++) {
			p = tree.insertLeft(p, i);
			assertFalse(tree.isEmpty());
			assertEquals(i + 1, tree.size());
			assertEquals(i, tree.height());
			assertEquals(i + 1, tree.elements().size());
			assertEquals(i + 1, tree.positions().size());
			assertEquals(i, tree.depth(p));
			assertEquals(i, tree.ancestors(p).size());
			assertEquals(0, tree.descendants(p).size());
			assertEquals(i, tree.descendants(tree.root()).size());
		}
	}

	@Test
	public void test5() {
		BinaryTree<Integer> tree = new LinkedBinaryTree<>();
		Position<Integer> p = tree.addRoot(0);
		for (int i = 1; i < 100; i++) {
			p = tree.insertRight(p, i);
			assertFalse(tree.isEmpty());
			assertEquals(i + 1, tree.size());
			assertEquals(i, tree.height());
			assertEquals(i + 1, tree.elements().size());
			assertEquals(i + 1, tree.positions().size());
			assertEquals(i, tree.depth(p));
			assertEquals(i, tree.ancestors(p).size());
			assertEquals(0, tree.descendants(p).size());
			assertEquals(i, tree.descendants(tree.root()).size());
		}
	}

	@Test
	public void test5b() {

	BinaryTree<Integer> tree = new LinkedBinaryTree<>();
		Position<Integer> root = tree.addRoot(0);
		Position<Integer> child1 = tree.insertLeft(root, 1);
		Position<Integer> child2 = tree.insertRight(root, 2);
		tree.insertLeft(child1, 11);
		tree.insertRight(child1, 12);
		tree.insertLeft(child2, 21);
		tree.insertRight(child2, 22);
		assertFalse(tree.isEmpty());
		assertEquals(tree.size(), 7);
		assertEquals("0 (1 (11 12) 2 (21 22))", tree.toString());
		tree.removeLeaf(tree.leftChild(child1));
		assertEquals("0 (1 (12) 2 (21 22))", tree.toString());
		tree.removeLeaf(tree.rightChild(child1));
		assertEquals("0 (1 2 (21 22))", tree.toString());
		tree.removeLeaf(tree.rightChild(child2));
		assertEquals("0 (1 2 (21))", tree.toString());
		tree.removeLeaf(tree.leftChild(child2));
		assertEquals("0 (1 2)", tree.toString());
		tree.removeLeaf(child2);
		assertEquals("0 (1)", tree.toString());
		tree.removeLeaf(child1);
		assertEquals(1, tree.size());
		assertEquals("0", tree.toString());
		tree.removeLeaf(root);
		assertEquals("", tree.toString());
		assertEquals(0, tree.size());

	}

	public void test6() {
		assertThrows(EmptyTreeException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.height();
		});
	}

	public void test7() {
		assertThrows(EmptyTreeException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.root();
		});
	}

	public void test8() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.parent(null);
		});
	}

	public void test9() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.parent(p);
		});
	}

	public void test10() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.children(null);
		});
	}

	public void test11() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.children(p);
		});
	}

	public void test12() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.descendants(null);
		});
	}

	public void test13() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.descendants(p);
		});
	}

	public void test14() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.ancestors(null);
		});
	}

	public void test15() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.ancestors(p);
		});
	}

	public void test16() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.isRoot(null);
		});
	}

	public void test17() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.isRoot(p);
		});
	}

	public void test18() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.isInternal(null);
		});
	}

	public void test19() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.isInternal(p);
		});
	}

	public void test20() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.isExternal(null);
		});
	}

	public void test21() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.isExternal(p);
		});
	}

	public void test22() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.depth(null);
		});
	}

	public void test23() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.depth(p);
		});
	}

	public void test24() {
		assertThrows(UnemptyTreeException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.addRoot(1);
			tree.addRoot(2);
		});
	}

	public void test25() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.insertChild(null, 1);
		});
	}

	public void test26() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.insertChild(p, 2);
		});
	}

	public void test27() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.replaceElement(null, 1);
		});
	}

	public void test28() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.replaceElement(p, 2);
		});
	}

	public void test29() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.swapElements(null, null);
		});
	}

	public void test30() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			Position<Integer> q = tree1.addRoot(2);
			tree1.swapElements(p, q);
		});
	}

	public void test31() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.leftChild(null);
		});
	}

	public void test32() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.leftChild(p);
		});
	}

	public void test33() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.rightChild(null);
		});
	}

	public void test34() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.rightChild(p);
		});
	}

	public void test35() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.sibling(null);
		});
	}

	public void test36() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.sibling(p);
		});
	}

	public void test37() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.hasLeft(null);
		});
	}

	public void test38() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.hasLeft(p);
		});
	}

	public void test39() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.hasRight(null);
		});
	}

	public void test40() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.hasRight(p);
		});
	}

	public void test41() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.insertLeft(null, 1);
		});
	}

	public void test42() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.insertLeft(p, 1);
		});
	}

	public void test43() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.insertRight(null, 1);
		});
	}

	public void test44() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.insertRight(p, 1);
		});
	}

	public void test45() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree = new LinkedBinaryTree<>();
			tree.insertChildren(null, 1, 2);
		});
	}

	public void test46() {
		assertThrows(InvalidPositionException.class, () -> {
			BinaryTree<Integer> tree1 = new LinkedBinaryTree<>();
			BinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
			Position<Integer> p = tree2.addRoot(1);
			tree1.insertChildren(p, 1, 2);
		});
	}


}
