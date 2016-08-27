package movieapp.nohier.com.movieapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class DetailedActivity extends AppCompatActivity
    implements Serializable
         {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed);

      if(getIntent().hasExtra("Image"))
      {
          Image image = getIntent().getParcelableExtra("Image");
          TextView moviename = (TextView) findViewById(R.id.movie_name);
          ImageView imageView = (ImageView) findViewById(R.id.imageView);
          TextView year = (TextView) findViewById(R.id.year);
          TextView vote = (TextView) findViewById(R.id.vote);
          TextView overview = (TextView) findViewById(R.id.overview);
          moviename.setText(image.getTitle());
          Picasso.with(this).load("http://image.tmdb.org/t/p/w185/"+image.getPath()).into(imageView);
          year.setText(image.getYear());
          String votee = String.valueOf(image.getVote());
          vote.setText(votee);
          overview.setText(image.getOverview());



      }



    }
}
