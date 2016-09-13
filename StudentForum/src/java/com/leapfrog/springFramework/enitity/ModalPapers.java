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
@Table(name = "tbl_modalpapers", catalog = "studentforum", schema = "")
@NamedQueries({
    @NamedQuery(name = "ModalPapers.findAll", query = "SELECT m FROM ModalPapers m"),
    @NamedQuery(name = "ModalPapers.findByModalId", query = "SELECT m FROM ModalPapers m WHERE m.modalId = :modalId"),
    @NamedQuery(name = "ModalPapers.findByAddedDate", query = "SELECT m FROM ModalPapers m WHERE m.addedDate = :addedDate")})
public class ModalPapers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modal_id")
    private Integer modalId;
    @Column(name = "modal_name")
    private String modalName;
    @Column(name = "description")
    private String description;
    
    @Column(name = "added_date", insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "location")
    private String location;
     @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    private Course course;
     
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;


    public ModalPapers() {
    }

    public ModalPapers(Integer modalId) {
        this.modalId = modalId;
    }

    public ModalPapers(Integer modalId, String modalName, Date addedDate, String location) {
        this.modalId = modalId;
        this.modalName = modalName;
        this.addedDate = addedDate;
        this.location = location;
    }

    public Integer getModalId() {
        return modalId;
    }

    public void setModalId(Integer modalId) {
        this.modalId = modalId;
    }

    public String getModalName() {
        return modalName;
    }

    public void setModalName(String modalName) {
        this.modalName = modalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
