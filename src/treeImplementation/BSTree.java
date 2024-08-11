package treeImplementation;

import Interfaces.BSTreeADT;
import Interfaces.Iterator;

import java.util.Stack;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {

  private BSTreeNode<E> root;
  private int size;

  public BSTree() {
    root = null;
    size = 0;
  }
  /**
   * The node at the root of the Binary Search Tree will be returned.
   *
   * @return node stored at the root of tree is returned or null if
   * the tree is empty
   */
  @Override
  public BSTreeNode<E> getRoot() {
    return root;
  }

  /**
   * Determines the row height of the tree and returns that value as an
   * integer value.
   *
   * @return the height of the tree.
   */
  @Override
  public int getHeight() {
    return getHeight(root);
  }

  private int getHeight(BSTreeNode<E> node) {
    if (node == null) {
      return -1;
    }
    return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
  }

  /**
   * The number of elements currently stored in the tree is counted and
   * the value is returned.
   *
   * @return number of elements currently stored in tree.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Checks if the tree is currently empty.
   *
   * @return returns boolean true if the tree is empty otherwise false.
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Clears all elements currently stored in tree and makes the tree empty.
   */
  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  /**
   * Checks the current tree to see if the element passed in is stored in
   * the tree. If the element is found in the tree the method returns true
   * and if the element is not in the tree the method returns false.
   *
   * @param entry the element to find in the tree
   * @return returns boolean true if element is currently in the tree and
   * false if the element is not found in the tree
   * @throws NullPointerException if the element being passed in is null
   */
  @Override
  public boolean contains(E entry) throws NullPointerException {
    if (entry == null) throw new NullPointerException("Entry can't be null");
    return search(entry) != null;
  }

  /**
   * Retrieves a node from the tree given the object to search for.
   *
   * @param entry element object being searched
   * @return the node with the element located in tree, null if not found
   * @throws NullPointerException if the element being passed in is null
   */
  @Override
  public BSTreeNode<E> search(E entry) throws NullPointerException {
    if (entry == null) throw new NullPointerException("Entry can't be null");
    return search(root, entry);
  }

  private BSTreeNode<E> search(BSTreeNode<E> node, E entry) {
    if (node == null) {
      return null;
    }
    int cmp = entry.compareTo(node.getData());
    if (cmp < 0) {
      return search(node.getLeft(), entry);
    } else if (cmp > 0) {
      return search(node.getRight(), entry);
    } else {
      return node;
    }
  }

  /**
   * Adds a new element to the tree according to the natural ordering
   * established by the Comparable implementation.
   *
   * @param newEntry the element being added to the tree
   * @return a boolean true if the element is added successfully else false
   * @throws NullPointerException if the element being passed in is null
   */
  @Override
  public boolean add(E newEntry) throws NullPointerException {
    if (newEntry == null) throw new NullPointerException("Entry can't be null");
    if (root == null) {
      root = new BSTreeNode<>(newEntry);
      size++;
      return true;
    }
    return add(root, null, newEntry);
  }

  private boolean add(BSTreeNode<E> node, BSTreeNode<E> parent, E entry) {
    if (node == null) {
      BSTreeNode<E> newNode = new BSTreeNode<>(entry);
      newNode.setParent(parent);
      if (entry.compareTo(parent.getData()) < 0) {
        parent.setLeft(newNode);
      } else {
        parent.setRight(newNode);
      }
      size++;
      return true;
    }
    int cmp = entry.compareTo(node.getData());
    if (cmp < 0) {
      return add(node.getLeft(), node, entry);
    } else if (cmp > 0) {
      return add(node.getRight(), node, entry);
    } else {
      return false;
    }
  }

  /**
   * Removes the smallest element in the tree according to the natural
   * ordering established by the Comparable implementation.
   *
   * @return the removed element or null if the tree is empty
   */
  @Override
  public BSTreeNode<E> removeMin() {
    if (root == null) {
      return null;
    }
    BSTreeNode<E> node = root;
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    if (node == root) {
      root = root.getRight();
    } else {
      node.getParent().setLeft(node.getRight());
    }
    size--;
    return node;
  }

  /**
   * Removes the largest element in the tree according to the natural
   * ordering established by the Comparable implementation.
   *
   * @return the removed element or null if the tree is empty
   */
  @Override
  public BSTreeNode<E> removeMax() {
    if (root == null) {
      return null;
    }
    BSTreeNode<E> node = root;
    while (node.getRight() != null) {
      node = node.getRight();
    }
    if (node == root) {
      root = root.getLeft();
    } else {
      node.getParent().setRight(node.getLeft());
    }
    size--;
    return node;
  }

  /**
   * Generates an in-order iteration over the contents of the tree. Elements
   * are in their natural order.
   *
   * @return an iterator with the elements in the natural order
   */
  @Override
  public Iterator<E> inorderIterator() {
    Stack<BSTreeNode<E>> stack = new Stack<>();
    BSTreeNode<E> node = root;
    while (node != null) {
      stack.push(node);
      node = node.getLeft();
    }
    return new Iterator<E>() {
      @Override
      public boolean hasNext() {
        return !stack.isEmpty();
      }

      @Override
      public E next() {
        BSTreeNode<E> node = stack.pop();
        E data = node.getData();
        node = node.getRight();
        while (node != null) {
          stack.push(node);
          node = node.getLeft();
        }
        return data;
      }
    };
  }

  /**
   * Generates a pre-order iteration over the contents of the tree. Elements
   * are order in such a way as the root element is first.
   *
   * @return an iterator with the elements in a root element first order
   */
  @Override
  public Iterator<E> preorderIterator() {
    Stack<BSTreeNode<E>> stack = new Stack<>();
    if (root != null) {
      stack.push(root);
    }
    return new Iterator<E>() {
      @Override
      public boolean hasNext() {
        return !stack.isEmpty();
      }

      @Override
      public E next() {
        BSTreeNode<E> node = stack.pop();
        if (node.getRight() != null) {
          stack.push(node.getRight());
        }
        if (node.getLeft() != null) {
          stack.push(node.getLeft());
        }
        return node.getData();
      }
    };
  }

  /**
   * Generates a post-order iteration over the contents of the tree. Elements
   * are order in such a way as the root element is last.
   *
   * @return an iterator with the elements in a root element last order
   */
  @Override
  public Iterator<E> postorderIterator() {

    return null;

  }
}

