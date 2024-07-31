package com.fan.javaee.base;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/18
 */
public class InnerClassTest {
    
    public static String var1;
    
    protected static class A{
        public void f1(){
            System.out.println("f1");
        }
    }
    
    protected class B{
        public void f1(){
            System.out.println("B.f1");
        }
    }
    

    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}

class OuterClassTest{
    public static void main(String[] args) {
        InnerClassTest.var1 = "sdf";
        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.main(new String[]{});
        innerClassTest.var1 = "1";
        InnerClassTest.A a = new InnerClassTest.A();

        InnerClassTest.B b = innerClassTest.new B();
        b.f1();
    }
}
