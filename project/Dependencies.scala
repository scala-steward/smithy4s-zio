import sbt.{Def, ModuleID, *}
import Keys.*


object Dependencies {
  object Http4s {
    val http4sVersion = Def.setting( "0.23.16")

    val circe: Def.Initialize[ModuleID] =
      Def.setting("org.http4s" %% "http4s-circe" % http4sVersion.value)

    val emberServer: Def.Initialize[ModuleID] =
      Def.setting("org.http4s" %% "http4s-ember-server" % http4sVersion.value)
    val emberClient: Def.Initialize[ModuleID] =
      Def.setting("org.http4s" %% "http4s-ember-client" % http4sVersion.value)
    val dsl: Def.Initialize[ModuleID] =
      Def.setting("org.http4s" %% "http4s-dsl" % http4sVersion.value)
  }

  object Typelevel{
    val vault: Def.Initialize[ModuleID] =   Def.setting("org.typelevel" %% "vault" % "3.5.0")
  }

  object Weaver {

    val weaverVersion =
      Def.setting("0.8.0" )

    val cats: Def.Initialize[ModuleID] =
      Def.setting("com.disneystreaming" %% "weaver-cats" % weaverVersion.value)

    val scalacheck: Def.Initialize[ModuleID] =
      Def.setting(
        "com.disneystreaming" %% "weaver-scalacheck" % weaverVersion.value
      )
  }

  val ApiRegistryLib = new {
    val org = "com.disneystreaming.api.registry.lib"

    val registryLibVersion = "0.2.6"

    val dslibTraits = org % "dslib-traits" % registryLibVersion
    val openApi = org %% "openapi" % registryLibVersion
    val openapiDiscovery = org % "openapi-discovery" % registryLibVersion
  }
  val ApiRegistry = new {
    val org = "com.disneystreaming.api.registry"
    // Version value is called registryVersion to make it steward friendly
    val registryVersion = "2022.11.01.635"

    val dslib = org % "dslib" % registryVersion
    val pizza = org % "examples.pizza" % registryVersion
  }

}