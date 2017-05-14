package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  override def getDesc: String = pizza.getDesc + ", Ham(5.10)"

  override def getPrice: Double = pizza.getPrice + 5.10
}
