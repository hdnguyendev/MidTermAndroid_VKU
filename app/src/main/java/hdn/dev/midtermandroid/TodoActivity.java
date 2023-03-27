package hdn.dev.midtermandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TodoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TodoRVAdapter todoAdapter;
    private List<Todo> todos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<List<Todo>> call = RetrofitClient.getInstance().getMyApi().getTodos();
        call.enqueue(new Callback<List<Todo>>() {

            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                todos = response.body();
                todoAdapter = new TodoRVAdapter(todos);
                recyclerView.setAdapter(todoAdapter);
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Toast.makeText(TodoActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}