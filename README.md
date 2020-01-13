# BTX 8062 Project
## Topic 4: Linked Trees and Binary Trees

Implement the data structures *Tree* and *BinaryTree* in Java using linked structures. For this consider the given Java interfaces ``Tree<E>``, ``BinaryTree<E>``, and ``Position<E>``. Use Java generics to fix the type of the elements stored in the trees.

1. For general trees, do the following:
  * Write two classes ``LinkedTree<E>`` and ``TreeNode<E>``, which implement the interfaces ``Tree<E>`` and ``Position<E>``.
  * For storing the list of children in a node, use a ``List<E>`` from Java (instance of either ``ArrayList<E>`` or ``LinkedList<E>``).
  * Override ``toString()`` to obtain a human-readable string representation of your tree:
    - ``""`` = empty tree
    - ``"1"`` = tree of size 1 with 1 at the root
    - ``"1 (2 3)""`` = tree of size 3 (the root 1 has two children 2 and 3)
    - ``"1 (2 (4 5 6) 3)"`` = tree of size 6 (the first child 2 of the root 1 has 3 children 4, 5, 6)
    - etc.

2. For binary trees, do the following:
  * Write two classes ``LinkedBinaryTree<E>`` and ``BinaryTreeNode<E>``, which implement the interfaces ``BinaryTree<E>`` and ``Position<E>``. Note that ``BinaryTree<E>`` inherits from ``Tree<E>``.
  * The inherited method ``insertChild(p, e)`` works as follows:
    - if ``p`` is external, insert a left child
    - else, if ``p`` has no left child, insert a left child
    - else, if ``p`` has no right child, insert a right child
    - else, throw an exception

3. For your implementation, follow the guidelines and pseudo-code algorithms from the course slides and exercises.

4. Write one or several example programs as a first test. Include the methods `` traversePreOrder(visit)`` and ``traversePostOrder(visit)`` in your examples.

5. Test your implementation with JUnit5. Corresponding JUnit test classes are given. Your  solution needs to pass all the tests.

6. Document our classes and the given interfaces with JavaDoc.

**Challenges**: In your ``LinkedTree`` and ``LinkedBinaryTree<E>`` classes, make sure that working with an invalid position can not damage the consistency of a tree. *Invalid position* means that the position belongs to another tree or that the position is one that has been removed. Make sure that the detection of invalid positions always runs in *O(1)* time. Furthermore, make sure that the methods ``height()`` and ``depth(p)`` run in *O(1)* time, similar to ``size()``.
