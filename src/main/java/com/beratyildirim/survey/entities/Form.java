package com.beratyildirim.survey.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Form implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long formId;

    private String pollsterName;

    private String pollsterSurname;

    @ManyToOne
    @JoinColumn(name = "surveyId")
    private Survey survey;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Form() {
    }

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public String getPollsterName() {
        return pollsterName;
    }

    public void setPollsterName(String pollsterName) {
        this.pollsterName = pollsterName;
    }

    public String getPollsterSurname() {
        return pollsterSurname;
    }

    public void setPollsterSurname(String pollsterSurname) {
        this.pollsterSurname = pollsterSurname;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
