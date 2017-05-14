package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {

  override def getDesc: String = pizza.getDesc + ", Cheese(10.50)"

  override def getPrice: Double = pizza.getPrice + 10.50

}
