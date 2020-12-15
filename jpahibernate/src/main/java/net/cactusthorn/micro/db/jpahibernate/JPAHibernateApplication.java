package net.cactusthorn.micro.db.jpahibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.db.jpahibernate.dagger.*;
import net.cactusthorn.micro.db.jpahibernate.service.TestJPAService;

public class JPAHibernateApplication {

    private static final Logger LOG = LoggerFactory.getLogger(JPAHibernateApplication.class);

    public static void main(String... args) {

        JPAHibernateComponent component = DaggerJPAHibernateComponent.create();

        TestJPAService testJPAService = component.testJPAService();

        String x = testJPAService.doSelect();
        LOG.info("Result: {}", x);
    }
}
