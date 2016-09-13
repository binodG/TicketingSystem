/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO;

import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author BkoNod
 */
public interface FileHandlerDAO {
    String uploadFile(String title,String name,MultipartFile file);
    String uploadImage(MultipartFile file);
}
