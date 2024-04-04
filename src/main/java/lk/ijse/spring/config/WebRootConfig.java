package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 * @author : L.H.J
 * @File: WebRootConfig
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/

@Configuration
@ComponentScan(basePackages = {"lk.ijse.spring.service","lk.ijse.spring.repositories"} , basePackageClasses = Transformer.class)

@EnableWebMvc
@Import({JPAConfig.class})
@PropertySource("classpath:application.properties")
public class WebRootConfig {

}
