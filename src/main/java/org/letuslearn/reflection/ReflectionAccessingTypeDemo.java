package org.letuslearn.reflection;

public class ReflectionAccessingTypeDemo {
  public static void main(String[] args) {
    ContractEmployee contractEmployee = new ContractEmployee("236");
    ReflectionUtil.classInfo(contractEmployee);
    ReflectionUtil.typeModifierInfo(contractEmployee);
  }
}
