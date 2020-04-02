# Java-Boxing-Profiler

It is known that Java separates types into primitive types, such as int and double, and reference types, such
as Long and String, and these two type hierarchies are not compatible. On the other hand, since Java 1.5,
primitive types can be automatically converted to their corresponding wrapper type. This means that an int
will be automatically converted to the corresponding Integer when the need arises, as is visible in the following
example:

```java
Vector nums = new Vector();
int i = 5;
nums.add(i);
System.out.println(nums.get(0).getClass());
```

When executed, the previous code fragment prints class java.lang.Integer, showing that the value of
the primitive int variable i was converted to the corresponding value of the Integer reference type. This
language feature is known as autoboxing.
Similarly, a value of one of the wrapper types can be automatically converted into a value of the corresponding
primitive type, as the following example shows:

```java
ArrayList<Integer> Nums = new ArrayList<Integer>();
Nums.add(new Integer(42));
int j = Nums.get(0);
System.out.println(j);
```

When executed, the previous code fragment prints 42, showing that the value was correctly converted from
an Integer reference type to an int type.
Despite the convenience of automatic boxing and unboxing, there might be significant overheads included
which might not be entirely obvious to the programmer. As a concrete example, consider the following fragment:

```java
long sum = 0L;
for (int i = 0; i < 1000000000; i++) {
	sum += i;
}
```
and the slightly different version:

```java
Long sum = 0L;
for (int i = 0; i < 1000000000; i++) {
	sum += i;
}
```

Although they differ by just one letter, the second fragment runs twenty times slower than the first.
Given that automatic boxing and unboxing can create performance problems that might be difficult to spot,
it would be interesting to have a profiling tool that can measure the amount of automatic boxing and unboxing
that is made by a given program.

## Implementation of a boxing/unboxing profiler for Java. 

During the execution of the Java program the profiler
will count all the boxing and unboxing operations that are being done and, at the end of the program execution,
for each method, it prints those counters on System.err.

## Example
```{r, engine='bash', count_lines}
$ java com.java.profiler.BoxingProfiler SumIntegers
Sum: 4999999950000000
Time: 4436
SumIntegers.main(java.lang.String[]) boxed 1 java.lang.Integer
SumIntegers.main(java.lang.String[]) boxed 1 java.lang.Long
SumIntegers.printSum(java.lang.Long) unboxed 1 java.lang.Long
SumIntegers.sumOfIntegerUptoN(java.lang.Integer) unboxed 100000001 java.lang.Integer
SumIntegers.sumOfIntegerUptoN(java.lang.Integer) boxed 100000001 java.lang.Long
SumIntegers.sumOfIntegerUptoN(java.lang.Integer) unboxed 100000001 java.lang.Long
```

