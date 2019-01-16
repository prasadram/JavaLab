package org.letuslearn.threads;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeServiceWithoutThreadLocal3 {
  private static ExecutorService executorService = Executors.newFixedThreadPool(15);
  private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

  public static void main(String[] args) throws InterruptedException {
    for (int i=1; i< 1000; i++) {
      int id = i;
      executorService.submit(() -> {
        Date birthDate = new EmployeeService3().getBirthDate(id);
        System.out.println(df.format(birthDate));
      });
    }
    executorService.shutdown();
    Thread.sleep(1000);
  }
}

class EmployeeService3 {
  public Date getBirthDate(int userId) {
    Date birthDate = birthDateFromDB(userId);
    return birthDate;
  }

  private Date birthDateFromDB(int userId) {
    Random random = new Random();
    OptionalInt first = random.ints(1, 350).findFirst();
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, first.orElse(5));
    return calendar.getTime();
  }
}
