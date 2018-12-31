package org.letuslearn.reflection;

import java.sql.Ref;

public class ReflectionDemo {
  public static void main(String[] args) {

    /* Class Instance from object reference */
    Employee employee = new Employee("254");
    ReflectionUtil.showName(employee.getClass());

    /* Class Instance from String name */
    try {
      Class<?> employeeClass = Class.forName("org.letuslearn.reflection.Employee");
      ReflectionUtil.showName(employeeClass);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    /* Class Instance from Type literal */
    Class<?> employeeClassFromLiteral = Employee.class;
    ReflectionUtil.showName(employeeClassFromLiteral);
    Class<Employee> employeeClassFromLiteral1 = Employee.class;
    ReflectionUtil.showName(employeeClassFromLiteral1);

    // employee,employeeClass,employeeClassFromLiteral,employeeClassFromLiteral1will have same instance of
    // Employee.class
  }
}
