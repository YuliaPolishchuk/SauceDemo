//package tests;
//
//import org.testng.IAnnotationTransformer;
//import org.testng.annotations.ITestAnnotation;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
//
//public class MyTransformer implements IAnnotationTransformer {
//    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//        if ("invoke".equals(testMethod.getName())) {
//            annotation.setInvocationCount(5);
//        }
//    }
//}

package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import tests.Retry;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Retry.class);
    }
}