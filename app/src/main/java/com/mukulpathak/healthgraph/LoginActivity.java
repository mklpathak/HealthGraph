package com.mukulpathak.healthgraph;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.mukulpathak.healthgraph.facebookData.FacebookData;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{
    String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.fbLogin)
    LoginButton fbLogin;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (AccessToken.getCurrentAccessToken() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

         preferences = PreferenceManager.getDefaultSharedPreferences(this);

    }


    private CallbackManager callbackManager;
    @Override
    protected void onResume() {
        super.onResume();
        callbackManager = CallbackManager.Factory.create();
        fbLogin.registerCallback(callbackManager, facebookCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.e(TAG, "FacebookCallback onSuccess Token: " + loginResult.getAccessToken().getToken());
            Log.e(TAG, "FacebookCallback Granted Permission Size: " + loginResult.getRecentlyGrantedPermissions().size());
            Log.e(TAG, "FacebookCallback Granted Permissions: " + loginResult.getRecentlyGrantedPermissions().toString());
            Log.e(TAG, "FacebookCallback Denied Permission Size: " + loginResult.getRecentlyDeniedPermissions().size());
            Log.e(TAG, "FacebookCallback Denied Permissions: " + loginResult.getRecentlyDeniedPermissions().toString());
            getFacebookData(loginResult.getAccessToken());
        }

        @Override
        public void onCancel() {
            Log.e(TAG, "FacebookCallbackCancel: ");
        }

        @Override
        public void onError(FacebookException error) {
           Log.e(TAG, "FacebookCallbackError: " + error.getMessage());
        }
    };

    public void getFacebookData(AccessToken accessToken) {
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Gson gson = new Gson();
                FacebookData facebookData = gson.fromJson(object.toString(),FacebookData.class);
                if(facebookData!=null){


                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("name",facebookData.getName());
                    editor.putString("profilepic",facebookData.getPicture().getData().getUrl());
                    editor.putString("coverpic",facebookData.getCover().getSource());
                    editor.apply();
                    Log.e("Facebook",facebookData.getName());
                    Log.e("Facebook",facebookData.getCover().getSource());
                    Log.e("Facebook",facebookData.getPicture().getData().getUrl());


                }

                    Log.e(TAG, "response "+ object.toString());


                Log.e("Hello","HEllo");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields",
                "about,id,name,email,picture.type(large),cover");
        request.setParameters(parameters);
        request.executeAsync();
    }
}

