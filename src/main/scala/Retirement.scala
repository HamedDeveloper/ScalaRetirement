import scala.annotation.tailrec

case class Retirement(economicCondition: EconomicCondition, person: Person) {

    @tailrec
    private def savingsAtRetirement(age: Int, accSavings: Double): Double = {
        if (age == person.age) accSavings
        else {
            val financialInfo: PersonFinancialInfo = person.financialInfo
            val annualSaving = financialInfo.thisYearSalarySaving

            val annualRaiseRate = financialInfo.annualSavingRaise.sample()
            val appliedRate = 1 + annualRaiseRate + economicCondition.interestDist.sample()
            val totalAnnualSaving = appliedRate * annualSaving + accSavings
            savingsAtRetirement(
                age - 1,
                totalAnnualSaving * (100 + economicCondition.interestDist.sample()) / 100
            )
        }
    }

    @tailrec
    private def remainingAtEndOfRetirement(savings: Double, numOfYears: Int): Double = {
        if (numOfYears == 0) savings
        else {
            val appliedRate = 1 + economicCondition.interestDist.sample()
            remainingAtEndOfRetirement(savings * appliedRate - person.retirementPlan.annualRetirementSalary, numOfYears - 1)
        }
    }

    //TODO consider inflation rate.
    @tailrec
    final def achievementChance(experienceNum: Int, successNum: Int): Double = {
        if (experienceNum == 10000) successNum * 100 / experienceNum
        else {
            if (remainingAtEndOfRetirement(
                savingsAtRetirement(person.retirementPlan.retirementAge, person.financialInfo.accumulatedSavingUpToThisYear),
                person.retirementPlan.retirementYears)
              > 0) {
                achievementChance(experienceNum + 1, successNum + 1)
            } else achievementChance(experienceNum + 1, successNum)
        }
    }

}

