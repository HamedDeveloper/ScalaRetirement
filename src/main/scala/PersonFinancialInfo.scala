import org.apache.commons.math3.distribution.NormalDistribution

/**
  * Created by Hamed on 6/20/2016.
  */
class PersonFinancialInfo (pThisYearSalarySaving: Double, pAccumulatedSavingUpToThisYear: Integer, pAnnualSavingRaise: NormalDistribution){

  val thisYearSalarySaving: Double = pThisYearSalarySaving
  val accumulatedSavingUpToThisYear: Integer = pAccumulatedSavingUpToThisYear
  val annualSavingRaiseDist: NormalDistribution = pAnnualSavingRaise
}
