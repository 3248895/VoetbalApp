package nl.zwolle.voetbal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;
import nl.zwolle.voetbal.model.Player;

public class PlayerActivity extends Activity {
	
	Player player;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		Intent intent = getIntent();
		player = (Player)intent.getSerializableExtra("playerObject");
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText("Welcome " + player.getUsername() + "!");
	}
	
	public void sayName(View view) {
		Toast.makeText(getApplicationContext(), player.getUsername(), 
				Toast.LENGTH_SHORT).show();
	}
	
	public void logOut(View view) {
		player.setLoggedIn(false);
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}

}
