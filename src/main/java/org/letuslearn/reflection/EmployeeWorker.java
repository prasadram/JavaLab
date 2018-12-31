package org.letuslearn.reflection;

public class EmployeeWorker implements Runnable {

  Employee employee;
  ContractEmployee contractEmployee;

  public EmployeeWorker(Employee employee) {
    this.employee = employee;
  }

  public EmployeeWorker(ContractEmployee contractEmployee) {
    this.contractEmployee = contractEmployee;
  }

  public void doWork() {
    Thread thread = new Thread(contractEmployee != null ? contractEmployee : this);
    thread.start();
  }

  @Override
  public void run() {
    System.out.println("employee worker!!!!");
  }
}
