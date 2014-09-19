import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * JUnit Testing for PrimeStream
 * 
 * @author Sarah Whelan
 */

public class PrimeStreamTester extends TestCase{
  /**
   * the PrimeStream to test
   */
  private PrimeStream tester;
  
  /**
   * test the next method the stream should return prime numbers
   */
  public void testNext(){
    tester = new PrimeStream();
    //the prime numbers
    assertEquals((Integer)2, tester.next());
    assertEquals((Integer)3, tester.next());
    assertEquals((Integer)5, tester.next());
    assertEquals((Integer)7, tester.next());
    assertEquals((Integer)11, tester.next());
    assertEquals((Integer)13, tester.next());
    assertEquals((Integer)17, tester.next());
    assertEquals((Integer)19, tester.next());
  }
}
