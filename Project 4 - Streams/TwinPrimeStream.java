/**
 * Programming Project 4
 * <p>
 * This Twin Prime Stream is both a stream and an Integer pair - ideally it would be both however
 * Java is not structured as to allow this. 
 * <p>
 * If TwinPrimeStream extended Stream the next method of the prime stream could not be
 * overriden becuase TwinPrimeStream needs to return an IntegerPair and PrimeStream's next method only returns
 * Integer. 
 * <p>
 * If TwinPrimeStream extended Integer Pair the constructor of TwinPrimeStream (ie Taking no inputs) would not be a
 * valid constructor for Integer Pair.
 * <p>
 * I was not sure how to get around this so I left this class simply on its own and used both an IntegerPair and
 * a PrimeStream as fields in the class.
 * <p>
 * This class is an stream of integer pairs of prime numbers 
 * (primes that are two whole numbers apart from one another)
 * 
 * @author Sarah Whelan
 */

public class TwinPrimeStream {
  /**
   * the stream of prime numbers to pull from
   */
  private PrimeStream stream = new PrimeStream();
  
  /**
   * an integer pair object to store the pairs of primts
   */
  private IntegerPair pair;
  
  /**
   * the values of the integer pair are here becuase there is not setValue1 or setValue2 method in Integer Pair
   * and with every change in the stream/every next call I only want to set the pair of integer values to be the 
   * next to primes if they are two whole numbers apart
   */
  
  /**
   * the first value of the pair
   */
  private Integer value;
  
  /**
   * the second value of the pair
   */
  private Integer value2;
  
  /**
   * constructor takes no input and sets values for the fields value and value2 the pair is not used until
   * the next method is called
   */
  public TwinPrimeStream(){
    value = 0;
    value2 = stream.next();
  }
  
  /**
   * gets the next prime values that are two numbers away from each other
   * 
   * @return an Integer Pair of primes that are two whole numbers apart
   */
  public IntegerPair next(){
    value = value2;
    value2 = stream.next();
    if(value2 - value == 2){
      pair = new IntegerPair(value, value2);
      return pair;
    } else {
      return this.next();
    }
  }
}