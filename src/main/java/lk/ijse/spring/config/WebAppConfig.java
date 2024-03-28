package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : L.H.J
 * @File: WebAppConfig
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.spring.api","lk.ijse.spring.advice"})
public class WebAppConfig{

}
