package org.geektimes.projects.user.validator.bean.validation.user;

import org.geektimes.projects.user.validator.bean.validation.validator.UserPwdAnnotationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用户密码校验
 *
 * @Author yang.hu
 * @Date 2021/3/10 17:17
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserPwdAnnotationValidator.class)
public @interface Pwd {

    Class<?>[] groups() default { };

    int min() default 6;

    int max() default 32;

    String message() default "";

    Class<? extends Payload>[] payload() default { };

}
