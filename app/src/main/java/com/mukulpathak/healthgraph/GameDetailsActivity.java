package com.mukulpathak.healthgraph;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.mukulpathak.healthgraph.pojos.CategoriesItem;
import com.mukulpathak.healthgraph.pojos.Game;
import com.mukulpathak.healthgraph.pojos.GenresItem;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameDetailsActivity extends AppCompatActivity {
    String TAG = GameDetailsActivity.class.getSimpleName();

    @BindView(R.id.viewPager)
    ViewPager vpScreenShots;

    @BindView(R.id.tvScreenShotCount)
    TextView tvScreenShotCount;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvDesc)
    TextView tvDesc;
    @BindView(R.id.tvDevelopers)
    TextView tvDevelopers;
    @BindView(R.id.tvPublishers)
    TextView tvPublishers;
    @BindView(R.id.tvCategories)
    TextView tvCategories;
    @BindView(R.id.tvGenre)
    TextView tvGenre;

    @BindView(R.id.tvMetaScore)
    TextView tvMetaScore;
    @BindView(R.id.imageHeader)
    ImageView headerImage;
    String appId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        appId = intent.getStringExtra("AppId");
        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor("#000000"), Color.argb(0, 0, 0, 0)});
        gradient.setShape(GradientDrawable.RECTANGLE);
        View view = (View) findViewById(R.id.headerforground);
        view.setBackground(gradient);

        if (appId != null ) {
            headerImage.setTransitionName(appId);
            fetchGameDetails(appId);

        }else {
            finish();
        }
    }

    void fetchGameDetails(final String appId) {
        String base_url = "http://store.steampowered.com/api/appdetails/?appids=" + appId;
        JsonObjectRequest request = new JsonObjectRequest(base_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject object) {
                        Gson gson = new Gson();
                        Log.e(TAG, "Response: " + object.toString());
                        try {
                            Game g = gson.fromJson(object.getJSONObject(appId).getJSONObject("data").toString(), Game.class);
                            updateView(g);
                        } catch (JSONException e) {
                            Log.e(TAG, "JSONException: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e(TAG, "VolleyError: " + volleyError.getMessage());
                    }
                });
        MyApplication.getInstance(getApplicationContext()).addToRequestQueue(request);
    }


    void updateView(final Game g) {
        Picasso.with(this).load(g.getHeaderImage()).into(headerImage);
        tvName.setText(g.getName());
        vpScreenShots.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),g));
        tvScreenShotCount.setText((1)+"/"+g.getScreenshots().size());
        vpScreenShots.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvScreenShotCount.setText((position+1)+"/"+g.getScreenshots().size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tvDesc.setText(g.getShortDescription());
        String developers = "";
        for (String dev: g.getDevelopers())
            developers+= dev+", ";
        tvDevelopers.setText(Html.fromHtml("<b>Developers: </b>"+developers));

        String publishers = "";
        for (String pub: g.getPublishers())
            publishers+= pub+", ";
        tvPublishers.setText(Html.fromHtml("<b>Publishers: </b>"+publishers));

        String categories = "";
        for (CategoriesItem cat: g.getCategories())
            categories+= cat.getDescription()+", ";
        tvCategories.setText(Html.fromHtml("<b>Categories: </b>"+categories));

        String genre = "";
        for (GenresItem gen: g.getGenres())
            genre+= gen.getDescription()+", ";
        tvGenre.setText(Html.fromHtml("<b>Genre: </b>"+genre));
        if(g.getMetacritic()!=null)
        tvMetaScore.setText(g.getMetacritic().getScore() + "");
        else
            tvMetaScore.setVisibility(View.GONE);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        Game game;

        public MyPagerAdapter(FragmentManager fragmentManager, Game game) {
            super(fragmentManager);
            this.game = game;
        }

        @Override
        public int getCount() {
            return game.getScreenshots().size();
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenShot.newInstance(game.getScreenshots().get(position).getPathThumbnail());
        }
    }

}
