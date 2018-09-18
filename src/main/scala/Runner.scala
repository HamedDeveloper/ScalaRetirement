import org.apache.commons.math3.distribution.NormalDistribution

/**
  * Created by Hamed on 6/20/2016.
  */
object Runner {

  def main(args: Array[String]) {
    val financialInfo: PersonFinancialInfo = PersonFinancialInfo(10000, 140000, new NormalDistribution(0.08, 0.2))
    val plan: RetirementPlan = RetirementPlan(65, 20, 100000)
    val person: Person = Person(36, financialInfo, plan)
    val economicCondition: EconomicCondition = EconomicCondition(new NormalDistribution(0.02, 0.08),
      new NormalDistribution(0.015, 0.02), new NormalDistribution(0.025, 0.05))
    val retirement: Retirement = Retirement(economicCondition, person)
    println("Chance of your retirement plan working using Monte Carlo simulation is " + retirement.achievementChance() + "%")
  }
}
