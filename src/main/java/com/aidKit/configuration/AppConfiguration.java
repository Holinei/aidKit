package com.aidKit.configuration;

import com.aidKit.SessionObject;
import com.aidKit.dao.IUserDAO;
import com.aidKit.dao.impl.UserDAOImpl;
import com.aidKit.services.IAuthenticationService;
import com.aidKit.services.impl.AuthenticationServiceImpl;
import com.aidKit.services.impl.UserServiceImpl;
import com.aidKit.services.IUserService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfiguration {

    @Bean
    public SessionFactory hibernateSessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }

    @Bean
    public IAuthenticationService authenticationService(IUserDAO userDAO) {
        return new AuthenticationServiceImpl(userDAO);
    }
    @Bean
    public IUserDAO userDAO(SessionFactory hibernateSessionFactory) {
        return new UserDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IUserService userService(IUserDAO userDAO) {
        return new UserServiceImpl(userDAO);
    }

}
