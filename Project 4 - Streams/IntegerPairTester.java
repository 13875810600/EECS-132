import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * JUnit Testing for the IntegerPair Class
 * 
 * @author Sarah Whelan
 */

public class IntegerPairTester extends TestCase{
  /**
   * The tester object of Integer Pair
   */
  private IntegerPair tester = new IntegerPair(1,2);
  
  /**
   * tests first getter method
   */
  public void testGetValue1(){
    assertEquals((Integer)1, tester.getValue1());
  }
  
  /**
   * tests second getter method
   */
  public void testGetValue2(){
    assertEquals((Integer)2, tester.getValue2());
  }
  
  /**
   * tests the to string method
   */
  public void testToString(){
    assertEquals("(1,2)", tester.toString());
  }
}
