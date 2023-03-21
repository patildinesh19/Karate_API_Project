package performance

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class PerTest extends Simulation {

// it is pointing gatling protocol to karate protocol

  val protocol = karateProtocol(
  //define unique url for delete request
  
  "/api/articles/{title}" -> Nil  
  ) 

  //protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")
  val csvfeeder = csv("testdata.csv").circular
 
  val createarticle = scenario("create and delete Article").feed(csvfeeder).exec(karateFeature("classpath:performance/getArcdeleArc.feature"))
  
  //set is actual doing performance setup means how many user we want to execute, how many user per second we want execute should mention under setup
  // below example will execute for 3 vertual users
  setUp(
    createarticle.inject(
    atOnceUsers(2),
    nothingFor(4 second),
    constantUsersPerSec(2).during(2 second)
    ).protocols(protocol)
  )

}