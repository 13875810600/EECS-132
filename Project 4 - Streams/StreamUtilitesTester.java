import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * Programming Project 4
 * <p>
 * tests for the StreamUtilites class
 * 
 * @author Sarah Whelan
 */

public class StreamUtilitesTester extends TestCase{
  
  /**
   * the tests for the print method will be submitted seperately because this method System.out.prinln Stream values
   */
  
  /**
   * test the sum method
   */
  public void testSum(){
    //test with 0 as the initial value for string
    //test 0 times
    IntegerStream testStream1 = new IntegerStream(0);
    assertEquals((Integer)0, StreamUtilities.sum(testStream1, 0));
    //test 1 time
    IntegerStream testStream2 = new IntegerStream(0);
    assertEquals((Integer)1, StreamUtilities.sum(testStream2, 1));
    //test many times
    IntegerStream testStream3 = new IntegerStream(0);
    assertEquals((Integer)15, StreamUtilities.sum(testStream3, 5));
    
    //test different initial values of stream
    //test 0 times
    IntegerStream testStream4 = new IntegerStream(37);
    assertEquals((Integer)0, StreamUtilities.sum(testStream4, 0));
    //test 1 time
    IntegerStream testStream5 = new IntegerStream(12);
    assertEquals((Integer)13, StreamUtilities.sum(testStream5, 1));
    //test many times
    IntegerStream testStream6 = new IntegerStream(56);
    assertEquals((Integer)295, StreamUtilities.sum(testStream6, 5));
    
    //test negative initial values
    IntegerStream testStream7 = new IntegerStream(-20);
    assertEquals((Integer)(-85), StreamUtilities.sum(testStream7, 5));
  }
  
  /**
   * test the product method
   */
  public void testProduct(){
    //test with 0 as the initial value for string
    //test 0 times
    IntegerStream testStream1 = new IntegerStream(0);
    assertEquals((Integer)0, StreamUtilities.product(testStream1, 0));
    //test 1 time
    IntegerStream testStream2 = new IntegerStream(0);
    assertEquals((Integer)1, StreamUtilities.product(testStream2, 1));
    //test many times
    IntegerStream testStream3 = new IntegerStream(0);
    assertEquals((Integer)120, StreamUtilities.product(testStream3, 5));
    
    //test different initial values of stream
    //test 0 times
    IntegerStream testStream4 = new IntegerStream(37);
    assertEquals((Integer)0, StreamUtilities.product(testStream4, 0));
    //test 1 time
    IntegerStream testStream5 = new IntegerStream(12);
    assertEquals((Integer)13, StreamUtilities.product(testStream5, 1));
    //test many times
    IntegerStream testStream6 = new IntegerStream(56);
    assertEquals((Integer)713897640, StreamUtilities.product(testStream6, 5));
    
    //test negative initial values
    IntegerStream testStream7 = new IntegerStream(-20);
    assertEquals((Integer)(-1395360), StreamUtilities.product(testStream7, 5));
  }
  
  /**
   * tests concatenate
   */
  public void testConcatenate(){
    //test empty string
    StringStream testStream1 = new StringStream("");
    assertEquals("abcd", StreamUtilities.concatenate(testStream1, 4));
    //test different lengths of strings
    StringStream testStream2 = new StringStream("a");
    assertEquals("bcd", StreamUtilities.concatenate(testStream2, 3));
    StringStream testStream3 = new StringStream("ab");
    assertEquals("acadae", StreamUtilities.concatenate(testStream3, 3));
    StringStream testStream4 = new StringStream("abc");
    assertEquals("abdabeabfabg", StreamUtilities.concatenate(testStream4, 4));
    //test 1 time
    StringStream testStream5 = new StringStream("abc");
    assertEquals("abd", StreamUtilities.concatenate(testStream5, 1));
    //test zero times
    StringStream testStream6 = new StringStream("ab");
    assertEquals("", StreamUtilities.concatenate(testStream6, 0));
  }
}
