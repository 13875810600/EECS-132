import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * JUnit Testing for the NotMultipleFilter
 * 
 * @author Sarah Whelan
 */

public class NotMultipleFilterTester extends TestCase{
  
  /**
   * an upstream filter
   */
  private NotMultipleFilter testingUpstream;
  
  /**
   * the main filter
   */
  private NotMultipleFilter tester;
  
  /**
   * test the passFilter method
   */
  public void testPassFilter(){
    //the upstream filter does not allow multiples of 4
    testingUpstream = new NotMultipleFilter(4, null);
    //the main filter does not allow multiples of 2 or 4(because of the upstream filter
    tester = new NotMultipleFilter(2, testingUpstream);
    //basic tests also tests 0
    assertEquals(false, tester.passFilter(8));
    assertEquals(true, tester.passFilter(0));
    assertEquals(false, tester.passFilter(4));
    assertEquals(false, tester.passFilter(2));
    assertEquals(true, tester.passFilter(3));
    assertEquals(true, tester.passFilter(5));
    
    //tests a filter of 0 should return true for all because nothing is a multiple of zero
    tester = new NotMultipleFilter(0, null);
    assertEquals(true, tester.passFilter(8));
    assertEquals(true, tester.passFilter(0));
    assertEquals(true, tester.passFilter(4));
    assertEquals(true, tester.passFilter(2));
    assertEquals(true, tester.passFilter(3));
    assertEquals(true, tester.passFilter(5));
    
    //tests for 1 eveyrthing except for zero should be a multiple of 1
    tester = new NotMultipleFilter(1, null);
    assertEquals(false, tester.passFilter(8));
    assertEquals(true, tester.passFilter(0));
    assertEquals(false, tester.passFilter(4));
    assertEquals(false, tester.passFilter(2));
    assertEquals(false, tester.passFilter(3));
    assertEquals(false, tester.passFilter(5));
    
    //general test / test many
    tester = new NotMultipleFilter(3, null);
    assertEquals(false, tester.passFilter(3));
    assertEquals(false, tester.passFilter(6));
    assertEquals(false, tester.passFilter(9));
    assertEquals(true, tester.passFilter(2));
    assertEquals(true, tester.passFilter(5));
    assertEquals(true, tester.passFilter(7));    
    assertEquals(true, tester.passFilter(0));
    assertEquals(true, tester.passFilter(1));
  }
}
