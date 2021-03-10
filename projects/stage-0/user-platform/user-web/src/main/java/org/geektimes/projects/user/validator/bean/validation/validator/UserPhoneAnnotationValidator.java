package org.geektimes.projects.user.validator.bean.validation.validator;

import org.geektimes.projects.user.validator.bean.validation.user.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class UserPhoneAnnotationValidator implements ConstraintValidator<Phone, CharSequence> {

    private Pattern pattern;

    @Override
    public void initialize(Phone annotation) {
        try {
            pattern = Pattern.compile(annotation.regexp());
        }
        catch ( PatternSyntaxException e ) {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        // 获取模板信息
        String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
        if (defaultConstraintMessageTemplate == null || defaultConstraintMessageTemplate.length() == 0) {
            context.buildConstraintViolationWithTemplate(String.format("手机号不正确")).
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
        }
        if ( value == null ) {
            return false;
        }
        Matcher m = pattern.matcher( value );
        return m.matches();
    }
}
