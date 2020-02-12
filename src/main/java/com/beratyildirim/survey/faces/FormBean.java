package com.beratyildirim.survey.faces;

import com.beratyildirim.survey.entities.Answer;
import com.beratyildirim.survey.entities.Form;
import com.beratyildirim.survey.entities.Question;
import com.beratyildirim.survey.entities.Survey;
import com.beratyildirim.survey.repositories.FormRepository;
import com.beratyildirim.survey.repositories.Impl.FormRepositoryImpl;
import com.beratyildirim.survey.repositories.Impl.SurveyRepositoryImpl;
import com.beratyildirim.survey.repositories.SurveyRepository;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class FormBean {

    private Form form;

    private long surveyId;

    public FormBean() {

        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        long formId = 0;
        if (request.getParameter("formId") != null) {
            formId = Long.parseLong(request.getParameter("formId"));
        }
        if (formId == 0) {
            form = new Form();
            if (request.getParameter("surveyId") != null) {
                surveyId = Long.parseLong(request.getParameter("surveyId"));

                //System.out.println("surveyId = " + surveyId);
                SurveyRepository surveyRepository = new SurveyRepositoryImpl();
                Survey survey = surveyRepository.findBySurveyId(surveyId);
                form.setSurvey(survey);
                form.setAnswers(new ArrayList<Answer>());
                for (Question question : survey.getQuestions()) {
                    Answer answer = new Answer();
                    answer.setQuestion(question);
                    answer.setForm(form);
                    form.getAnswers().add(answer);
                }
            }
        } else {
            FormRepository formRepository = new FormRepositoryImpl();
            form = formRepository.findByFormId(formId);
        }

    }

    public void save() {

        System.out.println("surveyId = " + surveyId);

        FormRepository formRepository = new FormRepositoryImpl();
        formRepository.saveForm(form);
    }

    public void delete() {
        long formId = getForm().getFormId();
        System.out.println("formId = " + formId);
        FormRepository formRepository = new FormRepositoryImpl();
        formRepository.deleteForm(formId);

    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

}
