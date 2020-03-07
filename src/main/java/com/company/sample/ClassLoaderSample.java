package com.company.sample;

/**
 * Created by devoo-kim on 16. 10. 9.
 */
public class ClassLoaderSample {


    public static void main(String[] args){

    }

    public void simpleClassLoading() {
        ClassLoader classLoader = ClassLoaderSample.class.getClassLoader();

        try {
            Class aClass = classLoader.loadClass("com.jenkov.MyClass");
            System.out.println("aClass.getName() = " + aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
