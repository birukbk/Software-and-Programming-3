package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject {
  var comment: String = "Something..."
  def subscribeObserver(observer: Observer) = subscribers append observer

  def unSubscribeObserver(observer: Observer) ={
    val deleteI = subscribers.indexOf(observer)
    if (deleteI >= 0) subscribers.remove(deleteI)
  }

  def notifyObservers() ={
    for (ob <- subscribers) ob.update(subjectDetails)
  }

  def subjectDetails: String = title + comment

  def setDesc(desc: String) = {
    comment = desc
    notifyObservers()
  }
}
