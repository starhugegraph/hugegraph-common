package com.baidu.hugegraph.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.CLASS)
public @interface GenerateLoggerFactory {

    String content();
}
