package nyc.c4q.helenchan.meme_gen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by helenchan on 1/12/17.
 */
public class MemeActivity extends AppCompatActivity {
    private TextView memeNameTV;
    private ImageView memeLargerImage;
    private String memeName;
    private String memeURL;
    private Button shareButton;
    private Button saveButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);

        Intent intent = getIntent();
        memeName = intent.getStringExtra("nameMe");
        memeURL = intent.getStringExtra("urlMe");
        memeNameTV = (TextView) findViewById(R.id.meme_title_tv);
        memeLargerImage = (ImageView) findViewById(R.id.activity_meme_iv);
        memeNameTV.setText(memeName);
        setImage(memeURL);
        shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharePic();
            }
        });

    }

    private void sharePic() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


    public void setImage(String memeURL){
        Picasso.with(this)
                .load(memeURL)
                .into(memeLargerImage);

    }
}
