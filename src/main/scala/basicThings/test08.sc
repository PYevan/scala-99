case object Poultry
case object Pork
case object Beef

sealed trait CanBeButchered[Meat] {
  def produce: Meat
}

case class Chicken() extends CanBeButchered[Poultry.type] {
  override def produce: Poultry.type = Poultry
}

case class Duck() extends CanBeButchered[Poultry.type] {
  override def produce: Poultry.type = Poultry
}

case class Pig() extends CanBeButchered[Pork.type] {
  override def produce: Pork.type = Pork
}

case class Cow()

class ButcherShop() {
  //  def produce(c: Chicken): Poultry.type = {
  //    c.produce
  //  }
  //  def produce(c: Duck): Poultry.type  = {
  //    c.produce
  //  }
  //  def produce(c: Pig): Pork.type  = {
  //    c.produce
  //  }


  //  def produce(c: Any): Any = {
  //    if (c.isInstanceOf[Chicken]) {
  //      Poultry
  //    } else if (c.isInstanceOf[Duck]) {
  //      Poultry
  //    }
  //  }

  def produce[Meat](c: CanBeButchered[Meat]): Meat = {
    c.produce
  }
}

val shop = new ButcherShop()

println(shop.produce(Chicken())) // 
println(shop.produce(Duck())) //
println(shop.produce(Pig()))
//println(shop.produce(Cow()))




