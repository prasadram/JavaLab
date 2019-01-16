package org.letuslearn.threads;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeServiceWithoutThreadLocal4 {
  private static ExecutorService executorService = Executors.newFixedThreadPool(15);

  public static void main(String[] args) throws InterruptedException {
    for (int i=1; i< 1000; i++) {
      int id = i;
      executorService.submit(() -> {
        String birthDate = new EmployeeService4().getBirthDate(id);
        System.out.println(birthDate);
      });
    }
    executorService.shutdown();
    Thread.sleep(1000);
  }
}


class EmployeeService4 {
  public String getBirthDate(int userId) {
    Date birthDate = birthDateFromDB(userId);
    SimpleDateFormat df = ThreadSafeformatter.dateFormate.get();
    return df.format(birthDate);
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

class ThreadSafeformatter {
  public static ThreadLocal<SimpleDateFormat> dateFormate = new ThreadLocal<SimpleDateFormat>() {
    /*
    * For each thread this method will be called only once
    * */
    @Override
    protected SimpleDateFormat initialValue() {
      System.out.println(Thread.currentThread().getName());
      return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public SimpleDateFormat get() {
      //System.out.println(Thread.currentThread().getName());
      return super.get();
    }
  };
}