/**
 * Programming Project 4
 * <p>
 * a filter for strings that only allows palindromes
 * 
 * @author Sarah Whelan
 */

public class PalindromeFilter extends Filter<String>{
  /**
   * consturctor that passes values to the Filter constructor
   * 
   * @param upstreamFilter the filter that will filterData before this filter
   */
  public PalindromeFilter(Filter<String> upstreamFilter){
    super(null, upstreamFilter);
  }
  
  /**
   * pass filter method checks if string is a palindrome
   * 
   * @param string the String to be tested for worthiness as a palindrome
   * @return true if the string is a palindrome (false otherwise)
   */
  public boolean passFilter(String string){
    //keeps track of if the upstream filter passed
    boolean passedUpstream = true;
    if(upstreamFilter != null){
      passedUpstream = upstreamFilter.passFilter(string);
    }
    //loops through the string one character at a time stoping at the middle chracter checking if both ends are equal
    for (int i = 0; i < string.length() / 2; i = i + 1) {
      if (string.charAt(i) != string.charAt(string.length() - i - 1))
        return false;
    }
    return passedUpstream;
  }
}