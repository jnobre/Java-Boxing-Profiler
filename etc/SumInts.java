public class SumInts {
  private static long sumOfIntegerUptoN(int n) {
    long sum = 0L;
    for (int i = 0; i < n; i++) {
      sum += i;
    }
    return sum;
  }

  private static long printSum(long n) {
    System.out.println("Sum: " + n);
    return n;
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    printSum(sumOfIntegerUptoN(100000000));
    long end = System.currentTimeMillis();
    System.out.println("Time: " + (end - start));
  }
}
