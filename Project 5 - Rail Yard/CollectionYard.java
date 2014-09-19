import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The CollectionYard class represents an ArrayList of LinkedLists of Type T.
 * Each linked list is a track in the collection yard upon which trains can be sorted.
 * 
 * @author Sarah Whelan
 */

public class CollectionYard<T extends Comparable<? super T>> {
  
  /**
   * tracks - the ArrayList of LinkedLists
   */
  private ArrayList<LinkedList<T>> tracks;
  
  /**
   * constructor takes an int of the number of tracks in the collectionYard and creates a LinkedList
   * in the ArrayList for each track
   * 
   * @param numTracks the number of tracks in the colleciton yard
   */
  public CollectionYard(int numTracks){
    //sets the size of the ArrayList to be the number of tracks given to avoid the array list class' automatic resizing
    tracks = new ArrayList<LinkedList<T>>(numTracks);
    for(int i = 0; i < numTracks; i++){
      tracks.add(new LinkedList<T>());
    }
  }
  
  /**
   * cycle sorts the train by placing cars in order on a track until a car of the train is smaller or the yard is out
   * of tracks.
   * 
   * @param train the array of type T to reprsent the train to be sorted
   */
  public void cycleSort(T[] train){
    int length = train.length;
    LinkedList<T> listToSort = new LinkedList<T>();
    for(T car : train){
      listToSort.add(car);
    }
    this.cycleSort(listToSort);
    Iterator<T> pointer = listToSort.iterator();
    for(int i = 0; i<length; i++){
      if(pointer.hasNext()){
        train[i] = pointer.next();
      }
    }
  }
  
  /**
   * cycle sorts the train by placing cars in order on a track until a car of the train is smaller or the yard is out
   * of tracks.
   * 
   * @param train the train in a LinkedList of comparable type T to be sorted
   */
  public void cycleSort(LinkedList<T> train){
    //pointer to iterate through the tracks
    Iterator<LinkedList<T>> pointer = tracks.iterator();
    
    //the track upom which to place the train car
    LinkedList<T> track = null;
    
    //boolean flag to move to the next track
    boolean shouldMove = true;
    
    //for-each car in the train add the car to the appropriate linkedlist
    for(T car : train){
      //boolean flag to stop the while loop
      boolean carPlaced = false;
      //while the car isn't placed go through the tracks of the yard and check where to put the car
      while(!carPlaced){
        //move the pointer forward if the car is smaller than what is already on the current track
        if(pointer.hasNext() && shouldMove){
          track = pointer.next();
          shouldMove = false;
        } 
        //if the current track is empty add the car
        if(track.isEmpty()){
          track.addLast(car);
          carPlaced = true;
        } else {
          //determines if the current track is less than the car and if not moves to the next track
          if(track.getLast().compareTo(car) <= 0){
            track.addLast(car);
            carPlaced = true;
          } else if(track.getLast().compareTo(car) > 0) {
            shouldMove = true;
          }
        }
        //resets pointer if out of tracks
        if(!pointer.hasNext()) {
          pointer = tracks.iterator();
          if(pointer.hasNext()){  
            track = pointer.next();
            carPlaced = true;
          }
        }
      }
    }
    //calls the merge method which takes the tracks of the collectionYard and pulls from them the train cars
    this.merge(train);
  }
  
    
  /**
   * Closest Sorts the train by placing the current car on the next open track or on a lower number that is closest
   * to the value of the current car
   * 
   * @param train an array to represent the train to be sorted
   */
  public void closestSort(T[] train){
    int length = train.length;
    LinkedList<T> listToSort = new LinkedList<T>();
    for(T car : train){
      listToSort.add(car);
    }
    this.closestSort(listToSort);
    Iterator<T> pointer = listToSort.iterator();
    for(int i = 0; i<length; i++){
      if(pointer.hasNext()){
        train[i] = pointer.next();
      }
    }
  } 
  
  /**
   * Closest Sorts the train by placing the current car on the next open track or on a lower number that is closest
   * to the value of the current car
   * 
   * @param train a Linekd List to represent the train to be sorted
   */
  public void closestSort(LinkedList<T> train){
    for(T car : train){
      //iterator for tracks in yard
      Iterator<LinkedList<T>> pointer = tracks.iterator();
      
      /*
       * if all tracks are full and not lower than the current car place car on lowest track
       */
      LinkedList<T> lowest = null;
      
      //track upon which the current car should be placed
      LinkedList<T> trackToPlace = null;
      
      /*
       * if there is more than one car in the tracks that is lower than the current car helps
       * find the closest to the current car
       */
      LinkedList<T> closest = null;
      
      //boolean flag to stop loop
      boolean carPlaced = false;
      
      //go through the tracks of the yard and check where to put the car
      while(pointer.hasNext() && !carPlaced){
        
        //the track that is being checked currently
        LinkedList<T> track = pointer.next();
        
        //if the track is empty place the car there
        if(track.isEmpty()){
          trackToPlace = track;
          carPlaced = true;
        } else {
          if(lowest == null){
            lowest = track;
          } else if(lowest.getLast().compareTo(track.getLast()) > 0){
            lowest = track;
          }
          //if the track is not empty determine if it is the closest to the current car to be placed
          if(track.getLast().compareTo(car) <= 0){
            if(closest == null){
              closest = track;
            }
            if(closest.getLast().compareTo(track.getLast()) < 0){
              trackToPlace = track;
              closest = track;
            } else {
              trackToPlace = closest; 
            }
          }
        }
      }
      //place the car
      if(trackToPlace != null){
        trackToPlace.add(car);
      } else {
        lowest.add(car);
      }
    }
    //merge the train back from all of the tracks
    this.merge(train);
  }
  
  /**
   * merge takes the tracks of the collection yard that have train cars on them and takes the lowest car from
   * the the front of the tracks to get a train ordered lowest to highest
   * 
   * @param train the array of train cars to order
   */
  public void merge(LinkedList<T> train){
    //a second train that is used to store the sorted train while the first train is iteratorated through
    LinkedList<T> train2 = new LinkedList<T>();
    for(T car : train){
      
      //LinkedList of the track with the lowest car on the front
      LinkedList<T> lowest = null;
      
      //iterator to go through the tracks of the yard
      Iterator<LinkedList<T>> pointer = tracks.iterator();
      
      //go through the tracks of the yard and check where to put the car
      while(pointer.hasNext()){
        
        //the first track to compare against that changes and determines the lowest
        LinkedList<T> toCompare = pointer.next();
        if(!toCompare.isEmpty()){
          if(lowest == null && toCompare != null){
            lowest = toCompare;
          }
          try{
            if(toCompare.getFirst().compareTo(lowest.getFirst()) <= 0){
              lowest = toCompare;
            }
          }
          catch(Exception e){
          }
        }
      }
      //add train to the array the first car sfrom the track that is the lowest
      try{
        train2.addLast(lowest.removeFirst());
      }
      catch(NullPointerException e){
      }
    }
    
    //to sort the initial train variable
    train.clear();
    for(T car : train2){
      train.add(car);
    }
  }
}