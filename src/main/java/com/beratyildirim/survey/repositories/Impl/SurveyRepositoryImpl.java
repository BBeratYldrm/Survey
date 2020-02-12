package com.beratyildirim.survey.repositories.Impl;

import com.beratyildirim.survey.entities.Survey;
import com.beratyildirim.survey.repositories.SurveyRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SurveyRepositoryImpl implements SurveyRepository {

    public EntityManager entityManager;

    public SurveyRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SurveyProjectPu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Survey> getAllSurveys() {
        return entityManager.createQuery("SELECT s FROM Survey s", Survey.class).getResultList();
    }

    @Override
    public Survey findBySurveyId(long surveyId) {
        return entityManager.find(Survey.class, surveyId);
    }

}
