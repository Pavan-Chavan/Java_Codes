// Title:- Demonstate Example of multiple inheritance
// Name of coder:- Pavan Chavan
// Email:- pavan.21920161@viit.ac.in

import java.lang.System;
// interitance of a class from class and interface
class PClass{
    void method1(int x)
    {
        System.out.println("====From Method 1 of PClass====");
        System.out.println("Value of interger :"+x);
    }
}
interface InterfaceTest1{
    public abstract void method2(int x);
}
class CClass1 extends PClass implements InterfaceTest1{

    @Override
    public void method2(int x) {
        System.out.println("====From method 2 of InterfaceTest1====");
        System.out.println("Value of Integer:"+x);        
    }
    void method3(int x)
    {
        System.out.println("====From method 3 of CClass====");
        System.out.println("Value of Integer:"+x);  
    }
}
// interitance of a class from more than one interface
interface InterfaceTest2{
    public abstract void method4(int x);
}
class CClass2 implements InterfaceTest1,InterfaceTest2{

    @Override
    public void method2(int x) {
        System.out.println("====From method 2 of CClass implements from Itest1 and Itest2====");
        System.out.println("Value of Integer:"+x);
    }

    @Override
    public void method4(int x) {
        System.out.println("====From method 4 of CClass implements from Itest1 and Itest2====");
        System.out.println("Value of Integer:"+x);
    }
    void method6(int x){
        System.out.println("====From method 4 of CClass implements from Itest1 and Itest2====");
        System.out.println("Value of Integer:"+x);
    }

}
//inheritance of interface from multiple interfaces
interface InterfaceTest3 extends InterfaceTest1,InterfaceTest2{
    public abstract void method5(int x);
}
class CClass3 implements InterfaceTest3{

    @Override
    public void method5(int x) {
        System.out.println("====From method 5 of CClass implements from Itest1 and Itest2====");
        System.out.println("Value of Integer:"+x);
    }
    @Override
    public void method4(int x) {
        System.out.println("====From method 4 of CClass implements from Itest1 and Itest2====");
        System.out.println("Value of Integer:"+x);
    }
    @Override
    public void method2(int x) {
        System.out.println("====From method 2 of CClass implements from Itest1 and Itest2====");
        System.out.println("Value of Integer:"+x);
    }
}
class DemoOfMultipleInheritance{

    public static void main(String[] args) {

        // Creating object for class which is inherited from class and inteface
        CClass1 type1 = new CClass1();
        type1.method1(10);
        type1.method2(20);
        type1.method3(30);

        // Creating object for class which is inherited from more than one inteface
        CClass2 type2 = new CClass2();
        type2.method2(40);
        type2.method4(50);
        type2.method6(60);

        // Creating object for interface implemeted class which is inherited from more than one inteface
        CClass3 type3 = new CClass3();
        type3.method2(70);
        type3.method4(80);
        type3.method5(90);
    }
}