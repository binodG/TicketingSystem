/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.enitity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author BkoNod
 */
@Entity
@Table(name = "tbl_programme")
@NamedQueries({
    @NamedQuery(name = "Programme.findAll", query = "SELECT p FROM Programme p"),
    @NamedQuery(name = "Programme.findByProgrammeId", query = "SELECT p FROM Programme p WHERE p.programmeId = :programmeId")})
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programme_id")
    private Integer programmeId;
    
    @Column(name = "programme_name")
    private String programmeName;
    
    @Column(name = "type")
    private String programmeType;
    
    @Column(name = "year_semester")
    private int num;
    
    @ManyToOne(targetEntity = faculties.class)
    @JoinColumn(name = "faculty_id")
    private faculties faculty;


    public String getProgrammeType() {
        return programmeType;
    }

    public void setProgrammeType(String programmeType) {
        this.programmeType = programmeType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    
    public faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(faculties faculty) {
        this.faculty = faculty;
    }

    public Programme() {
    }

    public Programme(Integer programmeId) {
        this.programmeId = programmeId;
    }

    public Programme(Integer programmeId, String programmeName) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
    }

    public Integer getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(Integer programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    
}
