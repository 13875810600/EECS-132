import java.lang.StringBuilder;

/**
 * Programming Project 4
 * <p>
 * a stream of strings in lexicographical order
 * 
 * @author Sarah Whelan
 */

public class StringStream extends Stream<String>{
  
  /**
   * 
   * constructor passes baseValue to the Stream constructor after removing all non english letters and setting them
   * all to lowercase letters
   * <p> 
   * this takes the inputted string converts it to lowercase and removes anything that isn't an english letter
   * I understand this is an unnecessary step and it also traverses through the string twice when it could have done
   * it in one traversal. I have left the loop through the string to the two 
   * seperate methods below becuase I would like this code to be resuable and I feel as seperate methods
   * they are more useful and if the requirments for the string inputed for the next method or for the 
   * StringStream as a whole may change in the future and it would be easier to change the behaviour with two 
   * seperate methods. 
   * <p>
   * Another option would just be to clean the string which would remove all of the uppercase values and non-letter
   * characters which would still leave the string with just lowercase which is the goal but I think in terms
   * of user excpectations making the uppercase letters lowercase is a more natural thing for the user to want.
   * 
   */
  public StringStream(String value){   
    super(clean(lowercase(value)));
  }
  
  
  /**
   * takes a string of english characters and returns it with characters in lowercase
   * 
   * @param s the string to change to lowercase letters
   */
  public static String lowercase(String s) {
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < s.length(); index = index + 1) {
      if (s.charAt(index) <= 'Z' && s.charAt(index) >= 'A') {
        builder.append((char)(s.charAt(index) + 'a' - 'A'));
      }
      else
        builder.append(s.charAt(index));
    }
    return builder.toString();
  }
  
  /**
   * takes a string of english characters and returns it with characters not lowercase letters removed 
   * 
   * @param s the string to remove all non-lowercase characters
   */
  public static String clean(String s) {
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < s.length(); index = index + 1) {
      if (s.charAt(index) <= 'z' && s.charAt(index) >='a') {
        builder.append((char)(s.charAt(index)));
      }
    }
    return builder.toString();
  }
  
  /**
   * the next string in the stream
   * 
   * @return the next String in lexicographical order
   */
  @Override
  public String next(){
    //StringBuilder for more efficent creation of strings
    StringBuilder builder = new StringBuilder();
    
    //boolean for checking if the letter to the left is changed back to a and the current letter needs to be changed
    boolean previousChanged = false;
    
    //loop that iterators through each character of the string
    for(int i = value.length()-1; i >= 0; i--){
      
      /* checks if letter is the last letter or the previous 
       * (charatcer to the right) has changed and this needs to be changed and changes it
       */
      if(i == value.length()-1 || previousChanged){
        if(value.charAt(i) == 'z' || value.charAt(i) == 'Z'){
          builder.append('a');
          previousChanged = true;
          if(i == 0){
            builder.append('a');
          }
        } else {
          builder.append((char)(value.charAt(i)+1));
          previousChanged = false;
        }
      } else {
        builder.append(value.charAt(i));
      }
    }
    
    //if the loop didn't run at all becuase the value was an empty string set the value to "a" (the next string)
    if(value.equals("")){
      builder.append('a');
    }
    value = builder.reverse().toString();
    return value;
  }
}