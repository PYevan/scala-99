package basicThings

class Person(name: String, age: Int) {
  def greet(): Unit = {
    println(s"I am ${name}, my age is ${age}")
  }
}


class Animal(name: String, age: Int) {
  def this(name: String) = this(name, 0) // default age is 0

  def info(): Unit = {
    print(s"This is a ${name}, age is ${age}")
  }
}