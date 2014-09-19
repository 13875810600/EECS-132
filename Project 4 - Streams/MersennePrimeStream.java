/**
 * Programming Project 4
 * <p>
 * a stream of mersenneprimes (primes that are 2 to some power minus 1) extends Prime Stream
 * uses Prime stream to go through list of primes checks if it is a MersennPrime
 * 
 * @author Sarah Whelan
 */

public class MersennePrimeStream extends PrimeStream{
  
  /**
   * Overridden next method
   * 
   * @return the next value in the prime stream that is a mersenne prime
   */
  @Override
  public Integer next(){
    Integer value = super.next();
    if(((value + 1) & (value)) == 0){ //this checks binary to verify that the number about the prime is a power of 2
      return value;
    } else {
      return this.next();
    }
  }
}