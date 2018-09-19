import org.apache.commons.math3.distribution.NormalDistribution

case class PersonFinancialInfo(thisYearSalarySaving: Double,
                               accumulatedSavingUpToThisYear: Int,
                               annualSavingRaise: NormalDistribution)
