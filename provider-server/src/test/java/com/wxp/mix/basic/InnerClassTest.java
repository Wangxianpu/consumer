package com.wxp.mix.basic;

/**
 * @description: 内部类测试
 * @author: wxp
 * @time: 2022/4/14 9:35
 */
public class InnerClassTest {
    public static final String STATIC_STR = "static string";

    private String privateStr = "private String";

    public static String staticMethod(){
        return "static method";
    }

    public String getNormalStr(){
        return "normal method";
    }

    static class  InnerClass{
        String getOuterClassStr = staticMethod();

    }

    public String innerClassMethod( String paramStr){

        class MethodInnerClass{
            final String methodInnerClassField = paramStr;

            String getMethodInnerClassField(){
                return methodInnerClassField;
            }
        }
        return new MethodInnerClass().getMethodInnerClassField();
    }

    public static void main(String[] args) {
        System.out.println(new InnerClassTest().innerClassMethod("test str"));
    }
}
