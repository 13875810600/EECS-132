import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.util.LinkedList;

/**
 * Tester class for RailYard
 * 
 * @author Sarah Whelan
 */

public class RailYardTester extends TestCase {
  
  /**
   * tests the cycleSort method using an array for a train
   * test many
   */
  public void testCycleSortArray() { 
    Integer[] train = {6, 2, 5, 1, 8, 9, 10, 34, 4, 6, 7}; // integer becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.cycleSort(train);
    Integer[] shouldEqual = { 1, 2, 4, 5, 6, 6, 7, 8, 9, 10, 34 };
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test many
   */
  public void testCycleSortArray2() {
    Integer[] train = {0,0,0,0}; //integer becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.cycleSort(train);
    Integer[] shouldEqual = {0,0,0,0};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test railyard without collection yards
   */
  public void testCycleSortArray3() {
    Integer[] train = {2,0,0,0}; //integer becuase it has to be comparable
    int[] tracks = {};
    //railYard is not created Console alerts user.
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test collection yawrd without tracks
   */
  public void testCycleSortArray4() {
    Integer[] train = {0,0,2,0}; //integer becuase it has to be comparable
    int[] tracks = {0};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    //railyard exists but does not have any collection yards the user was notified
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test train without cars
   */
  public void testCycleSortArray5() {
    Integer[] train = {}; //integer becuase it has to be comparable
    int[] tracks = {5, 8, 10};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.cycleSort(train);
    Integer[] shouldEqual = {};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test many
   */
  public void testCycleSortArray6() {
    Integer[] train = {89, 67, 0, 5, 19, 35, 8}; //integer becuase it has to be comparable
    int[] tracks = {5, 8, 10};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.cycleSort(train);
    Integer[] shouldEqual = {0, 5, 8, 19, 35, 67, 89};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test duplicate train cars
   */
  public void testCycleSortArray7() {
    Integer[] train = {5, 5, 0, 5, 19, 35, 8}; //integer becuase it has to be comparable
    int[] tracks = {5, 8, 10};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.cycleSort(train);
    Integer[] shouldEqual = {0, 5, 5, 5, 8, 19, 35};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the cycleSort method using a linkedList for a train
   * test many
   */
  public void testCycleSortLinkedList() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(6);
    train.add(2);
    train.add(5);
    train.add(-1);
    train.add(8);
    train.add(9);
    train.add(10);
    train.add(34);
    train.add(4);
    train.add(6);
    train.add(7);
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.cycleSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    shouldEqual.add(-1);
    shouldEqual.add(2);
    shouldEqual.add(4);
    shouldEqual.add(5);
    shouldEqual.add(6);
    shouldEqual.add(6);
    shouldEqual.add(7);
    shouldEqual.add(8);
    shouldEqual.add(9);
    shouldEqual.add(10);
    shouldEqual.add(34);
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * tests the cycleSort method using a linkedList for a train
   * test duplicates
   */
  public void testCycleSortLinkedList1() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(6);
    train.add(5);
    train.add(5);
    train.add(5);
    train.add(8);
    train.add(9);
    train.add(5);
    train.add(34);
    train.add(4);
    train.add(6);
    train.add(0);
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.cycleSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    shouldEqual.add(0);
    shouldEqual.add(4);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(6);
    shouldEqual.add(6);
    shouldEqual.add(8);
    shouldEqual.add(9);
    shouldEqual.add(34);
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * tests the cycleSort method using a linkedList for a train
   * test empty train
   */
  public void testCycleSortLinkedList2() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.cycleSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * tests the cycleSort method using a linkedList for a train
   * test many/negative
   */
  public void testCycleSortLinkedList3() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(6);
    train.add(5);
    train.add(5);
    train.add(5);
    train.add(8);
    train.add(9);
    train.add(-5);
    train.add(34);
    train.add(-4);
    train.add(6);
    train.add(0);
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.cycleSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    shouldEqual.add(-5);
    shouldEqual.add(-4);
    shouldEqual.add(0);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(6);
    shouldEqual.add(6);
    shouldEqual.add(8);
    shouldEqual.add(9);
    shouldEqual.add(34);
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * Tests for Closest Sort
   */
  
   /**
   * tests the closestSort method using an array for a train
   * test many
   */
  public void testClosestSortArray() { 
    Integer[] train = {6, 2, 5, 1, 8, 9, 10, 34, 4, 6, 7}; //integer becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.closestSort(train);
    Integer[] shouldEqual = { 1, 2, 4, 5, 6, 6, 7, 8, 9, 10, 34 };
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the closestSort method using an array for a train
   * test many
   */
  public void testClosestSortArray2() {
    Integer[] train = {0,0,0,0}; //integer becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.closestSort(train);
    Integer[] shouldEqual = {0,0,0,0};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the closestSort method using an array for a train
   * test railyard without collection yards
   */
  public void testClosestSortArray3() {
    Integer[] train = {2,0,0,0}; //integer becuase it has to be comparable
    int[] tracks = {};
    //railYard is not created Console alerts user.
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
  }
  
  /**
   * tests the closestSort method using an array for a train
   * test collection yawrd without tracks
   */
  public void testClosestSortArray4() {
    Integer[] train = {0,0,2,0}; //integer becuase it has to be comparable
    int[] tracks = {0};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    //railyard exists but does not have any collection yards the user was notified
  }
  
  /**
   * tests the closestSort method using an array for a train
   * test train without cars
   */
  public void testClosestSortArray5() {
    Integer[] train = {}; //integer becuase it has to be comparable
    int[] tracks = {5, 8, 10};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.closestSort(train);
    Integer[] shouldEqual = {};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the closestSort method using an array for a train
   * test many
   */
  public void testClosestSortArray6() {
    Integer[] train = {89, 67, 0, 5, 19, 35, 8}; //integer becuase it has to be comparable
    int[] tracks = {5, 8, 10};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.closestSort(train);
    Integer[] shouldEqual = {0, 5, 8, 19, 35, 67, 89};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the closestSort method using an array for a train
   * test duplicate train cars
   */
  public void testClosestSortArray7() {
    Integer[] train = {5, 5, 0, 5, 19, 35, 8}; //integer becuase it has to be comparable
    int[] tracks = {5, 8, 10};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.closestSort(train);
    Integer[] shouldEqual = {0, 5, 5, 5, 8, 19, 35};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the closestSort method using a linkedList for a train
   * test many
   */
  public void testClosestSortLinkedList() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(6);
    train.add(2);
    train.add(5);
    train.add(-1);
    train.add(8);
    train.add(9);
    train.add(10);
    train.add(34);
    train.add(4);
    train.add(6);
    train.add(7);
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.closestSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    shouldEqual.add(-1);
    shouldEqual.add(2);
    shouldEqual.add(4);
    shouldEqual.add(5);
    shouldEqual.add(6);
    shouldEqual.add(6);
    shouldEqual.add(7);
    shouldEqual.add(8);
    shouldEqual.add(9);
    shouldEqual.add(10);
    shouldEqual.add(34);
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * tests the closestSort method using a linkedList for a train
   * test duplicates
   */
  public void testClosestSortLinkedList1() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(6);
    train.add(5);
    train.add(5);
    train.add(5);
    train.add(8);
    train.add(9);
    train.add(5);
    train.add(34);
    train.add(4);
    train.add(6);
    train.add(0);
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.closestSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    shouldEqual.add(0);
    shouldEqual.add(4);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(6);
    shouldEqual.add(6);
    shouldEqual.add(8);
    shouldEqual.add(9);
    shouldEqual.add(34);
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * tests the closestSort method using a linkedList for a train
   * test empty train
   */
  public void testClosestSortLinkedList2() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.closestSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * tests the closestSort method using a linkedList for a train
   * test many/negative
   */
  public void testClosestSortLinkedList3() {
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(6);
    train.add(5);
    train.add(5);
    train.add(5);
    train.add(8);
    train.add(9);
    train.add(-5);
    train.add(34);
    train.add(-4);
    train.add(6);
    train.add(0);
    int[] yards = {5, 6};
    RailYard<Integer> railYard = new RailYard<Integer>(yards);
    railYard.closestSort(train);
    LinkedList<Integer> shouldEqual = new LinkedList<Integer>();
    shouldEqual.add(-5);
    shouldEqual.add(-4);
    shouldEqual.add(0);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(5);
    shouldEqual.add(6);
    shouldEqual.add(6);
    shouldEqual.add(8);
    shouldEqual.add(9);
    shouldEqual.add(34);
    assertArrayEquals(shouldEqual.toArray(), train.toArray());
  }
  
  /**
   * Test cases That SHOULD fail
   */
  
  /**
   * Test works for cycle sort but fails for closest sort
   */
  public void testFailClosestSortArray() { 
    Integer[] train = {3,0,1,-1,-5,-2}; //integer becuase it has to be comparable
    int[] tracks = {4};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.closestSort(train);
    Integer[] shouldEqual = {-5,-2,-1,0,1,3};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * Test works for cycle sort but fails for closest sort
   */
  public void testFailCycleSortArray() { 
    Integer[] train = {3,0,1,-1,-5,-2}; //integer becuase it has to be comparable
    int[] tracks = {4};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.cycleSort(train);
    Integer[] shouldEqual = {-5,-2,-1,0,1,3};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * Test works for closest sort but fails for cycle sort
   */
  public void testFailClosestSortArray2() { 
    Integer[] train = {37,12,8,7,9,10,11,14,7,8,11,12,9}; //integer becuase it has to be comparable
    int[] tracks = {4};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.closestSort(train);
    Integer[] shouldEqual = {7,7,8,8,9,9,10,11,11,12,12,14,37};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * Test works for closest sort but fails for cycle sort
   */
  public void testFailCycleSortArray2() { 
    Integer[] train = {37,12,8,7,9,10,11,14,7,8,11,12,9}; //integer becuase it has to be comparable
    int[] tracks = {4};
    RailYard<Integer> railYard = new RailYard<Integer>(tracks);
    railYard.cycleSort(train);
    Integer[] shouldEqual = {7,7,8,8,9,9,10,11,11,12,12,14,37};
    assertArrayEquals(shouldEqual, train);
  }  
 
  /**
   * Test different generic and comparable types
   */
  
   /**
   * tests the cycleSort method using an array for a train
   * test many
   */
  public void testCycleSortArrayString() { 
    String[] train = {"p", "l", "h", "a", "b", "f"}; //String becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<String> railYard = new RailYard<String>(tracks);
    railYard.cycleSort(train);
    String[] shouldEqual = {"a", "b", "f", "h", "l", "p"};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test many
   */
  public void testClosestSortArrayString() { 
    String[] train = {"p", "l", "h", "a", "b", "f"}; //String becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<String> railYard = new RailYard<String>(tracks);
    railYard.closestSort(train);
    String[] shouldEqual = {"a", "b", "f", "h", "l", "p"};
    assertArrayEquals(shouldEqual, train);
  }
  
   /**
   * tests the cycleSort method using an array for a train
   * test many
   */
  public void testCycleSortArrayDouble() { 
    Double[] train = {6.5, 2.1, 5.3, 1.7, 8.9, 9.7, 10.0, 34.2, 4.3, 6.1, 7.5}; //double becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<Double> railYard = new RailYard<Double>(tracks);
    railYard.cycleSort(train);
    Double[] shouldEqual = {1.7, 2.1, 4.3, 5.3, 6.1, 6.5, 7.5, 8.9, 9.7, 10.0, 34.2};
    assertArrayEquals(shouldEqual, train);
  }
  
  /**
   * tests the cycleSort method using an array for a train
   * test many
   */
  public void testClosestSortArrayDouble() { 
    Double[] train = {6.5, 2.1, 5.3, 1.7, 8.9, 9.7, 10.0, 34.2, 4.3, 6.1, 7.5}; //double becuase it has to be comparable
    int[] tracks = {5, 6};
    RailYard<Double> railYard = new RailYard<Double>(tracks);
    railYard.cycleSort(train);
    Double[] shouldEqual = {1.7, 2.1, 4.3, 5.3, 6.1, 6.5, 7.5, 8.9, 9.7, 10.0, 34.2};
    assertArrayEquals(shouldEqual, train);
  }
  
}