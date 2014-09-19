/* Date Class for Programming Project 1
 * Sarah Whelan slw96
 * */

public class Date{
  //fields
  private int day = 1;
  private int month = 1;
  private int year = 1;
  
  //constructor takes day month and year expects these int values to be within the proper ranges to create a date
  public Date(int day, int month, int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  //methods
  
  //returns the day of the date
  public int getDay(){
    return day;
  }
  
  //returns the month of the date
  public int getMonth(){
    return month;
  }
  
  //returns the year of the date
  public int getYear(){
    return year;
  }
  
  //returns if a year is a leap year 
  //this is determined by the fact that a leap year is divisible by 4 but not 100 unless it is also divisible by 400
  public boolean isLeapYear(){
    if(getYear() % 4 == 0){
      if(getYear() % 100 == 0){
        if(getYear() % 400 ==0){
          return true;
        } else{
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  //this moves the date forward one day in time by checking to see if the month and/or year must also be incremented
  public void incrementDay(){
    if(month == 12 && day + 1 > 31){
      year += 1;
      month = 1;
      day = 1;
    } else if(month == 4 || month == 6 || month == 9 || month == 11){
      if(day + 1 > 30){
        month += 1;
        day = 1;
      } else {
        day += 1;
      }
    }else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
      if(day + 1 >31){
        month += 1;
        day = 1;
      }else {
        day += 1;
      }
    } else if(month == 2){
      if(this.isLeapYear()){
        if(day + 1 >29){
          month += 1;
          day = 1;
        } else{
          day += 1;
        }
      } else {
        if(day + 1 >28){
          month += 1;
          day = 1;
        } else{
          day += 1;
        }
      }
    }
  }
  
  //compares two dates returns 0 if they are they same, a positive value (1) if this date is later than the input date, and a negative value (-1) if this date is earlier than the input date
  public int compareTo(Date date){
    if(this.getYear() == date.getYear()){
      if(this.getMonth() == date.getMonth()){
        if(this.getDay() == date.getDay()){
          return 0;
        } if (this.getDay() > date.getDay()){
          return 1;
        }
      }else if(this.getMonth() > date.getMonth()){
        return 1;
      }
    }else if(this.getYear() > date.getYear()){
      return 1;
    } 
     return -1;    
  }
}
             