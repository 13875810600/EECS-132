import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * JUnit Testing for StringStream
 * 
 * @author Sarah Whelan
 */

public class StringStreamTester extends TestCase{
  /**
   * testing object StringStream
   */
  private StringStream tester;
  
  /**
   * test the next method of the StringStream the string stream should return next String in lexicographical order
   */
  public void testNext(){
    
    //strings of single character length
    tester = new StringStream("a");
    assertEquals("b", tester.next());
    assertEquals("c", tester.next());
    assertEquals("d", tester.next());
    assertEquals("e", tester.next());

    //empty string test
    tester = new StringStream("");
    assertEquals("a", tester.next());
    assertEquals("b", tester.next());
    assertEquals("c", tester.next());
    assertEquals("d", tester.next());
    
    //test different length strings
    tester = new StringStream("ab");
    assertEquals("ac", tester.next());
    assertEquals("ad", tester.next());
    assertEquals("ae", tester.next());
    assertEquals("af", tester.next());
    
    //test transition from z to a
    tester = new StringStream("ay");
    assertEquals("az", tester.next());
    assertEquals("ba", tester.next());
    assertEquals("bb", tester.next());
    assertEquals("bc", tester.next());
    
    //additional letter added
    tester = new StringStream("zz");
    assertEquals("aaa", tester.next());
    assertEquals("aab", tester.next());
    assertEquals("aac", tester.next());
    assertEquals("aad", tester.next());
    
    //additonal letter added
    tester = new StringStream("zzz");
    assertEquals("aaaa", tester.next());
    assertEquals("aaab", tester.next());
    assertEquals("aaac", tester.next());
    assertEquals("aaad", tester.next());
    
    //test many
    tester = new StringStream("trv");
    assertEquals("trw", tester.next());
    assertEquals("trx", tester.next());
    assertEquals("try", tester.next());
    assertEquals("trz", tester.next());
    assertEquals("tsa", tester.next());
  }
}