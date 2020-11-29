package com.java.util;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/10
 */
public class BeanValidatorUtils {
    /** 存放错误信息的properties数组 */
    public static final List<String> VALIDATION_MESSAGES = Arrays.asList("validationMessage");
    /** 错误消息分隔符 */
    public static final String SEPARATOR = "<br>";
    /**
     * 使用hibernate的注解来进行验证 .failFast(true)遇到错误立即报错
     */
    private static Validator validator = Validation.byProvider(HibernateValidator.class).configure()
            .messageInterpolator(
                    new ResourceBundleMessageInterpolator(new AggregateResourceBundleLocator(VALIDATION_MESSAGES)))
            .buildValidatorFactory().getValidator();

    /**
     * 调用JSR303的validate方法, 验证失败时返回错误信息列表
     *
     * @param bean
     *            要验证的JavaBean
     * @param groups
     *            验证分组
     * @return 错误信息列表
     */
    public static <T> List<String> validateListResult(T bean, Class<?>... groups) {
        List<String> errorMessages = new ArrayList<String>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean, groups);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<T> violation : constraintViolations) {
                errorMessages.add(violation.getMessage());
            }
        }
        return errorMessages;
    }

    /**
     * 调用JSR303的validate方法, 验证失败时返回错误信息Map
     *
     * @param bean
     *            要验证的JavaBean
     * @param groups
     *            验证分组
     * @return 错误信息列表
     */
    public static <T> Map<String, String> validateMapResult(T bean, Class<?>... groups) {
        Map<String, String> errorMessages = new HashMap<String, String>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean, groups);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<T> violation : constraintViolations) {
                errorMessages.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
        return errorMessages;
    }

/**
 * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException.
 *
 * @param errorList
 *            将错误信息List
 * @return 错误信息
 */
public static String validateListToString(List<String> errorList) {
    StringBuffer strBuffer = new StringBuffer();
    for (String error : errorList) {
        strBuffer.append(error);
        strBuffer.append(SEPARATOR);
    }
    return strBuffer.toString();
}


}
