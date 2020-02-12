package com.beratyildirim.survey.repositories;

import com.beratyildirim.survey.entities.Form;
import java.util.List;

public interface FormRepository {

    public void saveForm(Form form);

    public void deleteForm(long formId);

    public Form findByFormId(long formId);

    List<Form> findFormsBySurveyId(long surveyId);

}
