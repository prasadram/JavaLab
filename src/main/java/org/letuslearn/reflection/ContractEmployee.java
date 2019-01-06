package org.letuslearn.reflection;

import org.letuslearn.annotations.ProcessedBy;

@ProcessedBy(EmployeeWorker.class)
public final class ContractEmployee extends Employee implements Runnable{
  private int holidays;
  public ContractEmployee(String id) {
    super(id);
  }

  public ContractEmployee(String id, int sal) {
    super(id, sal);
  }

  public int getHolidays() {
    return holidays;
  }

  public void addHolidays(int holidays) {
    this.holidays += holidays;
  }

  @Override
  public void run() {
    System.out.println("Calculating pay roll for contract employee");
  }
}
