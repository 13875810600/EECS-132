/**
 * Programming Project 4
 * <p>
 * a stream that only returns values that are not multiples of a base value extends IntegerStream
 * 
 * @author Sarah Whelan
 */

public class NotMultipleStream extends IntegerStream {
  /**
   * declares filter to get rid of the multiples of the base value
   */
  protected NotMultipleFilter filter;
  
  /**
   * creates the stream's initial value and creates filter and sets the base value
   * 
   * @param baseValue the baseValue of the filter - filter out all numbers that are multiples of this number
   * @param initialValue the initialValue of the IntegerStream where the stream of numbers starts
   */
  public NotMultipleStream(Integer baseValue, Integer initialValue){
    super(initialValue);
    this.filter = new NotMultipleFilter(baseValue, null);
  }
  /**
   * returns the next integer that isn't a multiple of the base value by checking each
   * value against the filter and recursively calling this method until a valid value is found
   * 
   * @return the next value in the stream that is not a multiple of the baseValue
   */
  @Override
  public Integer next(){
    int next = super.next();
    if(filter.passFilter(next))
      return next;
    else
      return this.next();
  }
}