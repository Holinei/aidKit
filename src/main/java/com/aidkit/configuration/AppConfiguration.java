package com.aidkit.configuration;

import com.aidkit.SessionObject;
import com.aidkit.dao.*;
import com.aidkit.dao.impl.*;
import com.aidkit.services.*;
import com.aidkit.services.impl.*;
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

    /*Beans for services*/
    @Bean
    public IAuthenticationService authenticationService(IUserDAO userDAO) {
        return new AuthenticationServiceImpl(userDAO);
    }

    @Bean
    public IUserService userService(IUserDAO userDAO) {
        return new UserServiceImpl(userDAO);
    }

    @Bean
    public IRegisterService registerService(IUserDAO userDAO) {
        return new RegisterServiceImpl(userDAO);
    }

    @Bean
    public IMedicineService medicineService(IMedicineDAO medicineDAO) {
        return new MedicineServiseImpl(medicineDAO);
    }

    @Bean
    public IPackageService packageService(IPackageDAO packageDAO) {
        return new PackageServiceImpl(packageDAO);
    }
    @Bean
    public IAidKitMedicineService aidKitMedicineService(IAidKitMedicineDAO aidKitMedicineDAO) {
        return new AidKitMedicineServiceImpl(aidKitMedicineDAO);
    }
    @Bean
    public IAidKitService aidKitService(IAidKitDAO aidKitDAO) {
        return new AidKitServiceImpl(aidKitDAO);
    }

    @Bean
    public IMemberShipService memberShipService(IMemberShipDAO memberShipDAO) {
        return new MemberShipServiceImpl(memberShipDAO);
    }

    /*Beans for DAO*/
    @Bean
    public IUserDAO userDAO(SessionFactory hibernateSessionFactory) {
        return new UserDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IMedicineDAO medicineDAO(SessionFactory hibernateSessionFactory) {
        return new MedicineDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IPackageDAO packageDAO(SessionFactory hibernateSessionFactory) {
        return new PackageDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IAidKitMedicineDAO aidKitMedicineDAO(SessionFactory hibernateSessionFactory) {
        return new AidKitMedicineDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IAidKitDAO aidKitDAO(SessionFactory hibernateSessionFactory) {
        return new AidKitDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IMemberShipDAO memberShipDAO(SessionFactory hibernateSessionFactory) {
        return new MemberShipDAOImpl(hibernateSessionFactory);
    }
}
