package com.beratyildirim.survey.faces;

import com.beratyildirim.survey.entities.Form;
import com.beratyildirim.survey.repositories.FormRepository;
import com.beratyildirim.survey.repositories.Impl.FormRepositoryImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class FormListBean {

    private List<Form> formList;

    public FormListBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        long surveyId = 0;
        if (request.getParameter("surveyId") != null) {
            surveyId = Long.parseLong(request.getParameter("surveyId"));

            FormRepository formRepository = new FormRepositoryImpl();
            formList = formRepository.findFormsBySurveyId(surveyId);
        }
    }

    public List<Form> getFormList() {
        return formList;
    }

    public void setFormList(List<Form> formList) {
        this.formList = formList;
    }

}
