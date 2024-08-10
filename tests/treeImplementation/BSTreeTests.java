package treeImplementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTests {

  BSTree<Integer> tree = new BSTree<>();

  @BeforeEach
  void setUp() {
    tree.add(5);
    tree.add(3);
    tree.add(7);
    tree.add(2);
    tree.add(4);
    tree.add(6);
    tree.add(8);
  }

  @AfterEach
  void tearDown() {
    tree.clear();
  }

  @Test
  void getRoot() {
    assertEquals(5, tree.getRoot().getData());
  }

  @Test
  void getHeight() {
    assertEquals(2, tree.getHeight());
  }

  @Test
  void size() {
    assertEquals(7, tree.size());
  }

  @Test
  void isEmpty() {
    assertFalse(tree.isEmpty());
  }

  @Test
  void clear() {
    tree.clear();
    assertTrue(tree.isEmpty());
  }

  @Test
  void contains() {
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(3));
    assertTrue(tree.contains(7));
    assertTrue(tree.contains(2));
    assertTrue(tree.contains(4));
    assertTrue(tree.contains(6));
    assertTrue(tree.contains(8));
    assertFalse(tree.contains(1));
  }

  @Test
  void search() {
    assertEquals(5, tree.search(5).getData());
    assertEquals(3, tree.search(3).getData());
    assertEquals(7, tree.search(7).getData());
    assertEquals(2, tree.search(2).getData());
    assertEquals(4, tree.search(4).getData());
    assertEquals(6, tree.search(6).getData());
    assertEquals(8, tree.search(8).getData());
    assertNull(tree.search(1));
  }

  @Test
  void add() {
    tree.add(1);
    assertTrue(tree.contains(1));

  }

  @Test
  void removeMin() {
    tree.removeMin();
    assertFalse(tree.contains(2));
    assertTrue(tree.contains(3));

    tree.removeMin();
    assertFalse(tree.contains(3));
  }

  @Test
  void removeMax() {
    tree.removeMax();
    assertFalse(tree.contains(8));
    assertTrue(tree.contains(7));

    tree.removeMax();
    assertFalse(tree.contains(7));
  }

  @Test
  void inorderIterator() {
  }

  @Test
  void preorderIterator() {
  }

  @Test
  void postorderIterator() {
  }
}