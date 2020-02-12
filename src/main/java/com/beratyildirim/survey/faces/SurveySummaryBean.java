package com.beratyildirim.survey.faces;

import com.beratyildirim.survey.entities.Survey;
import com.beratyildirim.survey.repositories.Impl.SurveyRepositoryImpl;
import com.beratyildirim.survey.repositories.SurveyRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SurveySummaryBean {

    private List<Survey> surveyList;

    public SurveySummaryBean() throws Exception {
        SurveyRepository surveyRepository = new SurveyRepositoryImpl();
        surveyList = surveyRepository.getAllSurveys();
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }

    public void setSurveyList(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

}
