package com.enzo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * ClassName: JavaConfigurationA
 * Package: com.enzo.config
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/19 14:58
 * @Version 1.0
 */

@Import(value = JavaConfigurationB.class)
@Configuration
public class JavaConfigurationA {
}
