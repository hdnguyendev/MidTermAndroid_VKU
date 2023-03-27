package hdn.dev.midtermandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> list;
    private RvAdapter adapter;
    private RecyclerView rvContacts;
    ContactRepository res;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.idItemAdd:
                finish();
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                return true;
            case R.id.idTodo:
                Intent intent1 = new Intent(MainActivity.this, TodoActivity.class);
                startActivity(intent1);
                return true;
            default:
                return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // getting data
        res = new ContactRepository(this.getApplication());
        list = new ArrayList<Contact>();
        List<Contact> data = res.getAllContacts();
        for (int i = 0; i < data.size(); i++) {
          Contact contact = new Contact();
            String name = data.get(i).getName();
            String phone = data.get(i).getPhone();
            String email = data.get(i).getEmail();
            contact.setId(data.get(i).getId());
            contact.setName(name);
            contact.setPhone(phone);
            contact.setEmail(email);
            System.out.println(contact);
            list.add(contact);

        }

        adapter = new RvAdapter(list, MainActivity.this);

        //creating recycler view
        rvContacts = findViewById(R.id.idRVContacts);
        // set linear layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        rvContacts.setLayoutManager(linearLayoutManager);
        rvContacts.setAdapter(adapter);
    }
}