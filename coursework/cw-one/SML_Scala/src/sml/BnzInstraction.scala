package sml

case class BnzInstruction(label: String, opcode: String, val register: Int, val labelToExcute:String) extends Instruction(label, opcode) {

  override def execute(m: Machine) {
    val value1 = m.regs(register)
    val value2 = labelToExcute.drop(1).toInt
    if (value1 != 0) m.pc = value2
  }
  override def toString(): String = {
    super.toString + " register " + register + " register2 "  + "\n"
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, labelToExcute: String) =
  new BnzInstruction(label, "bnz", register, labelToExcute)
}
