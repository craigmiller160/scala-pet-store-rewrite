package io.craigmiller160.scalapetstore

object Temp extends App {
  trait Foo[F[_]] {
    def map[A,B](fa: F[A])(f: A => B): F[B]
  }

  implicit val fooOption = new Foo[Option] {
    override def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  val list: List[String] = List("World")
  val option: Option[String] = Option("Hello")
  println("Phase 1")
  practice[Option](option)
  practice[List](list)

  println("Phase 2")
  val phase2Result = practiceFoo(option)
  println(phase2Result)

  def practice[F[_]](value: F[_]): Unit = {
    println(value)
  }

  def practiceFoo[F[_]: Foo, A](value: F[A])(implicit foo: Foo[F]): F[String] = {
    foo.map(value) { a => s"$a Stuff" }
  }
}
