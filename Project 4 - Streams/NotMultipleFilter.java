/**
 * Programming Project 4
 * <p>
 * a filter that only passes things that are not a multiple of the basevalue of the filter a subclass of filter
 * 
 * @author Sarah Whelan
 */

public class NotMultipleFilter extends Filter<Integer>{
  
  /**
   * constructor that passes value to the Filter class and sets the baseValue also sets the upstream filter
   * 
   * @param baseValue the baseValue of the filter
   * @param upstreamFilter a filter that will filter data before this new filter
   */
  public NotMultipleFilter(int baseValue, Filter<Integer> upstreamFilter){
    super(baseValue, upstreamFilter);
  }
  
  /**
   * Pass Filter method returns try if a given value is not a multiple of the base value of the filter
   * returns false if the balue is a multiple of the base value. 
   * <p>
   * If the baseValue of the filter is 0 the filter will always return true because nothing is a multiple of zero.
   * If the value to be checked is 0 the filter will always return true becauuse 0 is not a multiple of anything.
   * 
   * @param value the value to test against the base value
   * @return true if the value is not a multiple of the baseValue
   *         returns false if the value is a multiple of the baseValue
   */
  public boolean passFilter(Integer value){
    //if the value is 0 always return true becuase zero is not a multiple of anything
    if(value == 0){
      return true;
    }
    
    //a local variable to keep track of the result of the upstream filter
    boolean passedUpStream = true;
    
    //only calls a method on the upstream filter if the upstream filter exists
    if(upstreamFilter != null){
      passedUpStream = upstreamFilter.passFilter(value);
    }
    
    try{
      //could throw the division by zero error if the baseValue of the filter is zero
      return (passedUpStream && (value % baseValue != 0));
    }
    
    //catches the divison by zero error and returns true because nothing is a multiple of zero
    catch(ArithmeticException e){
      return true;
    }
  }
}