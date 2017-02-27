package sml

case class BnzInstruction(label: String, opcode: String, register: Int, value: Int) extends Instruction(label, opcode) {

  override def execute(m: Machine) =
    m.regs(register) = value

 // if (register!=0) execute(value, "L2")

  override def toString(): String = {
    super.toString + " register " + register + " value is " + value + "\n"
  }
}

object BnzInstruction {
 // def apply(label: String, register: Int, value: Registers) =
   // new BnzInstruction(label, "bnz", register, value)
}