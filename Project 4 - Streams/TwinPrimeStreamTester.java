import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * JUnit Testing for TwinPrimeStream
 * 
 * @author Sarah Whelan
 */

public class TwinPrimeStreamTester extends TestCase{
  /**
   * a TwinPrimeStream to test
   */
  private TwinPrimeStream tester;
  
  /**
   * tests the next method of TwinPrimeStream by using the toString method of IntegerPair
   */
  public void testNext(){
    //creating the TwinPrimeStream
    tester = new TwinPrimeStream();
    
    //simply tests the pairs in order
    assertEquals("(3,5)", tester.next().toString());
    assertEquals("(5,7)", tester.next().toString());
    assertEquals("(11,13)", tester.next().toString());
    assertEquals("(17,19)", tester.next().toString());
    assertEquals("(29,31)", tester.next().toString());
    assertEquals("(41,43)", tester.next().toString());
  }
}
