import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * palindrome Filter Tester class
 * 
 * @author Sarah Whelan
 */

public class PalindromeFilterTester extends TestCase{
  /**
   * an upstream Filter
   */
  private PalindromeFilter testingUpstream;
  
  /**
   * main palindrome filter
   */
  private PalindromeFilter tester;
  
  /**
   * test for the passFilter method of palindromeFilter
   */
  public void testPassFilter(){
    /**
     * an upstream filter that does not have an upstream filter
     */
    testingUpstream = new PalindromeFilter(null);
    tester = new PalindromeFilter(testingUpstream);
    //tests two palindrome filters and tests differnt length and odd even lengths
    assertEquals(true, tester.passFilter("racecar"));
    assertEquals(false, tester.passFilter("racercar"));
    assertEquals(true, tester.passFilter(""));
    assertEquals(true, tester.passFilter(" abcba "));
    assertEquals(true, tester.passFilter("fghjhgf"));
    assertEquals(true, tester.passFilter("fghhgf"));
    assertEquals(true, tester.passFilter("fghgf"));
    assertEquals(true, tester.passFilter("fggf"));
    assertEquals(true, tester.passFilter("fgf"));
    assertEquals(true, tester.passFilter("ff"));
    assertEquals(true, tester.passFilter("f"));
    assertEquals(false, tester.passFilter("fg"));
    //changes where it is no longer a palindrome
    assertEquals(false, tester.passFilter("fghjhg"));
    assertEquals(false, tester.passFilter("ghjhgf"));
    assertEquals(false, tester.passFilter("fghjgf"));
    
    //tests without the upstream filter
    tester = new PalindromeFilter(null);
    assertEquals(true, tester.passFilter("racecar"));
    assertEquals(false, tester.passFilter("racercar"));
    assertEquals(true, tester.passFilter(""));
    assertEquals(true, tester.passFilter(" abcba "));
  }
}
