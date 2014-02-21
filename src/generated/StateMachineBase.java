/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("MultiButton", com.codename1.components.MultiButton.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("InfiniteProgress", com.codename1.components.InfiniteProgress.class);
        UIBuilder.registerCustomComponent("MultiList", com.codename1.ui.list.MultiList.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "SplashScreen";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("MultiButton", com.codename1.components.MultiButton.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("InfiniteProgress", com.codename1.components.InfiniteProgress.class);
        UIBuilder.registerCustomComponent("MultiList", com.codename1.ui.list.MultiList.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "SplashScreen");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Container findContainer4(Component root) {
        return (com.codename1.ui.Container)findByName("Container4", root);
    }

    public com.codename1.ui.Container findContainer4() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer3(Component root) {
        return (com.codename1.ui.Container)findByName("Container3", root);
    }

    public com.codename1.ui.Container findContainer3() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer5(Component root) {
        return (com.codename1.ui.Container)findByName("Container5", root);
    }

    public com.codename1.ui.Container findContainer5() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.MultiButton findContactMultiButton(Component root) {
        return (com.codename1.components.MultiButton)findByName("contactMultiButton", root);
    }

    public com.codename1.components.MultiButton findContactMultiButton() {
        com.codename1.components.MultiButton cmp = (com.codename1.components.MultiButton)findByName("contactMultiButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.MultiButton)findByName("contactMultiButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContactsRenderer(Component root) {
        return (com.codename1.ui.Container)findByName("ContactsRenderer", root);
    }

    public com.codename1.ui.Container findContactsRenderer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContactsRenderer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContactsRenderer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel1(Component root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findEncounterButton(Component root) {
        return (com.codename1.ui.Button)findByName("encounterButton", root);
    }

    public com.codename1.ui.Button findEncounterButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("encounterButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("encounterButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findCustomButton(Component root) {
        return (com.codename1.ui.Button)findByName("customButton", root);
    }

    public com.codename1.ui.Button findCustomButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("customButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("customButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findPhoneIcon(Component root) {
        return (com.codename1.ui.Button)findByName("phoneIcon", root);
    }

    public com.codename1.ui.Button findPhoneIcon() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("phoneIcon", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("phoneIcon", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findAnniversaryButton(Component root) {
        return (com.codename1.ui.Button)findByName("anniversaryButton", root);
    }

    public com.codename1.ui.Button findAnniversaryButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("anniversaryButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("anniversaryButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBirthdayButton(Component root) {
        return (com.codename1.ui.Button)findByName("birthdayButton", root);
    }

    public com.codename1.ui.Button findBirthdayButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("birthdayButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("birthdayButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContactsContainer(Component root) {
        return (com.codename1.ui.Container)findByName("contactsContainer", root);
    }

    public com.codename1.ui.Container findContactsContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contactsContainer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contactsContainer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.InfiniteProgress findInfiniteProgress(Component root) {
        return (com.codename1.components.InfiniteProgress)findByName("InfiniteProgress", root);
    }

    public com.codename1.components.InfiniteProgress findInfiniteProgress() {
        com.codename1.components.InfiniteProgress cmp = (com.codename1.components.InfiniteProgress)findByName("InfiniteProgress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.InfiniteProgress)findByName("InfiniteProgress", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.list.MultiList findStoredContactsMultiList(Component root) {
        return (com.codename1.ui.list.MultiList)findByName("storedContactsMultiList", root);
    }

    public com.codename1.ui.list.MultiList findStoredContactsMultiList() {
        com.codename1.ui.list.MultiList cmp = (com.codename1.ui.list.MultiList)findByName("storedContactsMultiList", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.list.MultiList)findByName("storedContactsMultiList", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findPhoneNumberLabel(Component root) {
        return (com.codename1.ui.Label)findByName("phoneNumberLabel", root);
    }

    public com.codename1.ui.Label findPhoneNumberLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("phoneNumberLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("phoneNumberLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField", root);
    }

    public com.codename1.ui.TextField findTextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.list.MultiList findMultiList(Component root) {
        return (com.codename1.ui.list.MultiList)findByName("MultiList", root);
    }

    public com.codename1.ui.list.MultiList findMultiList() {
        com.codename1.ui.list.MultiList cmp = (com.codename1.ui.list.MultiList)findByName("MultiList", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.list.MultiList)findByName("MultiList", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("EachContact".equals(f.getName())) {
            exitEachContact(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("EventsToday".equals(f.getName())) {
            exitEventsToday(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("SelectedContacts".equals(f.getName())) {
            exitSelectedContacts(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("SplashScreen".equals(f.getName())) {
            exitSplashScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactsRenderer".equals(f.getName())) {
            exitContactsRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void exitEachContact(Form f) {
    }


    protected void exitEventsToday(Form f) {
    }


    protected void exitSelectedContacts(Form f) {
    }


    protected void exitSplashScreen(Form f) {
    }


    protected void exitMain(Form f) {
    }


    protected void exitContactsRenderer(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("EachContact".equals(f.getName())) {
            beforeEachContact(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("EventsToday".equals(f.getName())) {
            beforeEventsToday(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("SelectedContacts".equals(f.getName())) {
            beforeSelectedContacts(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("SplashScreen".equals(f.getName())) {
            beforeSplashScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactsRenderer".equals(f.getName())) {
            beforeContactsRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void beforeEachContact(Form f) {
    }


    protected void beforeEventsToday(Form f) {
    }


    protected void beforeSelectedContacts(Form f) {
    }


    protected void beforeSplashScreen(Form f) {
    }


    protected void beforeMain(Form f) {
    }


    protected void beforeContactsRenderer(Form f) {
    }

    protected void beforeShowContainer(Container c) {
    aboutToShowThisContainer = c;
        if("EachContact".equals(c.getName())) {
            beforeContainerEachContact(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("EventsToday".equals(c.getName())) {
            beforeContainerEventsToday(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("SelectedContacts".equals(c.getName())) {
            beforeContainerSelectedContacts(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("SplashScreen".equals(c.getName())) {
            beforeContainerSplashScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactsRenderer".equals(c.getName())) {
            beforeContainerContactsRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void beforeContainerEachContact(Container c) {
    }


    protected void beforeContainerEventsToday(Container c) {
    }


    protected void beforeContainerSelectedContacts(Container c) {
    }


    protected void beforeContainerSplashScreen(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }


    protected void beforeContainerContactsRenderer(Container c) {
    }

    protected void postShow(Form f) {
        if("EachContact".equals(f.getName())) {
            postEachContact(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("EventsToday".equals(f.getName())) {
            postEventsToday(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("SelectedContacts".equals(f.getName())) {
            postSelectedContacts(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("SplashScreen".equals(f.getName())) {
            postSplashScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactsRenderer".equals(f.getName())) {
            postContactsRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void postEachContact(Form f) {
    }


    protected void postEventsToday(Form f) {
    }


    protected void postSelectedContacts(Form f) {
    }


    protected void postSplashScreen(Form f) {
    }


    protected void postMain(Form f) {
    }


    protected void postContactsRenderer(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("EachContact".equals(c.getName())) {
            postContainerEachContact(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("EventsToday".equals(c.getName())) {
            postContainerEventsToday(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("SelectedContacts".equals(c.getName())) {
            postContainerSelectedContacts(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("SplashScreen".equals(c.getName())) {
            postContainerSplashScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactsRenderer".equals(c.getName())) {
            postContainerContactsRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void postContainerEachContact(Container c) {
    }


    protected void postContainerEventsToday(Container c) {
    }


    protected void postContainerSelectedContacts(Container c) {
    }


    protected void postContainerSplashScreen(Container c) {
    }


    protected void postContainerMain(Container c) {
    }


    protected void postContainerContactsRenderer(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("EachContact".equals(rootName)) {
            onCreateEachContact();
            aboutToShowThisContainer = null;
            return;
        }

        if("EventsToday".equals(rootName)) {
            onCreateEventsToday();
            aboutToShowThisContainer = null;
            return;
        }

        if("SelectedContacts".equals(rootName)) {
            onCreateSelectedContacts();
            aboutToShowThisContainer = null;
            return;
        }

        if("SplashScreen".equals(rootName)) {
            onCreateSplashScreen();
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactsRenderer".equals(rootName)) {
            onCreateContactsRenderer();
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void onCreateEachContact() {
    }


    protected void onCreateEventsToday() {
    }


    protected void onCreateSelectedContacts() {
    }


    protected void onCreateSplashScreen() {
    }


    protected void onCreateMain() {
    }


    protected void onCreateContactsRenderer() {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("storedContactsMultiList".equals(listName)) {
            return initListModelStoredContactsMultiList(cmp);
        }
        if("MultiList".equals(listName)) {
            return initListModelMultiList(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelStoredContactsMultiList(List cmp) {
        return false;
    }

    protected boolean initListModelMultiList(List cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("EachContact")) {
            if("phoneIcon".equals(c.getName())) {
                onEachContact_PhoneIconAction(c, event);
                return;
            }
            if("birthdayButton".equals(c.getName())) {
                onEachContact_BirthdayButtonAction(c, event);
                return;
            }
            if("anniversaryButton".equals(c.getName())) {
                onEachContact_AnniversaryButtonAction(c, event);
                return;
            }
            if("encounterButton".equals(c.getName())) {
                onEachContact_EncounterButtonAction(c, event);
                return;
            }
            if("customButton".equals(c.getName())) {
                onEachContact_CustomButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("EventsToday")) {
            if("TextField".equals(c.getName())) {
                onEventsToday_TextFieldAction(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onEventsToday_ButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("SelectedContacts")) {
            if("storedContactsMultiList".equals(c.getName())) {
                onSelectedContacts_StoredContactsMultiListAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Main")) {
            if("MultiList".equals(c.getName())) {
                onMain_MultiListAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContactsRenderer")) {
            if("contactMultiButton".equals(c.getName())) {
                onContactsRenderer_ContactMultiButtonAction(c, event);
                return;
            }
        }
    }

      protected void onEachContact_PhoneIconAction(Component c, ActionEvent event) {
      }

      protected void onEachContact_BirthdayButtonAction(Component c, ActionEvent event) {
      }

      protected void onEachContact_AnniversaryButtonAction(Component c, ActionEvent event) {
      }

      protected void onEachContact_EncounterButtonAction(Component c, ActionEvent event) {
      }

      protected void onEachContact_CustomButtonAction(Component c, ActionEvent event) {
      }

      protected void onEventsToday_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onEventsToday_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onSelectedContacts_StoredContactsMultiListAction(Component c, ActionEvent event) {
      }

      protected void onMain_MultiListAction(Component c, ActionEvent event) {
      }

      protected void onContactsRenderer_ContactMultiButtonAction(Component c, ActionEvent event) {
      }

}
