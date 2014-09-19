/**
 * Programming Project 4
 * <p>
 * Filter is a parent class for filters using a generic type to allow for multiple types of filters
 * 
 * @author Sarah Whelan
 */
public abstract class Filter<E>{
  /**
   * the value that is used to check against in Integer filters
   */
  protected E baseValue;
  
  /**
   * a filter can have an upstream filter that also filters data before the current filter filters data
   */
  protected Filter<E> upstreamFilter;
  
  /**
   * a constructor that sets the base value and upstreamFilter
   * 
   * @param baseValue the value that the filter is set to either allow or block/check against
   */
  public Filter(E baseValue, Filter<E> upstreamFilter){
    this.baseValue = baseValue;
    this.upstreamFilter = upstreamFilter;
  }
  /**
   * a passFilter test that all filters must override
   * 
   * @param value the value to test against the filter's settings
   */
  public abstract boolean passFilter(E value);
}