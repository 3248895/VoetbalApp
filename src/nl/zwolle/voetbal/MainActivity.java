package nl.zwolle.voetbal;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import nl.zwolle.voetbal.model.Player;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {

	private EditText username;
	private EditText password;
	private Button login;
	private TextView loginLockedTV;
	private TextView attemptsLeftTV;
	private TextView numberOfRemainingLoginAttemptsTV;
	int numberOfRemainingLoginAttempts = 3;
	Player player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupVariables();
	}
	
	public void authenticateLogin(View view) throws IOException {
		if (username.getText().toString().equals("admin") && 
			password.getText().toString().equals("admin")) {
				Intent intent = new Intent(this, AdminActivity.class);
				startActivity(intent);
			
		} 
		if (username.getText().toString().equals("admin") && 
				!password.getText().toString().equals("admin")) {
			Toast.makeText(getApplicationContext(), "Seems like you 're not admin!", 
					Toast.LENGTH_SHORT).show();
			numberOfRemainingLoginAttempts--;
			attemptsLeftTV.setVisibility(View.VISIBLE);
			numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
			numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
			
			if (numberOfRemainingLoginAttempts == 0) {
				login.setEnabled(false);
				loginLockedTV.setVisibility(View.VISIBLE);
				loginLockedTV.setBackgroundColor(Color.RED);
				loginLockedTV.setText("LOGIN LOCKED!!!");
			}
		}
		else checkLogin();
	}

	private void checkLogin() throws IOException {
		List<Player> players = Player.find(Player.class, "username = ?", username.getText().toString());
		System.out.println(players.isEmpty());
		System.out.println(players.get(0).getUsername());
		System.out.println(players.get(0).getPassword());
		System.out.println(password.getText().toString());
		if(players.get(0).getPassword().equals(password.getText().toString())) {
			System.out.println("Password klopt");
			player = players.get(0);
			player.setLoggedIn(true);
			System.out.println("loggedIn: " + player.isLoggedIn());
			Intent intent = new Intent(this, PlayerActivity.class);
			intent.putExtra("playerObject", player);
			startActivity(intent);
		}
	}

	private void setupVariables() {
		username = (EditText) findViewById(R.id.usernameET);
		password = (EditText) findViewById(R.id.passwordET);
		login = (Button) findViewById(R.id.loginBtn);
		loginLockedTV = (TextView) findViewById(R.id.loginLockedTV);
		attemptsLeftTV = (TextView) findViewById(R.id.attemptsLeftTV);
		numberOfRemainingLoginAttemptsTV = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
		numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
	}
	
	public void onClick(View view) {
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}
	
}