Memory areas managed by JVM

1. Stack Memory
Local variables
Method parameters
Method calls
Primitive values
Object reference

Lifetime - Until method ends

2. Heap Memory
Objects
Arrays
Instance variables

Lifetime - Until GC removes

3. Method Area/Metaspace - Stores class-level information
Class metadata
Method bytecode
Static variables
Runtime constant pool

Lifetime - Until class unloaded

4. PC Register - Current instruction , thread lifetime
5. Native Stack - Native method execution , native call lifetime

