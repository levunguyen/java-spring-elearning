package elearning.demo.config;

import org.springframework.lang.Nullable;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //specifies the configuration classes should be loaded for the Spring infrastructure
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //specifies the configurations depend on Servlet specification, esp, web mvc related configurations
    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    //the Spring DispatchServlet mapping URL pattern
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // those Web Filters will be applied on the Spring DispatchServlet
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        return new Filter[] { encodingFilter };
    }

}
