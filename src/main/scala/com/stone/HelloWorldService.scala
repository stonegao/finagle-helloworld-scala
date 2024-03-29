package com.stone

import org.jboss.netty.handler.codec.http._
import org.jboss.netty.handler.codec.http.HttpResponseStatus._
import org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1
import org.jboss.netty.buffer.ChannelBuffers.copiedBuffer
import org.jboss.netty.util.CharsetUtil.UTF_8
import com.twitter.finagle.http._
import com.twitter.util.Future
import com.twitter.finagle.{Service}


class HelloWorldService extends Service[Request, Response]
{
  def apply(request: Request) = {
    request.path match {
      case "/hi" => 
        val response = new DefaultHttpResponse(HTTP_1_1, OK)
        response.setContent(copiedBuffer("hello world", UTF_8))
        Future.value(Response(response))
      case _ => 
        Future.value(Response())
    }
  }
}

