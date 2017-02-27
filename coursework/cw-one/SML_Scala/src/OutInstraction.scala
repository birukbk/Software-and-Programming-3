package sml

class OutInstruction(label: String, op: String, val register: Int)
  extends Instruction(label, op) {
  var value = 0;

  override def execute(m: Machine) {
   value =  m.regs(register)
    println("Register " + register + " contains: " + value)

  }

  override def toString(): String = {
    super.toString + " " + " prints " + register + " to the console"
  }
}

object OutInstruction {
  def apply(label: String, result: Int) =
    new OutInstruction(label, "out", result)
}