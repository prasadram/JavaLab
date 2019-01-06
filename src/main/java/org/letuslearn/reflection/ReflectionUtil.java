package org.letuslearn.reflection;

import org.letuslearn.annotations.WorkHandler;

import java.lang.reflect.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReflectionUtil {

  public static void showName(Class<?> theClass) {
    System.out.println(theClass.getSimpleName());
  }

  public static void classInfo(Object object) {
    System.out.println("====Class Info====");
    Class<?> theClass = object.getClass();
    System.out.println("Name : " + theClass.getSimpleName());
    Class<?> superclass = theClass.getSuperclass();
    System.out.println("Super Class Name : " + superclass.getSimpleName());
    Class<?>[] interfaces = theClass.getInterfaces();
    for(Class<?> interface1 : interfaces) {
      System.out.println("Interface Name : " + interface1.getSimpleName());
      System.out.println("isInterface : " + interface1.isInterface());
    }
  }

  public static void typeModifierInfo(Object object) {
    System.out.println("====Modifier Info====");
    Class<?> theClass = object.getClass();
    int modifiers = theClass.getModifiers();
    if ((modifiers & Modifier.FINAL) > 0) {
      System.out.println("bitwise check - final");
    }
    if (Modifier.isFinal(modifiers)) {
      System.out.println("method check - final");
    }
    if (Modifier.isPrivate(modifiers)) {
      System.out.println("method check - private");
    } else if (Modifier.isProtected(modifiers)) {
      System.out.println("method check - protected");
    } else if (Modifier.isPublic(modifiers)) {
      System.out.println("method check - public");
    }
  }

  public static void fieldInfo(Object object) {
    System.out.println("====Fields Info====");
    Class<?> theClass = object.getClass();
    Field[] fields = theClass.getFields();
    System.out.println("====Fields====");
    displayFields(fields);
    Field[] declaredFields = theClass.getDeclaredFields();
    System.out.println("====Declared Fields====");
    displayFields(declaredFields);
  }

  private static void displayFields(Field[] fields) {
    for(Field field: fields) {
      System.out.println(field.getName() + " : " + field.getType());
    }
  }

  public static void methodInfo(Object object) {
    System.out.println("====Method Info====");
    Class<?> theClass = object.getClass();
    Method[] methods = theClass.getMethods();
    System.out.println("====Methods====");
    displayMethods(methods);
    System.out.println("====Excluding Object's Methods====");
    displayMethodsOtherThanObject(methods);
    Method[] declaredMethods = theClass.getDeclaredMethods();
    System.out.println("====Declared Methods====");
    displayMethods(declaredMethods);
  }

  private static void displayMethods(Method[] methods) {
    for(Method method : methods) {
      System.out.println(method.getName());
    }
  }

  private static void displayMethodsOtherThanObject(Method[] methods) {
    for(Method method : methods) {
      if (method.getDeclaringClass() != Object.class)
        System.out.println(method.getName());
    }
  }

  public static void callGetIdMethod(Object object) {
    System.out.println("====Calling getId method using reflection====");
    Class<?> theClass = object.getClass();
    try {
      Method getIdMethod = theClass.getMethod("getId");
      Object result = getIdMethod.invoke(object);
      System.out.println("getId method result : " + result);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

  }

  public static void callAddHolidaysMethod(Object object, int holidays) {
    System.out.println("====Calling addHolidays method using reflection====");
    Class<?> theClass = object.getClass();
    try {
      Method addHolidays = theClass.getMethod("addHolidays", int.class);
      addHolidays.invoke(object, holidays);
      System.out.println("addHolidays method called ");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  public static void statWork(String workerTypeName, Object workerTarget) {
    try {
      Class<?> employeeWorkerClass = Class.forName(workerTypeName);

      Class<?> employeeTargetClass = workerTarget.getClass();
      Constructor<?> constructor = employeeWorkerClass.getConstructor(employeeTargetClass);
      Object worker = constructor.newInstance(workerTarget);
      Method doWork = employeeWorkerClass.getMethod("doWork");
      WorkHandler workHandler = employeeWorkerClass.getAnnotation(WorkHandler.class);
      if (workHandler != null && workHandler.useThreadPool()) {
        System.out.println("Thread Pool will be used to handle work");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
          @Override
          public void run() {
            try {
              doWork.invoke(worker);
            } catch (IllegalAccessException e) {
              e.printStackTrace();
            } catch (InvocationTargetException e) {
              e.printStackTrace();
            }
          }
        });
        executorService.shutdown();

      } else {
        doWork.invoke(worker);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
