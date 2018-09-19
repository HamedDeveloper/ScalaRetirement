import org.apache.commons.math3.distribution.NormalDistribution

case class EconomicCondition(inflationDist: NormalDistribution,
                             interestDist: NormalDistribution,
                             gdpGrowthDist: NormalDistribution)