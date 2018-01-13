package com.example.chopr.freeusc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

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

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.lafeimme.com/FreeUSC/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final FreeUSCService freeUSCService = retrofit.create(FreeUSCService.class);

        callbackManager = CallbackManager.Factory.create();

        loginButton.setReadPermissions("email");

        LoginManager.getInstance().logInWithPublishPermissions(
                this,
                Arrays.asList("publish_actions"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                final Profile profile = Profile.getCurrentProfile();

                final String firstName = profile.getFirstName();
                final String lastName = profile.getLastName();

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {

                                try {
//                                    User user = new User(firstName, lastName, object.get("email").toString(), object.get("gender").toString());
                                    freeUSCService.createUser(firstName, lastName,
                                            object.get("email").toString(), object.get("gender").toString());

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();

                openActivity();

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

    void openActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
