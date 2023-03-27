package hdn.dev.midtermandroid;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
@Entity(tableName = "tbl_contact")
public interface ContactDAO {
    @Insert
    void insert(Contact model);

    @Query("SELECT * FROM tbl_contact ORDER BY id ASC")
    List<Contact> getAllContacts();
}
