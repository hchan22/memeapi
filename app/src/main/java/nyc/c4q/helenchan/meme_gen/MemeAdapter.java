package nyc.c4q.helenchan.meme_gen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.helenchan.meme_gen.network.Meme;

/**
 * Created by helenchan on 1/9/17.
 */

public class MemeAdapter extends RecyclerView.Adapter<MemeViewHolder> {
    List<Meme> memesList;


    public MemeAdapter(List<Meme> memesList) {
        this.memesList = memesList;
    }

    @Override
    public MemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meme_itemview, parent, false);
        return new MemeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MemeViewHolder holder, int position) {
        Meme meme = memesList.get(position);
        holder.bind(meme);
    }

    @Override
    public int getItemCount() {
        return memesList.size();
    }
}
