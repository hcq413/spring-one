package com.hcq.xxx.Aop.v1.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class MyAspect {
    public void before(JoinPoint jp) {
        System.out.println("前置环绕中");
        String name = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        Object target = jp.getTarget();
        System.out.println("方法名:" + name + "参数列表:" + Arrays.toString(args) + "方法对象" + target.getClass().getSimpleName());
    }

    public void after(JoinPoint jp, Object value) {
        System.out.println("后置环绕中");
        String methodName = jp.getSignature().getName();  //获取被 拦截方法的方法名
        Object[] args = jp.getArgs(); //被 拦截方法的参数列表
        Object target = jp.getTarget();  //获取拦截的目标对象（业务对象）
        System.out.println("后置   方法名：" + methodName + ", 参数列表：" + Arrays.toString(args) + ", 拦截的目标对象：" + target + ", 返回值 ：" + value);
    }

    public  Object  around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("增强前置环绕中");
        String name = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        Object target = jp.getTarget();
        System.out.println("方法名:" + name + "参数列表:" + Arrays.toString(args) + "方法对象" + target.getClass().getSimpleName());
        Object proceed = jp.proceed();

        System.out.println("增强后置环绕中");
        String methodName = jp.getSignature().getName();  //获取被 拦截方法的方法名
        Object[] args1 = jp.getArgs(); //被 拦截方法的参数列表
        Object target1 = jp.getTarget();  //获取拦截的目标对象（业务对象）
        System.out.println("后置   方法名：" + methodName + ", 参数列表：" + Arrays.toString(args1) + ", 拦截的目标对象：" + target1+ ", 返回值 ：" + proceed);
        return proceed;
    }
}
