package com.wangdh.learner.base;

/**
 * 测试参数传递
 * Java参数，不管是原始类型还是引用类型，传递的都是副本(有另外一种说法是传值，但是说传副本更好理解吧，传值通常是相对传址而言)。
 如果参数类型是原始类型，那么传过来的就是这个参数的一个副本，也就是这个原始参数的值，这个跟之前所谈的传值是一样的。如果在函数中改变了副本的 值不会改变原始的值.
 如果参数类型是引用类型，那么传过来的就是这个引用参数的副本，这个副本存放的是参数的地址。如果在函数中没有改变这个副本的地址，而是改变了地址中的 值，那么在函数内的改变会影响到传入的参数。如果在函数中改变了副本的地址，如new一个，那么副本就指向了一个新的地址，此时传入的参数还是指向原来的 地址，所以不会改变参数的值。
 ( 对象包括对象引用即地址和对象的内容)

 a.传递值的数据类型：八种基本数据类型和String(这样理解可以，但是事实上String也是传递的地址,只是string对象和其他对 象是不同的，string对象是不能被改变的，内容改变就会产生新对象。那么StringBuffer就可以了，但只是改变其内容。不能改变外部变量所指 向的内存地址)。
 b.传递地址值的数据类型：除String以外的所有复合数据类型，包括数组、类和接口

 下面举例说明：
 在 Java 应用程序中永远不会传递对象，而只传递对象引用。因此是按引用传递对象。但重要的是要区分参数是如何传递的，这才是该节选的意图。Java 应用程序按引用传递对象这一事实并不意味着 Java 应用程序按引用传递参数。参数可以是对象引用，而 Java 应用程序是按值传递对象引用的。
 Java 应用程序中的变量可以为以下两种类型之一：引用类型或基本类型。当作为参数传递给一个方法时，处理这两种类型的方式是相同的。两种类型都是按值传递的；没有一种按引用传递。
 按 值传递意味着当将一个参数传递给一个函数时，函数接收的是原始值的一个副本。因此，如果函数修改了该参数，仅改变副本，而原始值保持不变。按引用传递意味 着当将一个参数传递给一个函数时，函数接收的是原始值的内存地址，而不是值的副本。因此，如果函数修改了该参数，调用代码中的原始值也随之改变。
 当传递给函数的参数不是引用时，传递的都是该值的一个副本（按值传递）。区别在于引用。在 C++ 中当传递给函数的参数是引用时，您传递的就是这个引用，或者内存地址（按引用传递）。在 Java 应用程序中，当对象引用是传递给方法的一个参数时，您传递的是该引用的一个副本（按值传递），而不是引用本身。
 Java 应用程序按值传递所有参数，这样就制作所有参数的副本，而不管它们的类型。
 */
public class ParamTestApp {
    public static  void main(String[] args){
        // 值传递，传递的是拷贝
        int param1 = 12;
        System.out.println(testValueParam(param1));
        System.out.println(param1);

        Student student = new Student();
        student.setAge(38);
        student.setName("wangdh");

        Student student1 = testReferenceParam(student);
        System.out.println(student1.toString());
        System.out.println(student.toString());
    }

    /**
     * 测试参数为值类型
     */
    private static int testValueParam(int age){
        age = 37;

        return  age;
    }

    /**
     * 测试参数为引用类型
     */
    private static Student testReferenceParam(Student student){
        student = new Student();
        student.setAge(26);
        student.setName("xiao wang");

        return  student;
    }
}
