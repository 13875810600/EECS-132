/**
 * Programming Project 4
 * <p>
 * Stream of Integers subclass of stream
 * 
 * @author Sarah Whelan
 */
public class IntegerStream extends Stream<Integer>{
  
  /** 
   * constructor simply passes the initial value of the IntegerStream to Stream's constructor
   * 
   * @param first the first value of the string
   */
  public IntegerStream(Integer first){
    super(first);
  }
   
  /** 
   * overriden abstract next method increments (by one) and returns the new value of the stream
   * 
   * @return value of the next Integer in the stream
   */
  @Override
  public Integer next(){
    value = value + 1;
    return value;
  }
}
  