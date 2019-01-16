package org.letuslearn.threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Random;

public class EmployeeServiceWithoutThreadLocal1 {
  public static void main(String[] args) throws ParseException, InterruptedException {
    for (int i=0; i< 10; i++) {
      int id = i;
      new Thread(() -> {
        String birthDate = new EmployeeService().getBirthDate(id);
        System.out.println(birthDate);
      }).start();
    }
    Thread.sleep(1000);
  }
}

class EmployeeService {
  public String getBirthDate(int userId) {
    Date birthDate = birthDateFromDB(userId);
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
