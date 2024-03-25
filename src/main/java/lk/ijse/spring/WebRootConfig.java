package lk.ijse.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : L.H.J
 * @File: WebRootConfig
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/

@Configuration
@ComponentScan(basePackages = "lk.ijse.spring.service")
@EnableWebMvc
public class WebRootConfig {

}
