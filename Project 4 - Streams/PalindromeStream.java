/**
 * Programming Project 4
 * <p>
 * A Palindrome Stream that is a String Stream that only has palindromes by way of a PalindromeFilter
 * 
 * @author Sarah Whelan
 */

public class PalindromeStream extends StringStream{
  /**
   * a filter that only allows strings that are palindromes no upstreamFilter
   */
  private PalindromeFilter filter = new PalindromeFilter(null);
  
  /**
   * passes starting value to Stream constructor
   * 
   * @param value the initial value of the stream (does not have to be a plaindrome)
   */
  public PalindromeStream(String value){
    super(value);
  }
  
  /**
   * Overriden next method of stream
   * @return the next palindrome in lexicographical order by checking the next value in the stream until a 
   * palindrome is found (recursive)
   */
  @Override
  public String next(){
    //saves the next value to check it without calling next() more than once
    String next = super.next();
    if(filter.passFilter(next))
      return next;
    else
      return this.next();
  }
}