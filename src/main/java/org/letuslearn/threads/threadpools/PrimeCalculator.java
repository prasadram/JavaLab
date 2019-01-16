package org.letuslearn.threads.threadpools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class PrimeCalculator implements Callable<Integer> {
  /*Callable will return the result to main thread*/
  private int start;
  private int end;

  public PrimeCalculator(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public Integer call() throws Exception {
    int count = 0;
    System.out.println(
            Thread.currentThread().getName() + " " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

    for (; start < end; start++) {
      if (isPrime(start)) {
        count++;
      }
    }
    return count;
  }

  private boolean isPrime(int number) {
    int sqrt = (int) Math.sqrt(number);
    for (int i = 2; i <= sqrt; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;

  }
}
