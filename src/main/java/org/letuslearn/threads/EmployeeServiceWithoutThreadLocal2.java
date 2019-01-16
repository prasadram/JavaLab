package org.letuslearn.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeServiceWithoutThreadLocal2 {
  private static ExecutorService executorService = Executors.newFixedThreadPool(15);
  public static void main(String[] args) throws InterruptedException {
      for (int i=1; i< 1000; i++) {
        int id = i;
        executorService.submit(() -> {
          String birthDate = new EmployeeService().getBirthDate(id);
          System.out.println(birthDate);
        });
      }
      executorService.shutdown();
      Thread.sleep(1000);
  }
}


