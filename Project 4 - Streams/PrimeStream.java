/**
 * Programming Project 4
 * <p>
 * an Integer Stream that returns only prime numbers
 * 
 * @author Sarah Whelan
 */

public class PrimeStream extends NotMultipleStream{
  /**
   * creates a NotMultipleStream with a basevalue of 0 meaning all values pass NotMultipleFilter 
   * and an intial value of 1 
   */
  public PrimeStream(){
    super(0, 1);
  }
  
  /**
   * This method gets the next value of the stream and makes this value the new basevalue for a new filter and
   * moves the old filter to the upstream filter of the new filter creating many filters that when used in this way
   * produce a stream of prime numbers
   * 
   * @return the next prime number
   */
  @Override
  public Integer next(){
    value = super.next();
    filter = new NotMultipleFilter(value, this.filter);
    return value;
  }
}