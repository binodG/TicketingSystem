/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.enitity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author BkoNod
 */
@Entity
@Table(name = "tbl_question", catalog = "studentforum", schema = "")
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findAllByDate", query = "SELECT q FROM Question q ORDER BY q.submittedDate Desc"),
    @NamedQuery(name = "Question.findByQuestionId", query = "SELECT q FROM Question q WHERE q.questionId = :questionId"),
    @NamedQuery(name = "Question.findByStatus", query = "SELECT q FROM Question q WHERE q.status = :status"),
    @NamedQuery(name = "Question.findBySubmittedDate", query = "SELECT q FROM Question q WHERE q.submittedDate = :submittedDate")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private Integer questionId;
    @Column(name = "title")
    private String title;
     @Column(name = "question")
    private String question;
    
    @Column(name = "status")
    private boolean status;
    @Column(name = "tags")
    private String tags;
    @Column(name = "submitted_date")
    @Temporal(TemporalType.TIMESTAMP)
     private Date submittedDate;
    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name="user_id")
     private User user;
    
   @Column(name = "no_of_answer")
    private int noOFanswer;
   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
     
      
    public Question() {
    }

    public Question(Integer questionId) {
        this.questionId = questionId;
    }

    public Question(Integer questionId, String title, boolean status, String tags, Date submittedDate) {
        this.questionId = questionId;
        this.title = title;
        this.status = status;
        this.tags = tags;
        this.submittedDate = submittedDate;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getNoOFanswer() {
        return noOFanswer;
    }

    public void setNoOFanswer(int noOFanswer) {
        this.noOFanswer = noOFanswer;
    }
    

    
}
