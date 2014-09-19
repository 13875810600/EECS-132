/* Policy Holder Class for Porgramming Project 1
 * Sarah Whelan slw96
 * */

public class PolicyHolder{
  //fields
  private String firstName = "";
  private String lastName = "";
  private String address = "";
  private InsurancePolicy policy;
  private Date date;
  
  //contructors
  //a constructor with the necessities
  public PolicyHolder(String firstName, String lastName, String address){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }
  
  //a constructor with more options
  public PolicyHolder(String firstName, String lastName, String address, InsurancePolicy policy, Date date){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.policy = policy;
    this.date = date;
  }
  
  //methods
  
  //returns the first name of the policy holder
  public String getFirstName(){
    return firstName;
  }
  
  //sets the first name of the policy holder
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
  
  //returns the last name of the policy holder
  public String getLastName(){
    return lastName;
  }
  
  //sets the last name of the policy holder
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  
  //returns the address of the policy holder
  public String getAddress(){
    return address;
  }
  
  //sets the address of the policy holder
  public void setAddress(String address){
    this.address = address;
  }
  
  //returns the Insurance Policy associated with the policy holder
  public InsurancePolicy getPolicy(){
    return policy;
  }
  
  //sets the Insurance Policy associated with the policy holder
  public void setInsurancePolicy(InsurancePolicy policy){
    this.policy = policy;
  }
  
  //returns the date instance associated with the policy holder
  public Date getDate(){
    return date;
  }
  
  //sets the date instance associated with the policy holder
  public void setDate(Date date){
    this.date = date;
  }
  
  //increase the date associated with the policy holder by one day
  public void incrementDate(){
    getDate().incrementDay();
    getInsurancePolicy().processDate(getDate());
  }
}