import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * JUnit Testing of the MersennePrimeStream Class
 * 
 * @author Sarah Whelan
 */

public class MersennePrimeStreamTester extends TestCase{
  /**
   * a test stream
   */
  private MersennePrimeStream tester;
  
  /**
   * tests the next method only tests first four values because using the sieve of eratosthenes in the prime
   * stream class is inefficent and causes a stack overflow
   */
  public void testNext(){
    /**
     * a MerseenePrimeStream to use as the test object becuase the method is not static
     */
    tester = new MersennePrimeStream();
    
    //tests the integers in order they should appear
    //cannot test more than this (inefficiency will cause stack overflow)
    assertEquals((Integer)3, tester.next());
    assertEquals((Integer)7, tester.next());
    assertEquals((Integer)31, tester.next());
    assertEquals((Integer)127, tester.next());
  }
}
