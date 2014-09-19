import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * Junit testing for Integer Stream
 * 
 * @author Sarah Whelan
 */

public class IntegerStreamTester extends TestCase{
  
  /**an IntegerStream to test initial value will change*/
  private IntegerStream tester;
  
  /**
   * test for the Next method of Integer stream values returned should have been incremented by 1
   */
  public void testNext(){
    //test many case
    tester = new IntegerStream(10);
    assertEquals((Integer)11, tester.next());
    assertEquals((Integer)12, tester.next());
    assertEquals((Integer)13, tester.next());
    assertEquals((Integer)14, tester.next());
    
    //test zero
    tester = new IntegerStream(0);
    assertEquals((Integer)1, tester.next());
    assertEquals((Integer)2, tester.next());
    assertEquals((Integer)3, tester.next());
    
    //test negative values
    tester = new IntegerStream(-76);
    assertEquals((Integer)(-75), tester.next());
    assertEquals((Integer)(-74), tester.next());
    assertEquals((Integer)(-73), tester.next());
    
    //test negative values to positive values
    tester = new IntegerStream(-2);
    assertEquals((Integer)(-1), tester.next());
    assertEquals((Integer)(0), tester.next());
    assertEquals((Integer)(1), tester.next());
  }
}
