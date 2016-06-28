import org.apache.commons.math3.distribution.NormalDistribution

/**
  * Created by Hamed on 6/20/2016.
  */
class PersonFinancialInfo (pThisYearSalarySaving: Double, pAccumulatedSavingUpToThisYear: Int, pAnnualSavingRaise: NormalDistribution){

  val thisYearSalarySaving: Double = pThisYearSalarySaving
  val accumulatedSavingUpToThisYear: Int = pAccumulatedSavingUpToThisYear
  val annualSavingRaiseDist: NormalDistribution = pAnnualSavingRaise
}
