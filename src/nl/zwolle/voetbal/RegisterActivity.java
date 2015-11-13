package nl.zwolle.voetbal;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;
import nl.zwolle.voetbal.model.Player;
import nl.zwolle.voetbal.model.Team;

public class RegisterActivity extends Activity {
	
	private EditText username;
	private EditText firstName;
	private EditText lastName;
	private EditText password;
	public ArrayList<Team> teams = new ArrayList<Team>(5);
	private Player player;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}
	
	public void registerPlayer(View view) {
		
		username = (EditText) findViewById(R.id.username);
		firstName = (EditText) findViewById(R.id.firstName);
		lastName = (EditText) findViewById(R.id.lastName);
		password = (EditText) findViewById(R.id.password);
		
		player = new Player(	username.getText().toString(), 
								firstName.getText().toString(),
								lastName.getText().toString(),
								password.getText().toString(),
								true);
		
		player.save(); 
		
		Intent intent = new Intent(this, PlayerActivity.class);
		intent.putExtra("playerObject", player);
		startActivity(intent);
	}

}
