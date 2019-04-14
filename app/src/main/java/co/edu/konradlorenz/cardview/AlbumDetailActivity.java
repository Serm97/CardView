package co.edu.konradlorenz.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class AlbumDetailActivity extends AppCompatActivity {

    private TextView nameAlbum;
    private ImageView imageAlbum;
    private RatingBar star;
    private RecyclerView recyclerSongs;
    private SongsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        star = findViewById(R.id.ratingBar);

        recyclerSongs = (RecyclerView) findViewById(R.id.listSongs);
        adapter = new SongsAdapter(this);

        RecyclerView.LayoutManager sLayoutManager = new GridLayoutManager(this, 1);
        recyclerSongs.setLayoutManager(sLayoutManager);
        recyclerSongs.addItemDecoration(new MainActivity.GridSpacingItemDecoration(1,2, true));
        recyclerSongs.setItemAnimator(new DefaultItemAnimator());
        recyclerSongs.setAdapter(adapter);



        star.setRating((float) Math.random()*(5-1)+1);
        nameAlbum = findViewById(R.id.nameAlbum);
        imageAlbum = findViewById(R.id.imageAlbum);

        nameAlbum.setText(getIntent().getStringExtra("Album"));
        Glide.with(this).load(getIntent().getExtras().get("img")).into(imageAlbum);
    }
}
