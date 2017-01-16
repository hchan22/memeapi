package nyc.c4q.helenchan.meme_gen;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nyc.c4q.helenchan.meme_gen.network.Meme;

/**
 * Created by helenchan on 1/9/17.
 */
public class MemeViewHolder extends RecyclerView.ViewHolder{
    private ImageView memeIV;
    String memeName;
    String memeURL;

    public MemeViewHolder(final View itemView) {
        super(itemView);
        memeIV = (ImageView) itemView.findViewById(R.id.meme_iv);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), MemeActivity.class);
                intent.putExtra("nameMe", memeName);
                intent.putExtra("urlMe", memeURL);
                itemView.getContext().startActivity(intent);
            }
        });

    }

    public void bind(Meme meme) {
        memeName = meme.getName();
        memeURL = meme.getUrl();
        Picasso.with(itemView.getContext())
                .load(memeURL)
                .fit()
                .into(memeIV);
    }


}
