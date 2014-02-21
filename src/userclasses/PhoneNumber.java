/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

/**
 *
 * @author Godwin Agada
 */
class PhoneNumber {

    private String phoneNumber;
    private String displayName;
    
    public PhoneNumber(String phoneNumber, String displayName) {
        this.displayName = displayName;
        this.phoneNumber = phoneNumber;
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
    
}
