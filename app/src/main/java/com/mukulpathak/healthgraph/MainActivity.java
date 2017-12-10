package com.mukulpathak.healthgraph;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.login.LoginManager;
import com.google.gson.Gson;
import com.mukulpathak.healthgraph.pojos.Game;
import com.mukulpathak.healthgraph.pojos.Twitch;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    int Current = 0;
    int Total = 0 ;

    ArrayList<String> gameId;


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.userCover)
    SimpleDraweeView userCover;
    @BindView(R.id.userName)
    TextView username;
    @BindView(R.id.profilepic)
    SimpleDraweeView profilePic;
    @BindView(R.id.coverforground)
    View coverForground;
    SharedPreferences preferences;
    @BindView(R.id.loading)
            TextView loading;

    RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        Fresco.initialize(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("name", "");
        String profilepic = preferences.getString("profilepic", "");
        String CoverPic = preferences.getString("coverpic", "");
        if(!name.equalsIgnoreCase(""))
        {
            userCover.setImageURI(Uri.parse(CoverPic));
            profilePic.setImageURI(Uri.parse(profilepic));
            int color = getResources().getColor(R.color.facebookcolor);
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
            roundingParams.setBorder(color, 10.0f);
            roundingParams.setRoundAsCircle(true);
            profilePic.getHierarchy().setRoundingParams(roundingParams);
            username.setText(name);

        }
        gameId = new ArrayList<>();
        gameId.add("298610");
        gameId.add("473690");
        gameId.add("578080");
        gameId.add("365590");
        gameId.add("311290");
        gameId.add("252950");
        gameId.add("730");
        gameId.add("240720");
        gameId.add("107410");
        gameId.add("242920");
        gameId.add("298610");
        gameId.add("435150");
        gameId.add("476600");
        gameId.add("107410");
        gameId.add("611660");
        gameId.add("624090");

        Total=gameId.size();




        rvAdapter = new RvAdapter(getApplicationContext(), new RvAdapter.GameClick() {
            @Override
            public void onGameClicked(Game g, ImageView imageView) {
                Intent intent = new Intent(MainActivity.this, GameDetailsActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,imageView,String.valueOf(g.getSteamAppid()));
                intent.putExtra("AppId", g.getSteamAppid()+"");
                startActivity(intent,optionsCompat.toBundle());
            }
        });
      //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(rvAdapter);
        for (String s:gameId){

        fetchGameDetails(s);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            LoginManager.getInstance().logOut();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name","");
            editor.putString("profilepic","");
            editor.putString("coverpic","");
            editor.apply();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



    void fetchGameDetails(final String appId) {
        String base_url = "http://store.steampowered.com/api/appdetails/?appids="+appId;
        JsonObjectRequest request = new JsonObjectRequest(base_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject object) {
                        Gson gson = new Gson();
                        Log.e(TAG, "Response: " + object.toString());
                        try {
                            Game g = gson.fromJson(object.getJSONObject(appId).getJSONObject("data").toString(),Game.class);
//                            rvAdapter.addItem(g);
                            fetchMoreDetails(g);
                            ++Current;
                            loading.setText(String.valueOf(Current)+" out of " +Total + " Fetched");
                            if(Current==Total){

                                loading.setVisibility(View.GONE);
                            }

                        } catch (JSONException e) {
                           // Log.e(TAG, "JSONException: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e(TAG, "VolleyError: " + volleyError.getMessage());
                        ++Current;
                        loading.setText(String.valueOf(Current)+" out of " +Total + " Fetched");
                        if(Current==Total){

                            loading.setVisibility(View.GONE);
                        }
                    }
                });
        MyApplication.getInstance(getApplicationContext()).addToRequestQueue(request);
    }

    void fetchMoreDetails(final Game g) {
        String base_url = "https://steamdb.info/api/GetGraph/?type=concurrent_week&appid="+ g.getSteamAppid();
        JsonObjectRequest request = new JsonObjectRequest(base_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject object) {
                        Gson gson = new Gson();
                        Log.e(TAG, "Response: " + object.toString());
                        try {
                            Twitch twitch = gson.fromJson(object.getJSONObject("data").toString(),Twitch.class);

                            Log.e(TAG, "Twitch: " + twitch.toString());
                            g.setTwitch(twitch);
                        } catch (JSONException e) {
                            Log.e(TAG, "JSONException: " + e.getMessage());
                        } finally {
                            rvAdapter.addItem(g);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e(TAG, "VolleyError: " + volleyError.getMessage());
                        rvAdapter.addItem(g);
                    }
                });
        MyApplication.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}
