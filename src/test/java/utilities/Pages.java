package utilities;

import PageObject.UndoHomepage;
import PageObject.UndoLogin;
import PageObject.UndoPayment;
import PageObject.UndoRechStatus;


public class Pages {
    public UndoHomepage undoHomepage;
    public UndoPayment undoPayment;
    public UndoLogin undoLogin;
    public UndoRechStatus undoRechStatus;

    public Pages() {
        undoHomepage = new UndoHomepage();
        undoPayment = new UndoPayment();
        undoLogin = new UndoLogin();
        undoRechStatus = new UndoRechStatus();
    }
}
