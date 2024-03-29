package lk.ijse.spring;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author : L.H.J
 * @File: WebAppInitializer
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String uploadDirectory = System.getProperty("java.io.tmpdir"); // Get the default temporary directory

        // Set up multipart configuration
        registration.setMultipartConfig(new MultipartConfigElement(uploadDirectory,
                1024*1024*10, // Max file size
                1024*1024*20, // Max request size
                1024*1024));  // File size threshold
    }
}
