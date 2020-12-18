package net.cactusthorn.micro.db.jpahibernate.service;

import javax.inject.*;

import javax.persistence.*;

import net.cactusthorn.micro.db.jpahibernate.entity.Country;

@Singleton //
public class TestJPAService {

    private EntityManagerFactory factory;

    @Inject //
    public TestJPAService(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public String doSelect() {

        EntityManager entityManager = factory.createEntityManager();

        TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM country c where c.id=:id", Country.class);
        query.setParameter("id", 1);

        Country country = query.getSingleResult();

        return country.getAlpha3();
    }
}
