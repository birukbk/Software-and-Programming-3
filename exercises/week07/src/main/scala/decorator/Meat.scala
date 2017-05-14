package decorator

class Meat(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  override def getDesc: String = pizza.getDesc + ", Meat(8.55)"

  override def getPrice: Double = pizza.getPrice + 8.55
}
