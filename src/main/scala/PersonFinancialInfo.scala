import org.apache.commons.math3.distribution.NormalDistribution

/**
  * Created by Hamed on 6/20/2016.
  */
case class PersonFinancialInfo (thisYearSalarySaving: Double,
                                accumulatedSavingUpToThisYear: Int,
                                annualSavingRaise: NormalDistribution)
