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
@Table(name = "tbl_ebooks", catalog = "studentforum", schema = "")
@NamedQueries({
    @NamedQuery(name = "EBooks.findAll", query = "SELECT e FROM EBooks e"),
    @NamedQuery(name = "EBooks.findByEbookId", query = "SELECT e FROM EBooks e WHERE e.ebookId = :ebookId"),
    @NamedQuery(name = "EBooks.findByAddedDate", query = "SELECT e FROM EBooks e WHERE e.addedDate = :addedDate")})
public class EBooks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ebook_id")
    private Integer ebookId;
    @Column(name = "ebook_name")
    private String ebookName;
    @Column(name = "description")
    private String description;
    
    
    @Column(name = "location")
    private String location;
    @Column(name = "added_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    
    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    private Course course;
     
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    public EBooks() {
    }

    public EBooks(Integer ebookId) {
        this.ebookId = ebookId;
    }

    public EBooks(Integer ebookId, String ebookName, String location, Date addedDate) {
        this.ebookId = ebookId;
        this.ebookName = ebookName;
        this.location = location;
        this.addedDate = addedDate;
    }

    public Integer getEbookId() {
        return ebookId;
    }

    public void setEbookId(Integer ebookId) {
        this.ebookId = ebookId;
    }

    public String getEbookName() {
        return ebookName;
    }

    public void setEbookName(String ebookName) {
        this.ebookName = ebookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
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
