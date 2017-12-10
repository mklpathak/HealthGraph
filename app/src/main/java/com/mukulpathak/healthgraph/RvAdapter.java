package com.mukulpathak.healthgraph;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mukulpathak.healthgraph.pojos.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pat on 12/10/2017.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    String TAG = RvAdapter.class.getSimpleName();
    Context context;
    String defaultColor = "#000000";

    ArrayList<Game> gameArrayList;
    GameClick gameClick;

    public RvAdapter(Context context, GameClick gameClick) {
        super();
        this.context = context;
        gameArrayList = new ArrayList<>();
        this.gameClick = gameClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_game, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(gameArrayList.get(position));
    }


    @Override
    public int getItemCount() {
        return gameArrayList.size();
    }

    public void addItems(ArrayList<Game> newGames) {
        this.gameArrayList = newGames;
        notifyDataSetChanged();
    }

    public void addItem(Game newGame) {
        this.gameArrayList.add(newGame);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tvGameName)
        TextView tvGameName;
        @BindView(R.id.tvPlayersOnline)
        TextView playersOnline;
        @BindView(R.id.imageForground)
        View imageForground;
        @BindView(R.id.sdvCover)
        ImageView sdvCover;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bindData(Game game) {

            tvGameName.setText(game.getName());
            Picasso.with(context).load(game.getHeaderImage()).into(sdvCover);
            sdvCover.setTransitionName(String.valueOf(game.getSteamAppid()));

            GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor(defaultColor), Color.argb(0, 0, 0, 0)});
            gradient.setShape(GradientDrawable.RECTANGLE);
            imageForground.setBackground(gradient);
            playersOnline.setText("Players Online: " + game.getTwitch().getValues().get(game.getTwitch().getValues().size()-1));

        }

        @Override
        public void onClick(View v) {
            gameClick.onGameClicked(gameArrayList.get(getAdapterPosition()),sdvCover);
        }
    }

    public interface GameClick {
        void onGameClicked(Game g,ImageView imageView);
    }
}