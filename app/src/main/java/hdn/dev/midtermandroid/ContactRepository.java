package hdn.dev.midtermandroid;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.util.Log;

import java.util.List;

public class ContactRepository {
    public static ContactDAO dao;

    public ContactRepository(Application application) {
        ContactDatabase database = ContactDatabase.getInstance(application);
        dao = database.Dao();
    }
    public void insert(Contact contact)
    {
        dao.insert(contact);
    }


    public List<Contact> getAllContacts()
    {
        return dao.getAllContacts();

    }
}
