package decorator

/**
  * Created by BarrySSD on 14/05/2017.
  */
class PizzaDecorator (decoratePizza: Pizza) extends Pizza {
  override def getDesc: String = decoratePizza.getDesc

  override def getPrice: Double = decoratePizza.getPrice
}
