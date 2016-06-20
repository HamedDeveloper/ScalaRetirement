/**
  * Created by Hamed on 6/20/2016.
  */
class Retirement (eEconomicCondition: EconomicCondition, rPerson: Person){

  val economicCondition: EconomicCondition = eEconomicCondition
  val person: Person = rPerson

  def savingsAtRetirement() : Double = {
    val financialInfo: PersonFinancialInfo = person.financialInfo
    val accumulatedSavingUpToThisYear: Integer = financialInfo.accumulatedSavingUpToThisYear
    var annualSaving: Double = financialInfo.thisYearSalarySaving
    var retirementSavings: Double = accumulatedSavingUpToThisYear + annualSaving

    for( a <- 1 to (person.retirementPlan.retirementAge - person.age)){
      val annualRaiseRate: Double = financialInfo.annualSavingRaiseDist.sample();
      val appliedRate: Double = 1+annualRaiseRate+economicCondition.interestDist.sample()
      annualSaving = appliedRate * annualSaving
      retirementSavings = annualSaving + (retirementSavings * (100+economicCondition.interestDist.sample())/100)
    }
    retirementSavings
  }

  def remainingAtEndOfRetirement(savings: Double) = {
    var retirementSavings: Double = savings
    for( a <- 1 to person.retirementPlan.retirementYears) {
      val appliedRate = 1+economicCondition.interestDist.sample()
      retirementSavings = retirementSavings * appliedRate - person.retirementPlan.annualRetirementSalary
    }
    retirementSavings
  }

  //TODO consider inflation rate.
  def achievementChance(): Double ={
    var possibleCases: Integer = 0
    for( a <- 1 to 10000) {
      if (remainingAtEndOfRetirement(savingsAtRetirement()) > 0){
        possibleCases = possibleCases + 1
      }
    }
    possibleCases/100
  }

}
