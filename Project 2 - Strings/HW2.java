/* 
 * Homework 2
 * 
 * Sarah Whelan (slw96)
 *  
 * This class will provide static methods that traverse and modify strings. 
 * 
 */

public class HW2 {
    
  /*
   * Given two characters, an int(k), and a String, this method replaces the first character with the second character
   * every kth time the first character occurs within the string
   * 
   * charOne - character to be replaced
   * charTwo - character to replace charOne
   * k - int for which occurrences of charOne to replace
   * string - string to be modified
   * 
   */
  
  public static String replaceKth(char charOne, char charTwo, int k, String string){
    //a stringBuilder to use throughout the loop and later return
    StringBuilder builder = new StringBuilder();
    //count keeps track of how many times the first character occurs
    int count = 0;
    int i = 0;
    
    /* 
     * Counts number of times the first character has appeared and if that count equals k replaces the first
     * character with the second character every kth time
     * this loop only requires that the string is not null
     * 
     */
    
    while(i < string.length()){
      if(string.charAt(i) == charOne){
        count = count + 1;
      }
      if(count == k && k > 0){
          builder.append(charTwo);
          count = 0;
      } else{
      builder.append(string.charAt(i));  
      }
      i = i + 1;
    }
    return builder.toString();
  }
  
  /*
   * Given two strings combines the two strings alternating from each until both strings have been fully used
   * 
   */
  
  public static String interleave(String s1, String s2){
    //iterator for total length of both string
    int i = 0;
    //iterator for first string
    int j = 0;
    //iterator for second string
    int k = 0;
    //a stringBuilder to use throughout the loop and later return
    StringBuilder builder = new StringBuilder();
    
    /* 
     * after each iteration we should have printed two characters one from each string until one string runs out of
     * characters in which case we only print from the other string
     * 
     * this loop only requires that the strings are not null
     */
    
    while(i < (s1.length() + s2.length())){
      if(j < s1.length()){
        builder.append(s1.charAt(j));
        i++;
        j++;
      }
      if(k < s2.length()){
        builder.append(s2.charAt(k));
        i++;
        k++;
      }
    }
    return builder.toString();
  }
  
  /*
   * blankWords when given a string will replace every character that is not the first or last
   * letter of a word (consecutive letters) with an underscore
   */
  
  public static String blankWords(String s){
    //keep track of if wee are within a word at any given value of i and determines whether or not to replace a letter
    boolean withinWord = false;
    //a stringBuilder to use throughout the loop and later return
    StringBuilder builder = new StringBuilder();
    int i = 0;
    
    /*
     * First checks if the index we are currently at by checking if the surrounding characters are letters
     * these checks keep track of the boolean withinWord and then if we are withinWord it replaces the letter with an
     * underscore and if we are not withinWord just leaves that letter as it is
     * 
     * this loop only requires that the string is not null
     */
    
    while(i < s.length()){
      /*
       * First checks if we are within a word - if two characters before the current character isn't a letter
       * we are within a word
       */
      if(!withinWord && i > 0 && 
           (i == 1 || ((s.charAt(i-2) < 'A' || s.charAt(i-2) > 'Z') && ( s.charAt(i-2) < 'a' || s.charAt(i-2) > 'z')))
           && s.charAt(i) != ' '){
        withinWord = true;
        
      /*
       * If index is currently within a word checks if the next character isn't a letter (for things like hyphens) or
       * if the word ends and sets withinWord to false 
       */ 
      } if(withinWord && 
           (i == s.length()-1 || 
           ((s.charAt(i+1) < 'A' || s.charAt(i+1) > 'Z') && ( s.charAt(i+1) < 'a' || s.charAt(i+1) > 'z'))
           || ((s.charAt(i-1) < 'A' || s.charAt(i-1) > 'Z') && ( s.charAt(i-1) < 'a' || s.charAt(i-1) > 'z')))){
        withinWord = false;
      }
      
      if(withinWord){
        if(((s.charAt(i) < 'A' || s.charAt(i) > 'Z') && ( s.charAt(i) < 'a' || s.charAt(i) > 'z'))){
          builder.append(s.charAt(i));
          i = i +1;
        } else {
          builder.append('_');
          i = i +1;
        }
      } else {
        builder.append(s.charAt(i));
        i = i + 1;
      }
    }
    return builder.toString();
  }
  
  /*
   * Given a string (not null) and an int (n) returns every nth word (word here is defined as anything separated by
   * spaces)
   * 
   */
  
  public static String nthWord(int n, String s){
    if(n == 0){
      return "";
    }
    //counts the number of spaces to determine if the word we are on is an nth word
    int count = 1;
    int i = 1;
    //a stringBuilder to use throughout the loop and later return
    StringBuilder builder = new StringBuilder();
    
    /*
     * Counts each word by counting the spaces and if this word is the an nth word append that word
     * 
     * after each iteration we will have appended a letter if it is within a nth word or skipped it if it is not
     * this loop only requires that the string is not null
     */ 
    
    while(i <= s.length()){
      if(s.charAt(i-1) == ' '){
        count = count + 1;
      }
      if(count % n == 0 && count != 0){
        //this if (below) is to not append the space before the first word
        if(s.charAt(i-1) != ' ' || builder.length() > 0)
          builder.append(s.charAt(i-1));
      }
      i = i + 1;
    }    
    return builder.toString();
  }
  
  /*
   * truncateAfter - truncates a string (only at hyphens or spaces) after the desired length (not including hyphens or
   * spaces) has been reached
   * 
   */

  public static String truncateAfter(int n, String s){
    int i = 0;
    /*count is the number of letters that will go in the final sting to help determin where we can begin to think
    * about truncating
    */
    int count = 0;
    //index is the index of where we can safely truncate (space or hypen)
    int index = 0;
    //a stringBuilder to use throughout the loop and later return
    StringBuilder builder = new StringBuilder();
    if(n == 0){
      return "";
    }
      /*
       * This first loop checks for where we can safely stop/struncate our string (only at
       * hypens and spaces) and this index is saved in index
       * 
       * this loop only requires that the string is not null
       */
    
    while(i < s.length()-1 || count > n){
      if((s.charAt(i) != ' ' && s.charAt(i) != '-') && count < n){
        count = count + 1;
      } 
      
      if(count == n - 1){
        if(s.charAt(i) == '-' && index == 0){
          index = i;
        }
      }else {
        if(count == n){
          if((s.charAt(i) == '-' || s.charAt(i) == ' ') && index == 0){
            index = i;
          }
        }
      }
      i = i + 1;
    }
      
    /* 
     * if we didn't save a value to index i.e. n was more than the string length of available characters return whole
     * string without hyphens
     */
    
    if(index == 0){
      int k = 0;
      while(k<s.length()){
        if(s.charAt(k) != '-'){
          builder.append(s.charAt(k));
        }
        k = k +1;
      }
    } else {       
      /*
       * if we did find a place to truncate within the string return all the non hyphen and non space characters
       * up to that point
       */
      int j = 0;
      while(j < index){
        if(s.charAt(j) != '-'){
          builder.append(s.charAt(j));
        }
        j = j +1;
        if(j == index){
          if(s.charAt(j) == '-'){
            builder.append(s.charAt(j));
          }
        }
      }
    }
    return builder.toString();
  }

  /*
   * Extra Credit Method
   * 
   * Works the Same as truncate After except finds cuttoff point then reduces the index until the last hyphen or
   * space before the cut off and then prints out the same as truncateAfter
   * 
   */ 
  
  public static String truncateBefore(int n, String s){
    //a StringBuilder to use in the loop and to return later
    StringBuilder builder = new StringBuilder();
    //index of the place where we have the maximum number of letters
    int index = 0;
    int count = 0;
    int i = 0;
    if(n == 0){
      return "";
    }
    
    /*
     * Goes through string until we reach maximum number of letters and saves the index in index
     * requires that the string is not null
     * 
     */ 
    
      while(i < s.length() && count <= n){
        if(s.charAt(i) != ' ' && s.charAt(i) != '-'){          
          count = count + 1;
        }       
        if(count == n){
            index = i;
        }
        i = i + 1;
      }
      
        /*
         * if we did find a place to truncate within the string return all the non hyphen and non space characters
         * up to that point
         * 
         */
      
      if(index == 0){
        int k = 0;
        while(k<s.length()){
          if(s.charAt(k) != '-'){
            builder.append(s.charAt(k));
          }
          k = k +1;
        }
      } else {
        
        /*
         * reduce the index until we reach the last hyphen or space before our maximum number of letters
         */
        
        for(; s.charAt(index) != ' ' && s.charAt(index) != '-'; index--){
          ;
        }
                
        /*
         * print out all non hyphens before the cut off
         */ 
        
        int j = 0;
        while(j<index){
          if(s.charAt(j) != '-'){
            builder.append(s.charAt(j));
          }
          j = j + 1;
          if(j == index){
            if(s.charAt(j) == '-'){
              builder.append(s.charAt(j));
            }
          }
        }
      }
    return builder.toString();
  }
}
