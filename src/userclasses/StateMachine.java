/**
 * Your application code goes here
 */
package userclasses;

import com.codename1.contacts.Contact;
import com.codename1.contacts.ContactsModel;
import com.codename1.io.Storage;
import com.codename1.system.NativeLookup;
import generated.StateMachineBase;
import com.codename1.ui.*;
import com.codename1.ui.events.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.spinner.DateSpinner;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.mtechcomm.myFiends.MyContacts;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

    Image first;
    Image second;
    Image third;
    private Resources theme;
    private int conNumber = 0;
    Vector<Hashtable> storedContacts;
    boolean found;
    MyContacts myContact;
    CalendarEvent calenderEvent;
    //CalendarEventImpl eventImpl;
    String customEvent;
    Vector<Hashtable> events = new Vector<Hashtable>();
    private Vector<Hashtable> allEvents;

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    /**
     * this method should be used to initialize variables instead of the
     * constructor/class scope to avoid race conditions
     */
    @Override
    protected void initVars(Resources res) {

        InputStream imagestream;
        try {
            imagestream = Display.getInstance().getResourceAsStream(this.getClass(), "/first.png");
            first = Image.createImage(imagestream);
        } catch (Exception e) {
        }

        try {
            imagestream = Display.getInstance().getResourceAsStream(this.getClass(), "/second.png");
            second = Image.createImage(imagestream);
        } catch (Exception e) {
        }

        try {
            imagestream = Display.getInstance().getResourceAsStream(this.getClass(), "/third.png");
            third = Image.createImage(imagestream);
        } catch (Exception e) {
        }


//        UIManager.getInstance().getLookAndFeel().setMenuBarClass(SideMenuBar.class);
//        Display.getInstance().setCommandBehavior(Display.COMMAND_BEHAVIOR_SIDE_NAVIGATION);
    }

    @Override
    protected boolean processBackground(Form f) {
        return super.processBackground(f); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void beforeMain(Form f) {
        //     Storage.getInstance().clearStorage();
        //conNumber= 0;
//        Display.getInstance().scheduleBackgroundTask(new Runnable() {
//
//            public void run() {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                if (conNumber == 4) {         
//                 
//                    Dialog.show("Here", "You are there", "OK", null);
//                    
//                }
//            }
//        });
//        String[] contactsId = ContactsManager.getAllContactsWithNumbers();
//        for (int i = 0; i < contactsId.length; i++) {
//            String string = contactsId[i];
//            System.out.println("Component : " + string);
//        }


        f.getTitleArea().setUIID("anodaTitle");

        if (Storage.getInstance().exists("RMcontacts")) {
            storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
        } else {
            storedContacts = new Vector<Hashtable>();
        }

        //Command one = new Command("List All", first.scaledWidth(Display.getInstance().getDisplayWidth() / 6));
        //Command one = new Command("List All");   

//       Label l1 = new Label("ACTIONS") {
//
//            @Override
//            public void paint(Graphics g) {
//                super.paint(g);
//                g.drawLine(getX(), getY() + getHeight() - 1, getX() + getWidth(), getY() + getHeight() - 1);
//            }
//        };
//        l1.setUIID("Separator");
//        one.putClientProperty("SideComponent", l1);
//        one.putClientProperty("uiid", "newTitle");
//        one.putClientProperty("iconGap", new Integer(20));
//        f.addCommand(one);

//        Label l2 = new Label("FAVORITES") {
//            @Override
//            public void paint(Graphics g) {
//                super.paint(g);
//                g.drawLine(getX(), getY() + getHeight() - 1, getX() + getWidth(), getY() + getHeight() - 1);
//            }
//        };
//        l2.setUIID("seperator");
//        three.putClientProperty("SideComponent", l2);
//        Command two = new Command("Get All", second.scaledWidth(Display.getInstance().getDisplayWidth() / 6));
//        two.putClientProperty("uiid", "newTitle");
//        two.putClientProperty("iconGap", new Integer(20));
//        f.addCommand(two);
//
        Command done = new Command("Done") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (storedContacts == null || storedContacts.isEmpty()) {
                    Dialog.show("Done?", "You have not selected any numbers", "OK", null);
                } else {
                    showForm("SelectedContacts", null);
                }
            }
        };
        Command eventsToday = new Command("Today's Event") {
            @Override
            public void actionPerformed(ActionEvent evt) {
//                if (storedContacts == null || storedContacts.isEmpty()) {
//                    Dialog.show("Done?", "You have not selected any numbers", "OK", null);
//                } else {
//                    showForm("SelectedContacts", null);
//                }
                showForm("EventsToday", null);
            }
        };
        done.putClientProperty("uiid", "newTitle");
        done.putClientProperty("iconGap", new Integer(20));
        f.addCommand(done);
        f.addCommand(eventsToday);


    }

    @Override
    protected boolean initListModelMultiList(List cmp) {
//        String[] contactsId = ContactsManager.getAllContactsWithNumbers();
//        cmp.setModel(new ContactsModel(contactsId));
        String[] st = Display.getInstance().getAllContacts(true);
        cmp.setModel(new ContactsModel(st));

        return true;
    }

    private void loadPIMContact() {
        try {
            String[] phoneContacts = Display.getInstance().getAllContacts(true);
            for (int i = 0; i < phoneContacts.length; i++) {
                Contact contact = Display.getInstance().getContactById(phoneContacts[i]);
                Enumeration phoneNumbers = contact.getPhoneNumbers().elements();
                while (phoneNumbers.hasMoreElements()) {
                    String phoneNumber = phoneNumbers.nextElement().toString();
                    if (phoneNumber.length() < 11) {
                        continue;
                    }
                    addItem(new PhoneNumber(phoneNumber, contact.getDisplayName()));
                }
            }
        } catch (Exception xcp) {
            System.out.println(xcp.getMessage());
        }
    }

    @Override
    protected void onMain_MultiListAction(Component c, ActionEvent event) {
        found = false;
        List list = (List) c;
        final Hashtable h = (Hashtable) list.getSelectedItem();
        System.out.println("The List : " + h.toString());
        conNumber = list.getSelectedIndex();

        final Hashtable<String, String> h2 = new Hashtable<String, String>();
        h2.put("id", (String) h.get("id"));
        h2.put("displayName", (String) h.get("displayName"));
        h2.put("phone", (String) h.get("phone"));
        h2.put("birthday", "none");
        h2.put("weddingAnniversary", "none");
        h2.put("firstEncounter", "none");

        Command[] cmds = new Command[2];
        cmds[0] = new Command("Yes") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!storedContacts.isEmpty()) {
                    //System.out.println("H2 :" + h2.toString());
                    for (int i = 0; i < storedContacts.size(); i++) {
                        Hashtable hashtable = storedContacts.elementAt(i);
                        String id = hashtable.get("id").toString();
                        System.out.println("The Hashtable ID " + id);
                        if (id.equals(h.get("id"))) {
                            System.out.println("The H2 ID " + h.get("id"));
                            found = true;
                            break;
                        }
                    }

                }

                if (found) {
                    Dialog.show("Looks like", h.get("displayName").toString() + " has already been added", "OK", null);
                } else {
                    storedContacts.add(h2);
                    Storage.getInstance().writeObject("RMcontacts", storedContacts);
                    System.out.println("Stored contacts ::: " + storedContacts.toString());

                    if (Display.getInstance().getCurrent() instanceof Dialog) {
                        ((Dialog) Display.getInstance().getCurrent()).dispose();
                    }
                    Dialog.show("Good", h.get("displayName").toString() + " added", "OK", null);
                }

            }
        };
        cmds[1] = new Command("No") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        };
        TextArea txt = new TextArea("Do you want to add " + h.get("displayName") + "?");
        txt.setEditable(false);
        Dialog.show("Add contact", txt, cmds);


    }

    private void addItem(PhoneNumber phoneNumber) {
    }

    @Override
    protected void beforeSplashScreen(Form f) {
        f.getTitleArea().setUIID("anodaTitle");
    }

    @Override
    protected void beforeSelectedContacts(final Form f) {
        f.getTitleArea().setUIID("anodaTitle");
        storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
        findStoredContactsMultiList(f).setModel(new DefaultListModel(storedContacts));
        findStoredContactsMultiList(f).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                List l = (List) findStoredContactsMultiList(f);
                Hashtable h = (Hashtable) l.getSelectedItem();
                System.out.println("Selected contacts :::::::::: " + h.toString());
                myContact = new MyContacts((String) h.get("displayName"), (String) h.get("phone"), (String) h.get("birthday"), (String) h.get("firstEncounter"), (String) h.get("weddingAnniversary"), (String) h.get("id"));
                showForm("EachContact", null);
            }
        });

    }

    @Override
    protected void beforeEachContact(Form f) {
        f.getTitleArea().setUIID("anodaTitle");
        Image icon = fetchResourceFile().getImage("phoneIcon.png");
        findPhoneIcon(f).setIcon(icon.scaledWidth(Display.getInstance().getDisplayWidth() / 7));
        findPhoneIcon(f).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().dial(myContact.getPhoneNumber());
            }
        });
//         Label l = new Label("") {
//
//            @Override
//            public void paint(Graphics g) {
//                super.paint(g);
//                g.drawLine(getX(), getY() + getHeight() - 1, getX() + getWidth(), getY() + getHeight() - 1);
//            }
//        };
        f.setTitle(myContact.getDisplayName());
        findPhoneNumberLabel(f).setText(myContact.getPhoneNumber());

        if (Storage.getInstance().exists("CustomEvent")) {
            System.out.println("storage ====== " + Storage.getInstance().readObject("CustomEvent"));
            events = (Vector<Hashtable>) Storage.getInstance().readObject("CustomEvent");
            Hashtable eventHash = new Hashtable();
            boolean eventAdded = false;
            System.out.println("custom events " + events);
            System.out.println("size of event " + events.size() + " " + events);
            for (int i = 0; i < events.size(); i++) {
                eventHash = events.elementAt(i);
                System.out.println(i + " Hash id is " + eventHash.get("id") + " and my contact id  is  " + myContact.getId());
                if (eventHash.get("id").equals(myContact.getId())) {
                    //     eventAdded = true;
                    System.out.println("found " + eventHash.get("id"));
                    Button b = new Button(eventHash.get("event").toString());
                    b.setUIID("Separator");

                    findContainer4(f).addComponent(3, b);
                }
            }
//            if (eventAdded) {
//                System.out.println("found");
//                Button b = new Button(eventHash.get("event").toString());
//                b.setUIID("Separator");
//                findContainer4(f).addComponent(3, b);
//            }



        }
    }

    @Override
    protected void onEachContact_BirthdayButtonAction(Component c, ActionEvent event) {
        final DateSpinner ds = new DateSpinner();

        if (!"none".equals(myContact.getBirthday())) {
            Vector<String> string = (Vector<String>) StringUtil.tokenize(myContact.getBirthday(), "/");
            ds.setCurrentDay(Integer.parseInt(string.elementAt(0)));
            ds.setCurrentMonth(Integer.parseInt(string.elementAt(1)));
            ds.setCurrentYear(Integer.parseInt(string.elementAt(2)));
        }
        Dialog dlg = new Dialog("Birthday");
        Container cnt = new Container(new BorderLayout());
        Button btn = new Button("OK");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String bDay = ds.getCurrentDay() + "/" + ds.getCurrentMonth() + "/" + ds.getCurrentYear();
                System.out.println("Date : " + ds.getCurrentDay() + " / " + ds.getCurrentMonth() + " / " + ds.getCurrentYear());
                storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
                Hashtable h = new Hashtable();
                String position = "none";
                for (int i = 0; i < storedContacts.size(); i++) {
                    Hashtable hashtable = storedContacts.elementAt(i);
                    if (hashtable.get("id").toString().equals(myContact.getId())) {
                        position = String.valueOf(i);
                        h.put("displayName", hashtable.get("displayName"));
                        h.put("phone", hashtable.get("phone"));
                        h.put("id", hashtable.get("id"));
                        h.put("birthday", bDay);
                        h.put("weddingAnniversary", hashtable.get("weddingAnniversary"));
                        h.put("firstEncounter", hashtable.get("firstEncounter"));

                        System.out.println("The stored contCTS : " + storedContacts);
                        //break;
                    }
                }
                if (!"none".equals(position)) {
                    storedContacts.removeElementAt(Integer.parseInt(position));
                    storedContacts.add(Integer.parseInt(position), h);
                    Storage.getInstance().writeObject("RMcontacts", storedContacts);
                    try {
                        final CalendarEvent ntc = (CalendarEvent) NativeLookup.create(CalendarEvent.class);
                        if (ntc != null && ntc.isSupported()) {
                            new Thread() {
                                @Override
                                public void run() {

                                    String string = ntc.setMyReminder(ds.getCurrentYear(), ds.getCurrentMonth(), ds.getCurrentDay(), "A test Birthday", "Agada's Birthday");
                                    //System.out.println("Id returned is +++++ "+string);
                                    Dialog.show("Success", "An event has been created with an ID : "+string, "OK", null);
                                }
                            }.start();
                        } else {
                            Dialog.show("Native interface", "a feature not supported", "OK", null);
                        }
                    } catch (Exception e) {
                        Dialog.show("Error", e.getMessage(), "OK", null);
                    }

                }
                storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
                myContact.setBirthday(bDay);
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });
        Button btn1 = new Button("Cancel");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });
        Container cnt1 = new Container(new GridLayout(1, 2));
        cnt1.addComponent(btn1);
        cnt1.addComponent(btn);
        cnt.addComponent(BorderLayout.CENTER, ds);
        cnt.addComponent(BorderLayout.SOUTH, cnt1);
        dlg.addComponent(cnt);
        dlg.show();
    }

    @Override
    protected void onEachContact_AnniversaryButtonAction(Component c, ActionEvent event) {
        final DateSpinner ds = new DateSpinner();
        Dialog dlg = new Dialog("Wedding Anniversary");
        Container cnt = new Container(new BorderLayout());

        Button btn = new Button("OK");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String waDay = ds.getCurrentDay() + "/" + ds.getCurrentMonth() + "/" + ds.getCurrentYear();
                System.out.println("Date : " + ds.getCurrentDay() + " / " + ds.getCurrentMonth() + " / " + ds.getCurrentYear());
                String position = "none";
                storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
                Hashtable h = new Hashtable();
                for (int i = 0; i < storedContacts.size(); i++) {
                    Hashtable hashtable = storedContacts.elementAt(i);
                    if (hashtable.get("id").toString().equals(myContact.getId())) {
                        position = String.valueOf(i);
                        h.put("displayName", hashtable.get("displayName"));
                        h.put("phone", hashtable.get("phone"));
                        h.put("id", hashtable.get("id"));
                        h.put("birthday", hashtable.get("birthday"));
                        h.put("weddingAnniversary", waDay);
                        h.put("firstEncounter", hashtable.get("firstEncounter"));
                        //   storedContacts.removeElementAt(i);
                        // storedContacts.add(h);
                        System.out.println("The stored contCTS : " + storedContacts);

                        // break;
                    }
                }
                if (!"none".equals(position)) {
                    storedContacts.removeElementAt(Integer.parseInt(position));
                    storedContacts.add(Integer.parseInt(position), h);
                    Storage.getInstance().writeObject("RMcontacts", storedContacts);
                }
                storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
                myContact.setWeddingAnniversary(waDay);
                System.out.println("=========================");
                System.out.println(" Storage instance" + Storage.getInstance().readObject("RMContacts"));
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });
        Button btn1 = new Button("Cancel");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });
        Container cnt1 = new Container(new GridLayout(1, 2));
        cnt1.addComponent(btn1);
        cnt1.addComponent(btn);
        cnt.addComponent(BorderLayout.CENTER, ds);
        cnt.addComponent(BorderLayout.SOUTH, cnt1);
        dlg.addComponent(cnt);
        if (!"none".equals(myContact.getWeddingAnniversary())) {
            Vector<String> string = (Vector<String>) StringUtil.tokenize(myContact.getWeddingAnniversary(), "/");
            ds.setCurrentDay(Integer.parseInt(string.elementAt(0)));
            ds.setCurrentMonth(Integer.parseInt(string.elementAt(1)));
            ds.setCurrentYear(Integer.parseInt(string.elementAt(2)));
        }
        dlg.show();
    }

    @Override
    protected void onEachContact_EncounterButtonAction(Component c, ActionEvent event) {
        final DateSpinner ds = new DateSpinner();
        Dialog dlg = new Dialog("First Encounter");
        Container cnt = new Container(new BorderLayout());
        Button btn = new Button("OK");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String fcontact = ds.getCurrentDay() + "/" + ds.getCurrentMonth() + "/" + ds.getCurrentYear();
                System.out.println("Date : " + ds.getCurrentDay() + " / " + ds.getCurrentMonth() + " / " + ds.getCurrentYear());
                storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
                String position = "none";
                Hashtable h = new Hashtable();
                for (int i = 0; i < storedContacts.size(); i++) {
                    Hashtable hashtable = storedContacts.elementAt(i);
                    if (hashtable.get("id").toString().equals(myContact.getId())) {
                        position = String.valueOf(i);
                        h.put("displayName", hashtable.get("displayName"));
                        h.put("phone", hashtable.get("phone"));
                        h.put("id", hashtable.get("id"));
                        h.put("birthday", hashtable.get("birthday"));
                        h.put("weddingAnniversary", hashtable.get("weddingAnniversary"));
                        h.put("firstEncounter", fcontact);
                        // storedContacts.removeElementAt(i);
                        //storedContacts.add(h);
                        System.out.println("The stored contCTS : " + storedContacts);
                        //  Storage.getInstance().writeObject("RMContacts", storedContacts);
                        // break;
                    }
                }
                if (!"none".equals(position)) {
                    storedContacts.removeElementAt(Integer.parseInt(position));
                    storedContacts.add(Integer.parseInt(position), h);
                    Storage.getInstance().writeObject("RMcontacts", storedContacts);
                }
                storedContacts = (Vector<Hashtable>) Storage.getInstance().readObject("RMcontacts");
                myContact.setFirstEncounter(fcontact);
                System.out.println("=========================");
                System.out.println(" Storage instance" + Storage.getInstance().readObject("RMContacts"));
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });
        Button btn1 = new Button("Cancel");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });
        Container cnt1 = new Container(new GridLayout(1, 2));
        cnt1.addComponent(btn1);
        cnt1.addComponent(btn);
        cnt.addComponent(BorderLayout.CENTER, ds);
        cnt.addComponent(BorderLayout.SOUTH, cnt1);
        dlg.addComponent(cnt);

        if (!"none".equals(myContact.getFirstEncounter())) {
            Vector<String> string = (Vector<String>) StringUtil.tokenize(myContact.getFirstEncounter(), "/");
            ds.setCurrentDay(Integer.parseInt(String.valueOf(string.elementAt(0))));
            ds.setCurrentMonth(Integer.parseInt(string.elementAt(1)));
            ds.setCurrentYear(Integer.parseInt(string.elementAt(2)));
        }
        dlg.show();
    }

    @Override
    protected void onEachContact_CustomButtonAction(final Component c, ActionEvent event) {
        final DateSpinner ds = new DateSpinner();
        Dialog dlg = new Dialog("Custom event");
        final Container cnt = new Container(new BorderLayout());
        final TextField tf = new TextField();
        Button btn = new Button("OK");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Vector events = new Vector();
                Hashtable event = new Hashtable();
                String eventDay = ds.getCurrentDay() + " / " + ds.getCurrentMonth() + " / " + ds.getCurrentYear();
                System.out.println("Date : " + ds.getCurrentDay() + " / " + ds.getCurrentMonth() + " / " + ds.getCurrentYear());
                customEvent = tf.getText();
                event.put("id", myContact.getId());
                event.put("event", customEvent);
                event.put("date", eventDay);
                if (Storage.getInstance().exists("CustomEvent")) {
                    events = (Vector<Hashtable>) Storage.getInstance().readObject("CustomEvent");
                    events.add(event);
                    Storage.getInstance().writeObject("CustomEvent", events);
                } else {
                    events.add(event);
                    Storage.getInstance().writeObject("CustomEvent", events);
                }
                final Button b = new Button(customEvent);
                b.setUIID("Separator");
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        final DateSpinner ds = new DateSpinner();
                        Dialog dlg = new Dialog("Custom event");
                        final Container cnt = new Container(new BorderLayout());
                        final TextField tf = new TextField();
                        tf.setText(b.getText());
                        Container cnt1 = new Container(new GridLayout(1, 2));
//                        cnt1.addComponent(btn1);
                        //          cnt1.addComponent(btn);
                        cnt.addComponent(BorderLayout.NORTH, tf);
                        cnt.addComponent(BorderLayout.CENTER, ds);
                        cnt.addComponent(BorderLayout.SOUTH, cnt1);
                        dlg.addComponent(cnt);
                        dlg.show();
                    }
                });

                findContainer4(c.getComponentForm()).addComponent(3, b);
                ds.setCurrentDay(24);
                ds.setCurrentMonth(1);
                ds.setCurrentYear(2012);
                ds.revalidate();
                myContact.setBirthday(eventDay);

                ((Dialog) Display.getInstance().getCurrent()).dispose();
                //cnt.revalidate();
            }
        });
        Button btn1 = new Button("Cancel");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Custom event : " + myContact.getFirstEncounter());


                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });
        Container cnt1 = new Container(new GridLayout(1, 2));
        cnt1.addComponent(btn1);
        cnt1.addComponent(btn);
        cnt.addComponent(BorderLayout.NORTH, tf);
        cnt.addComponent(BorderLayout.CENTER, ds);
        cnt.addComponent(BorderLayout.SOUTH, cnt1);
        dlg.addComponent(cnt);
//        ds.setCurrentDay(24);
//        ds.setCurrentMonth(1);
//        ds.setCurrentYear(2012);
        dlg.show();
    }

    protected void beforeEventsToday(Form f) {
        //    Date date = new Date();
        //    GregorianCalendar gc = new GregorianCalendar();
        //   java.util.Calendar c = GregorianCalendar.getInstance();
        ///    String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
        if (Storage.getInstance().exists("CustomEvent")) {
            allEvents = (Vector<Hashtable>) Storage.getInstance().readObject("CustomEvent");
            Hashtable eventHash = new Hashtable();
            for (int i = 0; i < allEvents.size(); i++) {
                eventHash = (Hashtable) allEvents.elementAt(i);
                Button btn = new Button(eventHash.get("event").toString());
                btn.setUIID("Separator");
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    }
                });
                findContainer(f).addComponent(btn);
                f.revalidate();
                System.out.println("so");
            }
        }

    }

    @Override
    protected void onEachContact_ButtonAction(Component c, ActionEvent event) {
        super.onEachContact_ButtonAction(c, event);
        final CalendarEvent ntc = (CalendarEvent) NativeLookup.create(CalendarEvent.class);
        if (ntc != null && ntc.isSupported()) {
            new Thread() {
                @Override
                public void run() {

                    ntc.executeCalendar();
                    //ntc.setMyReminder(2014, 1, 26, "Birthday", "A custom event set from my Codename One application");
                }
            }.start();
        } else {
            Dialog.show("Native interface", "a feature not supported", "OK", null);
        }
    }
}
