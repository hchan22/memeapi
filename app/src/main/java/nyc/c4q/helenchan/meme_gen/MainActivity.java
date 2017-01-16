package nyc.c4q.helenchan.meme_gen;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.helenchan.meme_gen.network.Meme;
import nyc.c4q.helenchan.meme_gen.network.MemeResponse;
import nyc.c4q.helenchan.meme_gen.network.MemeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Meme> memesList = new ArrayList<>();
    RecyclerView recyclerView;
    MemeAdapter adapter;
    GridLayoutManager mLayoutManager;
    private boolean shouldKeepScrollPosition = true;
    int currentVisiblePosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        mLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new MemeAdapter(memesList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getMemes();
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentVisiblePosition = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPosition(currentVisiblePosition);
        currentVisiblePosition = 0;
    }



    public void getMemes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgflip.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MemeService service = retrofit.create(MemeService.class);
        Call<MemeResponse> call = service.getMemememe();
        call.enqueue(new Callback<MemeResponse>() {
            @Override
            public void onResponse(Call<MemeResponse> call, Response<MemeResponse> response) {
                memesList = response.body().getData().getMemes();
                recyclerView.setAdapter(new MemeAdapter(memesList));
                adapter.notifyDataSetChanged();
//                Log.d("response", "in response");
//                memesList.clear();
//                memesList.addAll(response.body().getData().getMemes());
//                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MemeResponse> call, Throwable t) {
                Log.d("response", "in fail");
            }
        });

    }
}
