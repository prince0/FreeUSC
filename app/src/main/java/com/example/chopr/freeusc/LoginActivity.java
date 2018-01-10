package com.example.chopr.freeusc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

//    http://lafeimme.com/FreeUSC/put_login_data.php?first_name=Prince&last_name=Chopra&email=prince@gmail.com&gender=Male

    CallbackManager callbackManager;

    @BindView(R.id.login_button)
    com.facebook.login.widget.LoginButton loginButton;
    ProfileTracker profileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        callbackManager = CallbackManager.Factory.create();

        loginButton.setReadPermissions("email, birthday");

        LoginManager.getInstance().logInWithPublishPermissions(
                this,
                Arrays.asList("publish_actions"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                Profile profile = Profile.getCurrentProfile();

                String firstName = profile.getFirstName();
                String lastName = profile.getLastName();

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("LoginActivity", object.toString());

                            }
                        });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();

//                            profileTracker = new ProfileTracker() {
//                    @Override
//                    protected void onCurrentProfileChanged(
//                            Profile oldProfile,
//                            Profile currentProfile) {
//
//                        Log.e("first name",currentProfile.getFirstName());
//                        Log.e("last name",currentProfile.getLastName());
//
//                        currentProfile.
//
//                    }
//                };

                Log.e("Facebook result", loginResult.getRecentlyGrantedPermissions().toString());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
