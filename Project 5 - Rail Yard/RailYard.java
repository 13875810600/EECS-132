import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Rail Yard class represents a rail yard with classification yards to sort incomming trains.
 * 
 * @author Sarah Whelan
 */

public class RailYard<T extends Comparable<? super T>> {
  
  /**
   * an ArrayList of the CollectionYards in the railyard
   */
  private ArrayList<CollectionYard<T>> collectionYards;
  
  /**
   * Constructor creates an ArrayList of CollectionYards and stores it in collectionYards
   * 
   * @param yards an array of ints thaat for each integer indicates a collection yard with int number of tracks
   */
  public RailYard(int[] yards){
    if(yards.length == 0){
      System.out.println("Rail Yard must have at least one collection Yard. Rail Yard was not created.");
    } else {
      collectionYards = new ArrayList<CollectionYard<T>>(yards.length);
      for(int i = 0; i < yards.length; i++){
        if(yards[i] == 0){
          System.out.println("Collection Yard must have at least one track. Collection Yard was not created.");
        } else {
          collectionYards.add(new CollectionYard<T>(yards[i]));
        }
      }
    }
  }
  
  /**
   * Takes an incomming train as an array and cycle sorts it by placing each car on a track of the classification yard.
   * 
   * Uses the cylce sort methos where the first car is on the first track then next car if larger goes on same 
   * track otherwise goes on next track.
   * 
   * @param train (an ArrayList) to be sorted
   */
  
  public void cycleSort(T[] train){
    for(CollectionYard<T> yard : collectionYards){
      yard.cycleSort(train);
    }
  }
  
  /**
   * Takes an incoming train as a LinkedList of type T and sorts it using the cycle sort algorithm
   * 
   * @param train (a LinkedList) to be sorted
   */
  
  public void cycleSort(LinkedList<T> train){
    for(CollectionYard<T> yard : collectionYards){
      yard.cycleSort(train);
    }
  }
  
  /**
   * Takes an incomming train as an array and cloesest sorts it by placing each car on a track of the classification yard.
   * 
   * @param train (an ArrayList) to be sorted
   */
  
  public void closestSort(T[] train){
    for(CollectionYard<T> yard : collectionYards){
      yard.closestSort(train);
    }
  }
  
  /**
   * Takes an incoming train as a LinkedList of type T and sorts it using the closest sort algorithm
   * 
   * @param train (a LinkedList) to be sorted
   */
  public void closestSort(LinkedList<T> train){
    for(CollectionYard<T> yard : collectionYards){
      yard.closestSort(train);
    }
  }
}