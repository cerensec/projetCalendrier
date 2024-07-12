package fr.esgi.calendrier.controller.rest;

import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.request.SaveUserRequest;
import jakarta.servlet.ServletContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ServletContextAware;

public abstract class AbstractGeneralController implements ServletContextAware {

    private ServletContext context;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }

    protected ServletContext getServletContext() {
        return this.context;
    }

    protected void saveToContext(String key, Object value) {
        this.context.setAttribute(key, value);
    }

    protected UserDto getUserInfo() {
        return (UserDto) this.context.getAttribute("user");
    }



}
