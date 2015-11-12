package nl.zwolle.voetbal;

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

public class RegisterActivity extends Activity {
	
	Button button;
	private EditText username;
	private EditText firstName;
	private EditText lastName;
	private EditText password;
	
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
		
		Player player = new Player(	username.getText().toString(), 
									firstName.getText().toString(),
									lastName.getText().toString(),
									password.getText().toString());
		player.save();
		
		Intent intent = new Intent(this, PlayerActivity.class);
		startActivity(intent);
	}

}
