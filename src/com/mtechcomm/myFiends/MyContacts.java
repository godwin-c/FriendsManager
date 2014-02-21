/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtechcomm.myFiends;

/**
 *
 * @author Godwin Agada
 */
public class MyContacts {
    private String displayName;
    private String phoneNumber;
    private String birthday;
    private String weddingAnniversary;
    private String id;
    private String firstEncounter;

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the weddingAnniversary
     */
    public String getWeddingAnniversary() {
        return weddingAnniversary;
    }

    /**
     * @param weddingAnniversary the weddingAnniversary to set
     */
    public void setWeddingAnniversary(String weddingAnniversary) {
        this.weddingAnniversary = weddingAnniversary;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the firstEncounter
     */
    public String getFirstEncounter() {
        return firstEncounter;
    }

    /**
     * @param firstEncounter the firstEncounter to set
     */
    public void setFirstEncounter(String firstEncounter) {
        this.firstEncounter = firstEncounter;
    }
    
    public MyContacts(String displayName, String phone, String birthday, String firstEncounter, String weddingAnnvsry, String id){
        this.birthday = birthday;
        this.displayName = displayName;
        this.firstEncounter = firstEncounter;
        this.id = id;
        this.phoneNumber = phone;
        this.weddingAnniversary = weddingAnnvsry;
    }
}
