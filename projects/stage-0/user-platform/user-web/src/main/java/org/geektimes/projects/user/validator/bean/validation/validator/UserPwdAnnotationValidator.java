package org.geektimes.projects.user.validator.bean.validation.validator;

import org.geektimes.projects.user.validator.bean.validation.user.Pwd;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserPwdAnnotationValidator implements ConstraintValidator<Pwd, CharSequence> {

    private int min;
    private int max;

    @Override
    public void initialize(Pwd annotation) {
        this.min = annotation.min();
        this.max = annotation.max();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        // 获取模板信息
        String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
        if (defaultConstraintMessageTemplate == null || defaultConstraintMessageTemplate.length() == 0) {
            context.buildConstraintViolationWithTemplate(String.format("密码必须在 %s - %s 之间", min, max)).
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
        }
        if ( value == null ) {
            return false;
        }
        int length = value.length();
        return length >= min && length <= max;
    }
}
