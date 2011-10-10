package com.stone


import java.net.InetSocketAddress
import com.twitter.finagle.builder.{Server, ServerBuilder}
import com.twitter.finagle.http._
import com.twitter.finagle.{Service, SimpleFilter}


object Main { 
  def main(args: Array[String]) {
    val helloService = new HelloWorldService 
    
    val server: Server = ServerBuilder()
      .codec(RichHttp[Request](Http()))
      // .codec(Http()) // use this will cause hard to know wtf error: overloaded method value build with alternatives
      .bindTo(new InetSocketAddress(8080))
      .name("finagle-helloworld-server")
      .build(helloService)
  }
}



