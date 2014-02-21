/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtechcomm.myFiends;

import com.codename1.io.Storage;

/**
 *
 * @author Godwin Agada
 */
public class GetDate extends Thread{

    private String date;
    private boolean finished = false;
    
    @Override
    public void run() {        
        Storage.getInstance().clearStorage();
        while (!finished) { 
            System.out.println("not finished");
            date = (String)Storage.getInstance().readObject("date");
            if (date != null && date.equals("4")) {
                System.out.println("You are there : "+date);
                finished = true;
            }
        }
    }
    
}
