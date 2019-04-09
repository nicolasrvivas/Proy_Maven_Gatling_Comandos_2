
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://www.qanovagroup.com")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9,en;q=0.8")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")

	val headers_0 = Map("Proxy-Connection" -> "keep-alive")

	val headers_1 = Map(
		"Origin" -> "http://www.qanovagroup.com",
		"Proxy-Connection" -> "keep-alive")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/piloto/")
			.headers(headers_0))
		.pause(9)
		.exec(http("request_1")
			.post("/piloto/imlogin.php")
			.headers(headers_1)
			.formParam("imUname", "nvivas")
			.formParam("imPwd", "qanova"))
		.pause(1)
		.exec(http("request_2")
			.get("/piloto/carga-de-informacion.php")
			.headers(headers_0))
		.pause(3)
		.exec(http("request_3")
			.get("/piloto/res/imlogout.php")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}