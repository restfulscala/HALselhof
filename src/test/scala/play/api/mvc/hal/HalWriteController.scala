package play.api.mvc.hal

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.json.Json
import play.api.mvc._
import play.api.hal._

trait HalWriteController {
  this: Results with Rendering with AcceptExtractors =>

  private implicit val system: ActorSystem = ActorSystem()
  private implicit val materializer: ActorMaterializer = ActorMaterializer()
  import scala.concurrent.ExecutionContext.Implicits.global

  val Action = DefaultActionBuilder.apply(PlayBodyParsers.apply().default)

  def hal = Action {
    Ok(Hal.state(Json.obj("foo" -> "bar")))
  }

  def halOrJson = Action { implicit request =>
    render {
      case Accepts.Json() => Ok(Json.obj("foo" -> "bar"))
      case AcceptHal() => Ok(Hal.state(Json.obj("foo" -> "bar")) ++ HalLink("self", "/orders"))
    }
  }

}
