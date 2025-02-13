// Type class definition
trait JsonSerializer[T] {
  def serialize(value: T): String
}

// Case class
case class Person(name: String)

// Type class instances
object JsonSerializerInstances {
  implicit val intSerializer: JsonSerializer[Int] = (value: Int) => s"$value"

  implicit val stringSerializer: JsonSerializer[String] = (value: String) => s"String: $value"

  // Fixed: Properly interpolate `person.name`
  implicit val personSerializer: JsonSerializer[Person] = (person: Person) => s"name: ${person.name}"
}

// Type class interface
object JsonSerializer {
  def toJson[T](value: T)(implicit serializer: JsonSerializer[T]): String = serializer.serialize(value)
}

// Usage
import JsonSerializerInstances._
val intJson = JsonSerializer.toJson(42)       // "42"
val strJson = JsonSerializer.toJson("hello")  // "String: hello"
val personJson = JsonSerializer.toJson(Person("Alice"))  // "name: Alice"

println(intJson)     // 42
println(strJson)     // String: hello
println(personJson)  // name: Alice



