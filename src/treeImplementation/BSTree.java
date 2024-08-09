package treeImplementation;

import Interfaces.BSTreeADT;
import Interfaces.Iterator;

public class BSTree<E> implements BSTreeADT {

  /**
   * The node at the root of the Binary Search Tree will be returned.
   *
   * @return node stored at the root of tree is returned or null if
   * the tree is empty
   */
  @Override
  public BSTreeNode getRoot() {
    return null;
  }

  /**
   * Determines the row height of the tree and returns that value as an
   * integer value.
   *
   * @return the height of the tree.
   */
  @Override
  public int getHeight() {
    return 0;
  }

  /**
   * The number of elements currently stored in the tree is counted and
   * the value is returned.
   *
   * @return number of elements currently stored in tree.
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * Checks if the tree is currently empty.
   *
   * @return returns boolean true if the tree is empty otherwise false.
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * Clears all elements currently stored in tree and makes the tree empty.
   */
  @Override
  public void clear() {

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
  public boolean contains(Comparable entry) throws NullPointerException {
    return false;
  }

  /**
   * Retrieves a node from the tree given the object to search for.
   *
   * @param entry element object being searched
   * @return the node with the element located in tree, null if not found
   * @throws NullPointerException if the element being passed in is null
   */
  @Override
  public BSTreeNode search(Comparable entry) throws NullPointerException {
    return null;
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
  public boolean add(Comparable newEntry) throws NullPointerException {
    return false;
  }

  /**
   * Removes the smallest element in the tree according to the natural
   * ordering established by the Comparable implementation.
   *
   * @return the removed element or null if the tree is empty
   */
  @Override
  public BSTreeNode removeMin() {
    return null;
  }

  /**
   * Removes the largest element in the tree according to the natural
   * ordering established by the Comparable implementation.
   *
   * @return the removed element or null if the tree is empty
   */
  @Override
  public BSTreeNode removeMax() {
    return null;
  }

  /**
   * Generates an in-order iteration over the contents of the tree. Elements
   * are in their natural order.
   *
   * @return an iterator with the elements in the natural order
   */
  @Override
  public Iterator inorderIterator() {
    return null;
  }

  /**
   * Generates a pre-order iteration over the contents of the tree. Elements
   * are order in such a way as the root element is first.
   *
   * @return an iterator with the elements in a root element first order
   */
  @Override
  public Iterator preorderIterator() {
    return null;
  }

  /**
   * Generates a post-order iteration over the contents of the tree. Elements
   * are order in such a way as the root element is last.
   *
   * @return an iterator with the elements in a root element last order
   */
  @Override
  public Iterator postorderIterator() {
    return null;
  }
}
