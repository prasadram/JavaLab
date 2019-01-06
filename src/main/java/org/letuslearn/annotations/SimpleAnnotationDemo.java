package org.letuslearn.annotations;

import org.letuslearn.reflection.ContractEmployee;
import org.letuslearn.reflection.ReflectionUtil;

public class SimpleAnnotationDemo {
  public static void main(String[] args) {
    ContractEmployee contractEmployee = new ContractEmployee("856");
    ReflectionUtil.statWork("org.letuslearn.reflection.EmployeeWorker", contractEmployee);
  }
}
