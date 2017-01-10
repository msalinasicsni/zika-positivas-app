package ni.org.ics.zikapositivas.appmovil;




import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import net.sqlcipher.SQLException;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.users.Authority;
import ni.org.ics.zikapositivas.appmovil.domain.users.UserSistema;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;



import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity {


	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLoginTask mAuthTask = null;
	protected static final String TAG = LoginActivity.class.getSimpleName();

	// Values for email and password at the time of the login attempt.
	private String mUser;
	private String mPassword;
	private Boolean successLogin;

	// UI references.
	private EditText mUserView;
	private EditText mPasswordView;
	private EditText mUrlView;
	private CheckBox chkServer;
	private CheckBox chkWipe;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	private SharedPreferences settings;
	private String url;
	private AlertDialog alertDialog;
	private static final int LIMPIAR = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.login_layout);

		// Set up the login form.

		mUserView = (EditText) findViewById(R.id.user);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
		.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView textView, int id,
					KeyEvent keyEvent) {
				if (id == R.id.login || id == EditorInfo.IME_NULL) {
					attemptLogin();
					return true;
				}
				return false;
			}
		});

		chkServer = (CheckBox) findViewById(R.id.checkServer);
		chkWipe = (CheckBox) findViewById(R.id.checkWipe);
		
		chkWipe.setOnClickListener(new View.OnClickListener() {

		    @Override
		    public void onClick(View v) {

		        if ( ((CheckBox)v).isChecked() ) {
		            // perform logic
		        	createDialog(LIMPIAR);
		        }
		    }
		});
		
		mUrlView = (EditText) findViewById(R.id.url);
		mUrlView.setVisibility(View.GONE);

		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		url =
				settings.getString(PreferencesActivity.KEY_SERVER_URL, this.getString(R.string.default_server_url));
		mUser =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		mUserView.setText(mUser);
		mUrlView.setText(url);
		mPasswordView.requestFocus();

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin();
					}
				});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_cancel:
			finish();
		case R.id.menu_server:
			mUrlView.setVisibility(View.VISIBLE);
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null && chkServer.isChecked()) {
			return;
		}

		// Reset errors.
		mUserView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mUser = mUserView.getText().toString();
		mPassword = mPasswordView.getText().toString();
		url=mUrlView.getText().toString();
		((MyZikaPosApplication) this.getApplication()).setPassApp(mPassword);

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		if (TextUtils.isEmpty(mUser)) {
			mUserView.setError(getString(R.string.error_field_required));
			focusView = mUserView;
			cancel = true;
		}
		
		if (chkWipe.isChecked() && !chkServer.isChecked()) {
			mUserView.setError(getString(R.string.error_wipe_db));
			focusView = mUserView;
			cancel = true;
		}

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {


			if (chkServer.isChecked()){
				// Show a progress spinner, and kick off a background task to
				// perform the user login attempt.
				mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
				showProgress(true);
				mAuthTask = new UserLoginTask();
				mAuthTask.execute((Void) null);
			}
			else{
				// Inicia solicitud en la configuracion local
				ingresarLocal();
			}
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
			.alpha(show ? 1 : 0)
			.setListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					mLoginStatusView.setVisibility(show ? View.VISIBLE
							: View.GONE);
				}
			});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
			.alpha(show ? 0 : 1)
			.setListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					mLoginFormView.setVisibility(show ? View.GONE
							: View.VISIBLE);
				}
			});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<Void, Void, String> {
		@Override
		protected String doInBackground(Void... params) {
			String urlRequest = url + "/movil/ingreso/{mUser}";
			successLogin=false;
			// Agrega la autenticacion basica HTTP
			HttpAuthentication authHeader = new HttpBasicAuthentication(mUser, mPassword);
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setAuthorization(authHeader);
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			// Crea una nueva instancia de RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
			try {
				// Hace la solicitud a la red
				Log.d(TAG, urlRequest);
				ResponseEntity<UserSistema> userFromServer = restTemplate.exchange(urlRequest, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), UserSistema.class, mUser);
				urlRequest = url + "/movil/roles/{mUser}";
				ResponseEntity<Authority[]> userRolesFromServer = restTemplate.exchange(urlRequest, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Authority[].class, mUser);
				List<Authority> uroles = Arrays.asList(userRolesFromServer.getBody());
				
				successLogin=true;	
				ZikaPosAdapter ca = new ZikaPosAdapter(getApplicationContext(),mPassword,true, chkWipe.isChecked());
				ca.open();
				ca.borrarUsuarios();
				ca.borrarRoles();
				ca.crearUsuario(userFromServer.getBody());
				ListIterator<Authority> iter = uroles.listIterator();

				while (iter.hasNext()){
					ca.crearRol(iter.next());
				}
				ca.close();	
				return getString(R.string.success);
			} catch (Exception e) {
				successLogin=false;
				Log.e(TAG, e.getLocalizedMessage(), e);
				return e.getLocalizedMessage();
			}
		}

		@Override
		protected void onPostExecute(final String respuesta) {
			mAuthTask = null;
			showProgress(false);
			//Guarda username, password y presenta la actividad principal si valida en el servidor
			if (successLogin){
				Editor editor = settings.edit();
				editor.putString(PreferencesActivity.KEY_USERNAME, mUser);
				editor.commit();
				editor.putString(PreferencesActivity.KEY_SERVER_URL, url);
				editor.commit();
				finish();
				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(i);
			}
			else if(respuesta.contains("I/O error: failed to connect to")){
				mUrlView.setVisibility(View.VISIBLE);
				mUrlView
				.setError(getString(R.string.error_io_server));
				mUrlView.requestFocus();
			}
			else if(respuesta.contains("404")){
				mUrlView.setVisibility(View.VISIBLE);
				mUrlView
				.setError(getString(R.string.error_notfound_server));
				mUrlView.requestFocus();
			}
			else if(respuesta.contains("401")){
				mPasswordView
				.setError(getString(R.string.error_incorrect_password));
				mPasswordView.requestFocus();
			}
			else {
				mUserView
				.setError(respuesta);
				mUserView.requestFocus();
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}

	private void ingresarLocal() {
		//Presenta la actividad principal si valida localmente
		ZikaPosAdapter ca = new ZikaPosAdapter(getApplicationContext(),mPassword,false,chkWipe.isChecked());
		try{
			ca.open();
			UserSistema usuarioActual = ca.getUsuario(MainDBConstants.username  + "='" + mUser + "'", null);
			if(usuarioActual!=null){
				Editor editor = settings.edit();
				editor.putString(PreferencesActivity.KEY_USERNAME, usuarioActual.getUsername());
				editor.commit();
				editor.putString(PreferencesActivity.KEY_SERVER_URL, url);
				editor.commit();
				finish();
				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(i);
			}
			else{
				mUserView
				.setError(getString(R.string.error_invalid_user));
				mUserView.requestFocus();
			}
		}
		catch(SQLException e){
			mPasswordView
			.setError(getString(R.string.error_incorrect_password));
			mPasswordView.requestFocus();
		}
		catch(Exception e){
			mPasswordView
			.setError(e.getMessage());
			mPasswordView.requestFocus();
		}
		finally{
			ca.close();
		}
	}
	
	private void createDialog(int dialog) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		switch(dialog){
		case LIMPIAR:
			builder.setTitle(this.getString(R.string.confirm));
			builder.setMessage(this.getString(R.string.wipe_db_confirm));
			builder.setPositiveButton(this.getString(R.string.yes), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// Finish app
					dialog.dismiss();
				}
			});
			builder.setNegativeButton(this.getString(R.string.no), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// Do nothing
					chkWipe.setChecked(false);
					dialog.dismiss();
				}
			});
			break;
		default:
			break;
		}
		alertDialog = builder.create();
		alertDialog.show();
	}
	
}
