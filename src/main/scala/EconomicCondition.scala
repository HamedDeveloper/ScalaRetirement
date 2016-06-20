import org.apache.commons.math3.distribution.NormalDistribution

/**
  * Created by Hamed on 6/20/2016.
  */
class EconomicCondition(eInflationDist: NormalDistribution, eInterestDist: NormalDistribution, eGdpGrowthDist: NormalDistribution){

  val inflationDist: NormalDistribution = eInflationDist
  val interestDist: NormalDistribution = eInterestDist
  val gdpGrowthDist: NormalDistribution = eGdpGrowthDist
}
