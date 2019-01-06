package org.letuslearn.reflection;

import org.letuslearn.annotations.ProcessedBy;

@ProcessedBy(EmployeeWorker.class)
public class Employee {
  private final String id;
  private int sal = 10;

  public Employee() {
    id = "999";
  }

  public Employee(String id) {
    this.id = id;
  }

  public Employee(String id, int sal) {
    this.id = id;
    this.sal = sal;
  }

  public String getId() {
    return id;
  }

  public synchronized int getSal() {
    return sal;
  }
}
