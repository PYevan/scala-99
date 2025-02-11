package wThree

class Person(var name: String, var age: Int, var country: String) {
  def getName: String = name
  def setName(newName: String): Unit = {
    name = newName
  }

  def getAge: Int = age

  def setAge(newAge: Int): Unit = {
    age = newAge
  }

  def getCountry: String = country

  def setCountry(newCountry: String): Unit = {
    country = newCountry
  }
}

class Student(name: String, age: Int, country: String, var grade: String) extends Person(name, age, country) {
  def getGrade: String = grade

  def setGrade(newS: String): Unit = {
    grade = newS
  }
}

abstract class Shape {
  def area: Double
}

class Rectangle(width: Double, height: Double) extends Shape {
  override def area: Double = width * height
}

class Circle(radius: Double) extends Shape {
  override def area: Double = Math.PI * radius * radius
}

class BankAccount(accountNumber: Int, var balance: Double) {
  def deposit(money: Double): Unit = {
    balance = balance + money
    println(s"Deposit ${balance}")
  }

  def withdraw(money: Double): Unit = {
    balance = balance - money
    
  }
}


object StudentApp {
  def main(args: Array[String]): Unit = {
    val student = new Student("Saturnino Nihad", 18, "USA", "A")

    println("Original Student:")
    println(s"Name: ${student.getName}")
    println(s"Age: ${student.getAge}")
    println(s"Country: ${student.getCountry}")
    println(s"Grade: ${student.getGrade}")

    student.setName("Albino Ellen")
    student.setAge(20)
    student.setCountry("Canada")
    student.setGrade("B")

    println("\nUpdated Student:")
    println(s"Name: ${student.getName}")
    println(s"Age: ${student.getAge}")
    println(s"Country: ${student.getCountry}")
    println(s"Grade: ${student.getGrade}")
  }
}