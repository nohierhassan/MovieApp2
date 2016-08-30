package movieapp.nohier.com.movieapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class DetailedActivity extends AppCompatActivity
    implements Serializable
         {
             ListView ls;
             Context c = this;
             static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed);
        ls = (ListView) findViewById(R.id.listView);


        if(getIntent().hasExtra("Image")) {
          final Image image = getIntent().getParcelableExtra("Image");
          TextView moviename = (TextView) findViewById(R.id.movie_name);
            id = image.getId();
          ImageView imageView = (ImageView) findViewById(R.id.imageView);
          TextView year = (TextView) findViewById(R.id.year);
          TextView vote = (TextView) findViewById(R.id.vote);
          TextView overview = (TextView) findViewById(R.id.overview);
          moviename.setText(image.getTitle());
          Picasso.with(this).load("http://image.tmdb.org/t/p/w185/" + image.getPath()).into(imageView);
          year.setText(image.getYear());
          String votee = String.valueOf(image.getVote());
          vote.setText(votee);
          overview.setText(image.getOverview());
          Button btn = (Button) findViewById(R.id.button);
          btn.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                  youtubeConnection youtubeConnection1 = new youtubeConnection(image.getId(), c);
                  youtubeConnection1.execute();


              }
          });


      }

    }

             @Override
             protected void onStart() {

                 FetchReviews fetchReviews = new FetchReviews(id,c,ls);
                 fetchReviews.execute();
                 super.onStart();
             }
         }
