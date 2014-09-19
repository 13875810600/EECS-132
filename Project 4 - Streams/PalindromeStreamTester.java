import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * JUnit tests for palindromeStream
 * 
 * @author Sarah Whelan
 */

public class PalindromeStreamTester extends TestCase{
  /**
   * PalindromeStream to test value will vary
   */
  private PalindromeStream tester;
  
  /**
   * test the next method of PalindromeStream
   */
  public void testNext(){
    //single character string
    tester = new PalindromeStream("a");
    assertEquals("b", tester.next());
    assertEquals("c", tester.next());
    assertEquals("d", tester.next());
    assertEquals("e", tester.next());
    
    //strings of differnet lengths
    tester = new PalindromeStream("ab");
    assertEquals("bb", tester.next());
    assertEquals("cc", tester.next());
    assertEquals("dd", tester.next());
    assertEquals("ee", tester.next());
    
    //test empty string
    tester = new PalindromeStream("");
    assertEquals("a", tester.next());
    assertEquals("b", tester.next());
    assertEquals("c", tester.next());
    assertEquals("d", tester.next());
    
    //a case that passes z and goes back to a
    tester = new PalindromeStream("zz");
    assertEquals("aaa", tester.next());
    assertEquals("aba", tester.next());
    assertEquals("aca", tester.next());
    assertEquals("ada", tester.next());
    
    //strings of different length and passes z and goes back to a
    tester = new PalindromeStream("zzz");
    assertEquals("aaaa", tester.next());
    assertEquals("abba", tester.next());
    assertEquals("acca", tester.next());
    assertEquals("adda", tester.next());
  }
}