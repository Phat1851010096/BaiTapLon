/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtd.pojo;

/**
 *
 * @author dungm
 */
public class Author {
    private int authorID;
    private String authorName;

    /**
     * @return the authorID
     */
    public int getAuthorID() {
        return authorID;
    }

    /**
     * @param authorID the authorID to set
     */
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
