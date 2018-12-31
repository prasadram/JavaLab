package org.letuslearn.reflection;

public class ComplexInstanceCreationDemo {
  public static void main(String[] args) {
    Employee employee = new Employee("456");
    ReflectionUtil.statWork("org.letuslearn.reflection.EmployeeWorker", employee);
    //
    ContractEmployee contractEmployee = new ContractEmployee("856");
    ReflectionUtil.statWork("org.letuslearn.reflection.EmployeeWorker", contractEmployee);
  }
}
