package com.shsxt.crm.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;


@Configuration
public class TransactionConfig {

    //拦截面
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.xxxx.crm.service..*.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice(){
        DefaultTransactionAttribute txAttrRequired = new DefaultTransactionAttribute();
        txAttrRequired.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        //事务传播行为
        DefaultTransactionAttribute txAttrRequiredReadonly = new DefaultTransactionAttribute();
        txAttrRequiredReadonly.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttrRequiredReadonly.setReadOnly(true);
        NameMatchTransactionAttributeSource attributeSource = new NameMatchTransactionAttributeSource();
        attributeSource.addTransactionalMethod("add*",txAttrRequired);
        attributeSource.addTransactionalMethod("set*",txAttrRequired);
        attributeSource.addTransactionalMethod("save*",txAttrRequired);
        attributeSource.addTransactionalMethod("post*",txAttrRequired);
        attributeSource.addTransactionalMethod("insert*", txAttrRequired);
        //删
        attributeSource.addTransactionalMethod("delete*", txAttrRequired);
        //改
        attributeSource.addTransactionalMethod("update*",txAttrRequired);
        attributeSource.addTransactionalMethod("put*",txAttrRequired);
        //查
        attributeSource.addTransactionalMethod("get*",txAttrRequiredReadonly);
        attributeSource.addTransactionalMethod("find*",txAttrRequiredReadonly);
        attributeSource.addTransactionalMethod("query*",txAttrRequiredReadonly);
        attributeSource.addTransactionalMethod("count*",txAttrRequiredReadonly);
        attributeSource.addTransactionalMethod("select*",txAttrRequiredReadonly);
        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager,attributeSource);
        return txAdvice;
    }

    @Bean
    public Advisor txAdviceAdvisor(){
        //拦截切面
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);

        //将切面和拦截规则织入
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,txAdvice());
        return advisor;
    }
}
