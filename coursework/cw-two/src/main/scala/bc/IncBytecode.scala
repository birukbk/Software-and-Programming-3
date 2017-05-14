package bc
import vm.VirtualMachine

/**
  * Created by Aman Enghida and Biruk Gebreselassie on 12/05/2017.
  */
class IncBytecode extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[ByteCodeValues]]
    */
  override val code: Byte = bytecode("iinc")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    vm.push(vm.pop()._1 + 1)
  }
}
