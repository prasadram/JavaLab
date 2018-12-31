package org.letuslearn.reflection;

public class MemberFieldsDemo {

  public static void main(String[] args) {
    // Fields
    Employee employee = new Employee("8596");
    ReflectionUtil.fieldInfo(employee);
    // Methods
    ContractEmployee contractEmployee = new ContractEmployee("562");
    ReflectionUtil.methodInfo(contractEmployee);

    // Accessing method using reflection
    Object object = employee;
    //System.out.println(object.getId()); // we can't access getId method but by using reflection we can do that
    ReflectionUtil.callGetIdMethod(object);

    // Accessing method using reflection one more example
    Object object1 = contractEmployee;
    System.out.println("No of Holidays before : " + contractEmployee.getHolidays());
    ReflectionUtil.callAddHolidaysMethod(object1, 80);
    System.out.println("No of Holidays after : " + contractEmployee.getHolidays());
  }
}
