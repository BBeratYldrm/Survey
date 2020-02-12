package com.beratyildirim.survey.repositories.Impl;

import com.beratyildirim.survey.entities.Form;
import com.beratyildirim.survey.repositories.FormRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormRepositoryImpl implements FormRepository {

    public EntityManager entityManager;

    public FormRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SurveyProjectPu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void saveForm(Form form) {
        entityManager.getTransaction().begin();
        entityManager.persist(form);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteForm(long formId) {
        entityManager.getTransaction().begin();
        Form deletedForm = entityManager.getReference(Form.class, formId);
        entityManager.remove(deletedForm);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Form findByFormId(long formId) {
        return entityManager.find(Form.class, formId);
    }

    @Override
    public List<Form> findFormsBySurveyId(long surveyId) {
        return entityManager
                .createQuery("SELECT f FROM Form f WHERE f.survey.surveyId = :surveyId")
                .setParameter("surveyId", surveyId)
                .getResultList();
    }

}
