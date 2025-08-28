package com.service.restaurantService.common.aplication.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface UseCase {
    String value() default "";
}