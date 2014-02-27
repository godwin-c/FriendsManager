package userclasses;

import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.content.*;
import android.net.Uri;
import android.widget.Toast;
import android.app.Activity;
import java.util.TimeZone;
import com.mtechcomm.myFiends.MyFriendsManager;
import java.util.Calendar;

public class CalendarEventImpl {
    //public static Context context;
    public void executeCalendar() {
        Calendar beginTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        com.codename1.impl.android.CodenameOneActivity ctx = (com.codename1.impl.android.CodenameOneActivity) MyFriendsManager.getContext();
        android.content.Intent intent = new android.content.Intent(Intent.ACTION_EDIT);
//        intent.setClassName("com.android.calendar","com.android.calendar.LaunchActivity");
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        intent.putExtra(Events.DESCRIPTION, "<a href=\"www.google.com\">More</a>");
        //ctx.startActivity(intent);
    }

public String setMyReminder(int yearInt, int monthInt, int dayInt, String comment, String title) {
         
         final Activity activity = com.codename1.impl.android.AndroidNativeUtil.getActivity();       
         long startMillis = 0;
         long endMillis = 0;
         Calendar beginTime = Calendar.getInstance();
         beginTime.set(yearInt, monthInt, dayInt, 7, 30);
         startMillis = beginTime.getTimeInMillis();
         Calendar endTime = Calendar.getInstance();
         endTime.set(yearInt, monthInt, dayInt, 8, 45);
         endMillis = endTime.getTimeInMillis();

        ContentResolver cr = activity.getContentResolver();
        
         ContentValues values = new ContentValues();
         values.put(Events.DTSTART, startMillis);
         values.put(Events.DTEND, endMillis);
         values.put(Events.TITLE, title);
         values.put(Events.DESCRIPTION, comment);
         values.put(Events.CALENDAR_ID, 1);
         values.put(Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
         Uri uri = cr.insert(Events.CONTENT_URI, values);

         // get the event ID that is the last element in the Uri
         long eventID = Long.parseLong(uri.getLastPathSegment());

         //Toast.makeText(activity , "Event ID = "+eventID, 5000).show();
         return String.valueOf(eventID);
     }

    public boolean isSupported() {
        return true;
    }
}
