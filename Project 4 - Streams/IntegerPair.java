/**
 * Programming Project 4
 * <p>
 * a pair of integers that containes two integers that can be represented in String format/coordinate format
 * 
 * @author Sarah Whelan
 */

public class IntegerPair {
  /**
   * the first value of the pair
   */
  protected Integer value1;
  /**
   * the second value of the pair
   */
  protected Integer value2;
  
  /**
   * constructor sets both values of pair
   * 
   * @param value1 the first value of the pair
   * @param value2 the second value of the pair
   */
  public IntegerPair(Integer value1, Integer value2){
    this.value1 = value1;
    this.value2 = value2;
  }
  
  /**
   * getter method for the first value
   * 
   * @return the first value
   */
  public Integer getValue1(){
    return value1;
  }
  
  /**
   * getter method for the first value
   * 
   * @return the second value
   */
  public Integer getValue2(){
    return value2;
  }
  
  /**
   * Converts the pair into a convienent string format ex: "(1,2)"
   * 
   * @return the pair in string form
   */
  public String toString(){
    return "("+value1+","+value2+")";
  }
}
