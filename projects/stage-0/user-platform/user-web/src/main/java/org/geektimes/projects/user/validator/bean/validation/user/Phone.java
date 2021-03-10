package org.geektimes.projects.user.validator.bean.validation.user;

import org.geektimes.projects.user.validator.bean.validation.validator.UserPhoneAnnotationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 手机号
 *
 * @Author yang.hu
 * @Date 2021/3/10 17:19
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserPhoneAnnotationValidator.class)
public @interface Phone {

    Class<?>[] groups() default {};

    String regexp() default "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

    String message() default "";

    Class<? extends Payload>[] payload() default { };

}
