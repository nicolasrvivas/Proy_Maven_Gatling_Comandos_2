
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Falabella extends Simulation {

	val httpProtocol = http
		.baseUrl("https://www.falabella.com")
		.inferHtmlResources()
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")

	val headers_0 = Map(
		"Accept-Encoding" -> "gzip, deflate",
		"Pragma" -> "no-cache",
		"Proxy-Connection" -> "keep-alive")

	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map("Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8")

	val headers_5 = Map(
		"Accept" -> "application/json, text/plain, */*",
		"Content-Type" -> "application/json")

	val headers_8 = Map(
		"Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"Pragma" -> "no-cache")

	val headers_9 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Accept-Encoding" -> "gzip, deflate",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "http://www.qanovagroup.com:2095",
		"Proxy-Connection" -> "keep-alive",
		"X-Requested-With" -> "XMLHttpRequest",
		"X-Roundcube-Request" -> "VToaQCWuFQ2EhmO0dA7Ggvkznijxa4hj")

	val headers_10 = Map(
		"Accept" -> "*/*",
		"Origin" -> "https://www.falabella.com")

    val uri1 = "http://www.qanovagroup.com:2095/cpsess8933936826/3rdparty/roundcube"
    val uri2 = "http://www.gstatic.com/generate_204"

	val scn = scenario("Falabella")
		.exec(http("request_0")
			.get(uri2 + "")
			.headers(headers_0))
		.pause(12)
		.exec(http("request_1")
			.get("/falabella-cl/")
			.headers(headers_1)
			.resources(http("request_2")
			.get("/static/RDF/site/home/hero/1s19/04-abril/vitrina_makeup-home-030419-pb-dt-1x.webp")
			.headers(headers_2),
            http("request_3")
			.get("/static/RDF/site/home/hero/1s19/04-abril/HH-PLANES-080419-CC-1x.webp")
			.headers(headers_2),
            http("request_4")
			.get("/static/RDF/site/home/hero/1s19/04-abril/vitrina_makeup-home-030419-pb-dt-1x.webp")
			.headers(headers_2),
            http("request_5")
			.get("/rest/model/falabella/rest/browse/BrowseActor/fetch-daily-deals")
			.headers(headers_5),
            http("request_6")
			.get("/static/RDF/site/home/multicategorias/2019/04_Abril/MC1-CMR-LineaBlanca-CV-2x.webp")
			.headers(headers_2),
            http("request_7")
			.get("/static/RDF/site/home/multicategorias/2019/04_Abril/MC2-CMR-Telefonia-PG-2x.webp")
			.headers(headers_2)))
		.pause(1)
		.exec(http("request_8")
			.get("/favicon-32x32.png")
			.headers(headers_8))
		.pause(7)
		.exec(http("request_9")
			.post(uri1 + "/?_task=mail&_action=refresh")
			.headers(headers_9)
			.formParam("_mbox", "INBOX")
			.formParam("_folderlist", "1")
			.formParam("_last", "1554843025")
			.formParam("_remote", "1")
			.formParam("_unlock", "loading1554843085822"))
		.pause(12)
		.exec(http("request_10")
			.get("/static/assets/82/fonts/lato-v13-latin-ext_latin-italic.woff2")
			.headers(headers_10))
		.pause(3)
		.exec(http("request_11")
			.get("/falabella-cl/category/cat720161/Smartphones")
			.headers(headers_1))
		.pause(2)
		.exec(http("request_12")
			.get("/static/assets/82/fonts/lato-v13-latin-ext_latin-100.woff2")
			.headers(headers_10))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}