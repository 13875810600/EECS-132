/**
 * Programming Project 4
 * <p>
 * Abstract parent class Stream with generic type T. This class will serve as the parent class for Streams.
 * 
 * @author Sarah Whelan
 */

public abstract class Stream<T>{
  /**
   * protected initial value to allow subclasses access is the initial vlaue of stream
   */
  protected T value;
  
  /**
   * constructor sets initial value
   * 
   * @param value the initial value of the stream
   */
  public Stream(T value){
    this.value = value;
  }
  
  /**
   * returns the next type T element in the stream must be overriden in subclasses
   * 
   * @return the next value in the stream of generic type T designated by subclass
   */
  public abstract T next();
}