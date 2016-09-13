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
import javax.persistence.Lob;
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
@Table(name = "tbl_faculties")
@NamedQueries({
    @NamedQuery(name = "faculties.findAll", query = "SELECT f FROM faculties f"),
    @NamedQuery(name = "faculties.findByFacultyId", query = "SELECT f FROM faculties f WHERE f.facultyId = :facultyId")})
public class faculties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;
   
    @Column(name = "faculty_name")
    private String facultyName;

    public faculties() {
    }

    public faculties(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public faculties(Integer facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

}
