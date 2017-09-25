# HALselhof
A [HAL](http://tools.ietf.org/html/draft-kelly-json-hal) library based on [Play-JSON](https://www.playframework.com/documentation/2.6.x/ScalaJson).

[![Build Status](https://travis-ci.org/restfulscala/HALselhof.svg?branch=master)](https://travis-ci.org/restfulscala/HALselhof)

## Usage

To use this library, add the following settings to your build definition:

```
resolvers += "restful-scala" at "https://dl.bintray.com/restfulscala/maven"

libraryDependencies += "org.restfulscala" %% "halselhof" % "0.3.0"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.3"
```

You need to add the `play-json` dependency explicitly, as _HALselhof_ assumed it is being provided by your application. If you use this library with the Play framework, _play-json_ should already be on your classpath.

## Standalone Example
```scala
// Test data which should be reflected in the resource state
case class TestData(total: Int, currency: String, status: String)

// a generated play.api.libs.json.Writes
implicit val testWrites = Json.writes[TestData]

// transfer the resource state into a full HAL resource
val data = TestData(20, "EUR", "shipped")
val resource: HalResource = data.asResource ++
 HalLink("self", "/orders") ++
 HalLink("next", "/orders?page=2") ++
 HalLink("find", "/orders{?id}", templated = true)

// transfer the resource to the Play JSON AST
val json = resource.json
```
[Examples](https://github.com/tobnee/HALselhof/blob/master/src/test/scala/play/api/hal/TestHalConstruction.scala)

## Play Framework Integration
```scala
// within a Play Controller HAL resources can be serialized directly and are supported within content negotiation
import play.api.hal._
import play.api.mvc.hal._

def halOrJson = Action { implicit request =>
  render {
    case Accepts.Json() => Ok(Json.obj("foo" -> "bar"))
    case AcceptHal() => Ok(Hal.state(Json.obj("foo" -> "bar")) ++ HalLink("self", "/foo"))
  }
}
```

## Release Notes

- 0.3.0: Update to Play 2.6, cross-building for Scala 2.11 and 2.12
- 0.2.0: Update to Play 2.5, dropping support for Scala 2.10
- 0.1.0: First release of the library

## Contributors

Tobias Neef, Mike Mazur, Daniel Westheide, Aristotelis Dossas
