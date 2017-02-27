package sml

class OutInstruction(label: String, op: String, val result: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    //val value1 = m.regs(result)

  }

  override def toString(): String = {
    super.toString + " " + " prints " + result + " to the console"
  }
}

object OutInstruction {
  def apply(label: String, result: Int) =
    new OutInstruction(label, "out", result)
}