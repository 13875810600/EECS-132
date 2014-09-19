/* Insurance Policy Class Programming Project 1
 * Sarah Whelan slw96
 * */

public class InsurancePolicy {
  
  // fields
  private String policyNumber = "";
  private double copay = 0.0;
  private double deductible = 0.0;
  private double amountApplied = 0.0;
  private double actuarialValue = 0.0;
  private boolean hasAnnualLimit = false;
  private double annualLimit = 0.0;
  private boolean hasOutOfPocketLimit = false;
  private double outOfPocketLimit = 0.0;
  private double outOfPocketCost = 0.0;
  private double yearlyOutOfPocketCost = 0.0;
  private boolean hasLifetimeLimit = false;
  private double lifetimeLimit = 0.0;
  private double profitMargin = 0.0;
  private double expectedTenYearBenefit = 0.0;
  private double yearlyBenefit = 0.0;
  private double lifetimeBenefit = 0.0;
  private boolean hasSupplementalInsurance = false;
  private InsurancePolicy supplementalInsurance = null;
  private Date expirationDate = null;
  private double premium = 0.0;
  
  //constructors
  
  //a constructor that takes and sets only the most necessary fields
  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                         double actuarialValue){
    this.policyNumber = policyNumber;
    this.expirationDate = expirationDate;
    this.copay = copay;
    this.deductible = deductible;
    this.actuarialValue = actuarialValue;
  }
  
  //a constructor with more options
  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                         double actuarialValue, boolean hasAnnualLimit, double annualLimit, 
                         boolean hasOutOfPocketLimit, double outOfPocketLimit, boolean hasLifetimeLimit, 
                         double lifetimeLimit, double expectedTenYearBenefit, double profitMargin, 
                         InsurancePolicy supplementalInsurance){
    this(policyNumber, expirationDate, copay, deductible, actuarialValue);
    this.hasAnnualLimit = hasAnnualLimit;
    this.annualLimit = annualLimit;
    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
    this.outOfPocketLimit = outOfPocketLimit;
    this.hasLifetimeLimit = hasLifetimeLimit;
    this.lifetimeLimit = lifetimeLimit;
    this.expectedTenYearBenefit = expectedTenYearBenefit;
    this.profitMargin = profitMargin;
    if(supplementalInsurance != null){
      this.hasSupplementalInsurance = true;
    }
    this.supplementalInsurance = supplementalInsurance;
  } 
  
  //methods
  
  /*getter and setter methods*/
  //gets Policy Number
  public String getPolicyNumber(){
    return policyNumber;
  }
  
  //sets copay
  public void setCopay(double copay){
    this.copay = copay;
  }
  
  //gets copay
  public double getCopay(){
    return copay;
  }
  
  //sets deductible
  public void setDeductible(double deductible){
    this.deductible = deductible;
  }
  
  //gets deductible
  public double getDeductible(){
    return deductible;
  }
  
  //returns the amount applied to the deductible so far this year
  public double getAmountAppliedToDeductible(){
   return amountApplied;
  }
  
  /*sets the actuarial value (the percentage of claims the policy will cover) should
   * be a decimal less than or equal to 1 assumed appropriately given
   */
  public void setActuarialValue(double actuarialValue){
    this.actuarialValue = actuarialValue;
  }
  
  //returns the actuarial value (the percentage of claims the policy will cover)
  public double getActuarialValue(){
    return actuarialValue;
  }
  
  //sets if the policy has an annual limit and if it does sets the annual limit
  public void setAnnualLimit(boolean hasAnnualLimit, double annualLimit){
    this.hasAnnualLimit = hasAnnualLimit;
    if(this.hasAnnualLimit){
      this.annualLimit = annualLimit;
    }
  }
  
  //boolean true if the policy has an annual limit associated 
  public boolean hasAnnualLimit(){
    return hasAnnualLimit;
  }
  
  //returns the annual limit if it has one or if there isn't an annual limit returns a non-positive number
  public double getAnnualLimit(){
    if(hasAnnualLimit && annualLimit > 0){
      return annualLimit;
    } else { 
      return -1;
    }
  }
  
  //sets both if the policy has an out of pocket limit and what that limit it
  public void setOutOfPocketLimit(boolean hasOutOfPocketLimit, double outOfPocketLimit){
    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
    if(this.hasOutOfPocketLimit){
      this.outOfPocketLimit = outOfPocketLimit;
    }
  }
  
  //returns if the policy has an out of pocket limit
  public boolean hasOutOfPocketLimit(){
    return hasOutOfPocketLimit;
  }
  
  /*if the policy has an out of pocket limit returns th elimit or if the policy does not have an out of 
  * pocket limit returns a non-positive value
  */
  public double getOutOfPocketLimit(){
    if(hasOutOfPocketLimit && outOfPocketLimit > 0){
      return outOfPocketLimit;
    } else {
      return -1;
    }
  }
  
  //sets both if the policy has a lifetime limit and what that limit would be if there was one
  public void setLifetimeLimit(boolean hasLifetimeLimit, double lifetimeLimit){
    this.hasLifetimeLimit = hasLifetimeLimit;
    if(hasLifetimeLimit){
      this.lifetimeLimit = lifetimeLimit;
    }
  }
  
  //returns whether or not the policy has a lifetime limit
  public boolean hasLifetimeLimit(){
    return hasLifetimeLimit;
  }
  
  /*if the policy has a lifetime limit this method returns the life time limit if there is one and 
   * if not it returns a non-positive number
   */
  public double getLifetimeLimit(){
    if(hasLifetimeLimit && lifetimeLimit > 0){
      return lifetimeLimit;
    } else {
      return -1;
    }
  }
  
  //sets the profit margin the goal is for the profit margin too equal (premium - amount paid)/amount paid
  public void setProfitMargin(double profitMargin){
    this.profitMargin = profitMargin;
  }
  
  //returns the profit margin
  public double getProfitMargin(){
    return profitMargin;
  }
  
  /*sets the expectedd ten year benefit (the amount the policy will pay out to the policy holder
   * in the next ten years) used to compute the premium
   */
  public void setExpectedTenYearBenefit(double expectedBenefit){
    this.expectedTenYearBenefit = expectedBenefit;
  }
  
  //returns the expected ten year benefit 
  public double getExpectedTenYearBenefit(){
    return expectedTenYearBenefit;
  }
  
  //returns the amount the policy has paid out this year so far
  public double getYearlyBenefit(){
    return yearlyBenefit;
  }
  
  //returns the amount the policy has paid out over the course of the entire policy
  public double getLifetimeBenefit(){
    return lifetimeBenefit;
  }
  
  /*adds a supplemental policy (also an InsurancePolicy) to the existing policy and indicates that the
   * existing policy has a supplemental insurance
   */
  public void setSupplementalInsurance(InsurancePolicy policy){
    hasSupplementalInsurance = true;
    supplementalInsurance = policy;
  }
  
  //returns the supplemental insurance if the policy has supplemental insurance
  public InsurancePolicy getSupplementalInsurance(){
    if (hasSupplementalInsurance){
      return supplementalInsurance;
    } else {
      return null;
    }
  }
  
  //returns when the policy expires
  public Date getExpirationDate(){
    return expirationDate;
  }
  
  //returns the amount the policy holder must pay to purchase the policy
  public double getPremium(){
    return premium;
  }
  
  
  /*helper methods for proccessing the claim*/
  
  //deducts the copay amount from the claim
  public double applyCopay(double claim){
    return claim -= copay;
  }
  
  /*subtracting the deductible from the claim but checks if the amount applied to the dedctable is less than
   * the total deductible and adjusts the claim and the amount applied accordingly
   */
public double applyDeductible(double claim){
  if(getAmountAppliedToDeductible() < getDeductible()){
    //claim must be reduced by the difference but not to less than 0
    if(claim - (getDeductible() - getAmountAppliedToDeductible())<0){
      amountApplied = claim;
      claim = 0;
    } else {
      claim = claim - (getDeductible() - getAmountAppliedToDeductible());
      amountApplied = getAmountAppliedToDeductible() + (getDeductible() - getAmountAppliedToDeductible());
    }
  }
  return claim;
}
  
  //applies the actuarial value (percentage of claims covered by policy) to the claim by multiplication
  public double applyActuarialValue(double claim){
    return claim * getActuarialValue();
  }
  
  //if the policy has supplemntal insurance process the claim in accordance to this policy and return that or return the inital claim
  public double applySupplementalInsurance(double claim){
    if(hasSupplementalInsurance){
      return getSupplementalInsurance().processClaim(claim);
    }else {
        return claim;
      }
  }
  
  //if the policy has an annual limit this checks if the claim exceeds what the policy is allowed to pay out in a year
  public double applyYearlyLimit(double claim){
    if(hasAnnualLimit()){
      if((claim + getYearlyBenefit()) > getAnnualLimit()){
        return claim - ((claim + getYearlyBenefit()) - getAnnualLimit());
      }
    }
      return claim;
  }
  
  //if the policy has a lifetime limit this checks to see if the claim exceeds it and returns the largest claim that can still be paid out
  public double applyLifetimeLimit(double claim){
    if(hasLifetimeLimit()){
      if(claim + getLifetimeBenefit() > getLifetimeLimit()){
        return claim - ((claim + getLifetimeBenefit()) - getLifetimeLimit());
      }else{
        return claim;
      }
    } else{
      return claim;
    }
  }
  
  /*Primary Claim Processing
   * 
   * submits a claim for processing by
   * taking the claim
   * subtracting the copay
   * subtracting the deductible
   * reducing by the actuarial value
   * checking if the claim exceeds the annual limit or the lifetime limit then deducting accordingly
   * the out of pocket cost for the policy holder is the initial claim minus the claim being paid out 
   * after the reductions
   * if the policy has supplemental insurance the claim is processed with that policy
   * after processing the out of pocket cost this checks if the out of pocket cost exceeds the limit on the 
   * 
   * out of pocket cost and lowers the out of pocket cost and increases the claim accordingly
   * the reduced claim is added to the yearly and liftime benefit
   * the out of pocket cost is added to the yearly out of pocket cost and the out of pocket cost is returned
   * 
   * */
  public double processClaim(double claim){
    double initialClaim = claim;
    claim = this.applyCopay(claim);
    claim = this.applyDeductible(claim);
    claim = this.applyActuarialValue(claim);
    claim = this.applyYearlyLimit(claim);
    claim = this.applyLifetimeLimit(claim);
    outOfPocketCost = initialClaim - claim;
    if(hasSupplementalInsurance){
      if(outOfPocketCost - this.applySupplementalInsurance(claim) < 0){
        outOfPocketCost = 0;
      } else{
        outOfPocketCost -= this.applySupplementalInsurance(claim);
      }
    }
    if(hasOutOfPocketLimit && ((outOfPocketCost + yearlyOutOfPocketCost) > outOfPocketLimit)){
      claim += ((outOfPocketCost + yearlyOutOfPocketCost) - outOfPocketLimit);
      outOfPocketCost -= ((outOfPocketCost + yearlyOutOfPocketCost) - outOfPocketLimit);
    }
    yearlyBenefit += claim;
    lifetimeBenefit += claim;
    yearlyOutOfPocketCost += outOfPocketCost;
    return outOfPocketCost;
  }
  
  /*the policy is renewed by setting the deuctable, yearly benefit, and the yearly out of pocket cost to zero 
   * and recalculating the expected ten year benefit
   */
  public void renewPolicy(){
    expectedTenYearBenefit = yearlyBenefit + (.9 * (expectedTenYearBenefit));
    amountApplied = 0.0;
    yearlyBenefit = 0.0;
    yearlyOutOfPocketCost = 0.0;
    expirationDate = new Date(expirationDate.getDay(), expirationDate.getMonth(), expirationDate.getYear() + 1);
  }
  
  //sets the premium to be the profit margin (a percent) more than one tenth the ten year cost
  public void calculatePremium(){
    premium = ((.1*getExpectedTenYearBenefit())+(getProfitMargin() * (.1*getExpectedTenYearBenefit())));
  }
  
  //returns the premium of this policy and any supplemental policies
  public double totalPremium(){
    if(hasSupplementalInsurance){
      getSupplementalInsurance().calculatePremium();
      return getPremium() + getSupplementalInsurance().totalPremium();
    } else{
      return getPremium();
    }
  }
  
  /*checks to see if the policy has expired and if it has renew the policy and recalculate the premium also
   * check any supplemental insurance's expiration date
   */
  public void processDate(Date date){
    if(date.compareTo(getExpirationDate()) >= 0){
      renewPolicy();
      calculatePremium();
      if(hasSupplementalInsurance){
        supplementalInsurance.processDate(date);
      }
    }
  }
}
  
  