package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : L.H.J
 * @File: WebRootConfig
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/

@Configuration
@ComponentScan(basePackages = {"lk.ijse.spring.service","lk.ijse.spring.repositories"})
@EnableWebMvc
@Import({JPAConfig.class})
public class WebRootConfig {

}
