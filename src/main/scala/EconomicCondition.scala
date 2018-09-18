import org.apache.commons.math3.distribution.NormalDistribution

/**
  * Created by Hamed on 6/20/2016.
  */
case class EconomicCondition(inflationDist: NormalDistribution,
                             interestDist: NormalDistribution,
                             gdpGrowthDist: NormalDistribution)