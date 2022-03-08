package io.craigmiller160.scalapetstore

object Temp extends App {
  trait Foo[F[_]] {
    def map[A,B](fa: F[A])(f: A => B): F[B]
  }

//  implicit val fooOption = new Foo[Option] {
//    override def map[A, B](fa: Option[A])(f: A => B): Option[B] = ???
//  }

  val list: List[String] = List("World")
  val option: Option[String] = Option("Hello")
  println("Phase 1")
  practice[Option](option)
  practice[List](list)

  println("Phase 2")
  practice[Option](option)

  def practice[F[_]](value: F[_]): Unit = {
    println(value)
  }

  def practiceFoo[F[_]: Foo](value: F[_]): Unit = {
    println(value)
  }
}
