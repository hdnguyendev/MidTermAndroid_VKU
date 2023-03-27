package hdn.dev.midtermandroid;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private final Api myApi;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);

    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null)
        {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }
}
