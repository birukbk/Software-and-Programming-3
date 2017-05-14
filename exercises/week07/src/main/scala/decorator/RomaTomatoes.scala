package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  override def getDesc: String = pizza.getDesc + ", RomaTomatoes(3.10)"

  override def getPrice: Double = pizza.getPrice + 3.10
}
