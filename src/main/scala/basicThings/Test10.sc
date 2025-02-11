trait Show[A] {
  def show(a: A): String
}

object Show {
  implicit val intShow: Show[Int] = (a: Int) => s"Integer: $a"
  implicit val stringShow: Show[String] = (a: String) => s"String: $a"
}

def printPretty[A](a: A)(implicit sh: Show[A]): Unit =
  println(sh.show(a))


printPretty(42)      // Output: Integer: 42
printPretty("Scala") // Output: String: Scala



case class User(name: String, age: Int)

trait JsonWriter[A] {
  def write(a: A): String
}

object JsonWriter {
  implicit val intWriter: JsonWriter[Int] = (a: Int) => a.toString
  implicit val UserWriter: JsonWriter[User] = (a: User) => s"${a.name}, ${a.age}"
}

def toJson[A](a: A)(implicit writer: JsonWriter[A]): String =
  writer.write(a)

println(toJson(42))
println(toJson(User("Alice", 30)))



case class Person(fName: String, lName: String)

val result: Person = Person("Evan", "Lian")

assert(result.lName == "ian")

println("okokokokok")

// =======================****============================

object Configuration {
  lazy val KeyNumberOfFoos: String = "NumberOfFoos"
  lazy val KeyNumberOfBar: String = "NumberOfBar"
}

object Database {
  private val database: Map[String, Int] = Map(
    Configuration.KeyNumberOfFoos -> 567,
    Configuration.KeyNumberOfBar -> 12
  )

  def getDataFromDatabase(key: String): Option[Int] =
    database.get(key)
}

val configurationFromDatabase: Option[Int] =
  Database.getDataFromDatabase(Configuration.KeyNumberOfFoos)

println(configurationFromDatabase)

assert(configurationFromDatabase.contains(567))

println("454545")


// =======================****============================
val input: Option[Int] = Some(1)
println(input)

val mapped: Option[Int] = input.map(a => 123)
println(mapped)


val someValue: Option[String] = Some("I am evan")

println(someValue)

