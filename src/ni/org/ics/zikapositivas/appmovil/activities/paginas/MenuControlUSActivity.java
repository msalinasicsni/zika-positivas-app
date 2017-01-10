package ni.org.ics.zikapositivas.appmovil.activities.paginas;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZpControlUSRecepcionActivity;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZpControlUSSalidaActivity;
import ni.org.ics.zikapositivas.appmovil.adapters.MenuControlConsentimientosAdapter;
import ni.org.ics.zikapositivas.appmovil.R;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class MenuControlUSActivity extends AbstractAsyncActivity {

	private GridView gridView;
	private TextView textView;	
	String[] menu_us_info;
	String filtro;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_maternal);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		textView = (TextView) findViewById(R.id.label);
		gridView = (GridView) findViewById(R.id.gridView1);
		menu_us_info = getResources().getStringArray(R.array.menu_us);
		Drawable img =getResources().getDrawable( R.drawable.ic_us);
		textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
		textView.setText(R.string.main_us);
		gridView.setAdapter(new MenuControlConsentimientosAdapter(getApplicationContext(), R.layout.menu_item_2, menu_us_info));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Intent i;
				switch(position){
				case 0:
					i = new Intent(getApplicationContext(),
							NewZpControlUSSalidaActivity.class);
					startActivity(i);
					break;
				case 1:
					i = new Intent(getApplicationContext(),
							NewZpControlUSRecepcionActivity.class);
					startActivity(i);
					break;
				default:
					break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.MENU_BACK:
			finish();
			return true;
		case R.id.MENU_HOME:
			i = new Intent(getApplicationContext(),
					MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}	
}
	
