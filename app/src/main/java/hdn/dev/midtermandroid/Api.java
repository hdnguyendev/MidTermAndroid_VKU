package hdn.dev.midtermandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String URL = "https://jsonplaceholder.typicode.com/";
    @GET("todos")
    Call<List<Todo>> getTodos();
}
