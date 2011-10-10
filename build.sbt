name          := "finagle-helloworld"

version       := "1.0"

organization  := "com.stone"

scalaVersion  := "2.8.2"

// Add Twitter's Repository
resolvers += "twitter.com" at "http://maven.twttr.com/"

// Add multiple dependencies
libraryDependencies ++= Seq(
    "com.twitter" % "finagle-core" % "1.9.0",
    "com.twitter" % "finagle-http" % "1.9.0"
)

