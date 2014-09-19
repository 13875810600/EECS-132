/**
 * Programming Project 4
 * <p>
 * a class of streamUtilities with static methods
 * 
 * @author Sarah Whelan
 */

public class StreamUtilities {
  
  /**
   * prints the firxt x Integers of given stream
   * 
   * @param stream the stream to use as values to print
   * @param x the number of times to print a vlaue from the stream
   */
  public static void print(Stream<Integer> stream, Integer x){
    for(int i = 0; i < x; i++){
      System.out.println(stream.next());
    }
  }
  
  /**
   * sums the first x Integers of given stream
   * 
   * @param stream the stream of values to add
   * @param x the number of values to be added/summed
   */
  public static Integer sum(Stream<Integer> stream, Integer x){
    Integer sum = 0;
    for(int i = 0; i < x; i++){
      sum = sum + stream.next();
    }
    return sum;
  }
  
  /**
   * multiplies the first x Integers of given stream
   * 
   * @param stream the stream of values to multiply
   * @param x the number of values to be multiplied
   */
  public static Integer product(Stream<Integer> stream, Integer x){
    Integer product = 1;
    if(x == 0){
      return 0;
    } else{
      for(int i = 0; i < x; i++){
        product = product * stream.next();
      }
    }
    return product;
  }
  
  /**
   * concatenate the first x Strings of given stream
   * 
   * @param stream the stream of Strings to add
   * @param x the number of Strings to be concatenated
   */
  public static String concatenate(Stream<String> stream, Integer x){
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < x; i++){
      builder.append(stream.next());
    }
    return builder.toString();
  }
}