package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"


  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    //val className = opcode.capitalize +"Instruction"

    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")

      if (fields.length > 0) {
        labels.add(fields(0))
       // var opcode:String = fields(1)
       // var className = opcode.capitalize + "Instruction"

        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
           // program = program :+ action.newInstance.asInstanceOf[Instruction]((fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt))
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case x =>
            println(s"Unknown instruction $x")
        }
      /*  val name = fields(1).capitalize
        try {
          Class.forName(name)
          val className = name + "Instruction"
          try {
            val actualClass = Class.forName(className)
            val foo = actualClass.newInstance.asInstanceOf[Instruction]


          }
          catch {
            case ex: ClassNotFoundException =>
              println(s"No implementation for [$name found")
          }
        }
        catch {
          case ex: ClassNotFoundException =>
            println(s"No class of instruction [$name]")
        }
        //println(action)
        println("------>"+ name)*/
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
