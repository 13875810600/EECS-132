import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * test not multiple stream
 * 
 * @author Sarah Whelan
 */

public class NotMultipleStreamTester extends TestCase{
  /**
   * test object of NotMultipleStream
   */  
  private NotMultipleStream tester;
  
  /**
   * tests the next method of NotMultipleStream
   */
  public void testNext(){
    //tests initial value 0 base value 2
    tester = new NotMultipleStream(2, 0);
    assertEquals((Integer)1, tester.next());
    assertEquals((Integer)3, tester.next());
    assertEquals((Integer)5, tester.next());
    assertEquals((Integer)7, tester.next());
    
    //tests both zero
    tester = new NotMultipleStream(0, 0);
    assertEquals((Integer)1, tester.next());
    assertEquals((Integer)2, tester.next());
    assertEquals((Integer)3, tester.next());
    
    //test negative
    tester = new NotMultipleStream(3, -74);
    assertEquals((Integer)(-73), tester.next());
    assertEquals((Integer)(-71), tester.next());
    assertEquals((Integer)(-70), tester.next());
    assertEquals((Integer)(-68), tester.next());
  }
}
