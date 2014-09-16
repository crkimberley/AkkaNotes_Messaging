package me.rerun.akkanotes.messaging

import org.scalatest.MustMatchers
import org.scalatest.WordSpecLike
import TeacherProtocol.QuoteRequest
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.testkit.TestKit
import org.scalatest.BeforeAndAfterAll

class TeacherTest extends TestKit(ActorSystem("QuoteSystem"))
  with WordSpecLike
  with MustMatchers
  with BeforeAndAfterAll {

  "A teacher" must {

    "print a quote when a QuoteRequest message is sent" in {

      val teacherRef = system.actorOf(Props[Teacher])
      teacherRef ! QuoteRequest

    }

  }

  "A teacher with ActorLogging" must {

    "log a quote when a QuoteRequest message is sent" in {

      val teacherRef = system.actorOf(Props[Teacher2WithLogging])
      teacherRef ! QuoteRequest

    }
    
  }
  
  
  

  override def afterAll() {
    super.afterAll()
    system.shutdown()

  }

}