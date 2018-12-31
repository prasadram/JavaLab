package org.letuslearn.reflection;

public class SimpleInstanceCreationDemo {

  public static void main(String[] args) {
    try {
      Employee employee = Employee.class.newInstance();
      System.out.println("Id : " + employee.getId());
      System.out.println("Sal : " + employee.getSal());
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
