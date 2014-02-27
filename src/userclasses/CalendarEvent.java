/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.codename1.system.NativeInterface;
/**
 *
 * @author LANREWAJU
 */
public interface CalendarEvent extends NativeInterface{
    public void executeCalendar();
    public String setMyReminder(int yearInt, int monthInt, int dayInt, String comment, String title);
    public boolean isSupported();
}
