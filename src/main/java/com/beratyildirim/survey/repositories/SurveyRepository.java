package com.beratyildirim.survey.repositories;

import com.beratyildirim.survey.entities.Survey;
import java.util.List;

public interface SurveyRepository {

    List<Survey> getAllSurveys();

    public Survey findBySurveyId(long surveyId);

}
