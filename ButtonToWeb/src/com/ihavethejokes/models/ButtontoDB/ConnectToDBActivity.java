package com.ihavethejokes.models.ButtontoDB;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public abstract class ConnectToDBActivity extends Activity {
	protected static DBInfo db;
	protected ImageButton dbCall;
	protected OutputActivity redirect;
	protected ProgressDialog pDialog;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		db = this.assignDB();
		//db & redirect are initialized here
	}	

	@Override
	protected void onDestroy(){
		runOnUiThread(new Runnable(){
			@Override
			public void run(){
				if(pDialog.isShowing()){
					pDialog.dismiss();
				}
			}
		});
		super.onDestroy();
	}
	public OnClickListener setUpDBCall(){
		return new OnClickListener(){

			@Override
			public void onClick(View v){
				ConnectToDBActivity.this._changeImage();
				new RowsetResult().execute("");
			}
		};
	}
	
	protected Bundle _doStuff(){
		return new Bundle();
	}
	protected void _changeImage(){}
	
	protected abstract DBInfo assignDB();
	/**
	 * Background Async Task to Load data by making HTTP Request
	 * */
	class RowsetResult extends AsyncTask<String, String, String> {

		ConnectToDBActivity parent = ConnectToDBActivity.this;
		ProgressDialog ppDialog = parent.pDialog;
		JSONParser jParser = new JSONParser();
		JSONObject json;
		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute(); 
			ppDialog = new ProgressDialog(parent);
			ppDialog.setMessage("Getting Entries. Please wait...");
			ppDialog.setIndeterminate(false);
			ppDialog.setCancelable(false);
			ppDialog.show();
		}	

		/**
		 * getting All data from url
		 * */
		@Override
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// getting JSON string from URL
			json = jParser.makeHttpRequest(db.getFunction("get_db_entry.php"), "GET", params);

			// Check your log cat for JSON reponse
			Log.d("All Products: ", json.toString());

			try {
				// Checking for SUCCESS TAG
				int success = json.getInt(DBInfo.TAG_SUCCESS);

				if (success == 1) {
					ConnectToDBActivity.db.parseData(json.getJSONArray(db.TAG_TYPE));
				} else {
					ppDialog.dismiss();
					Toast.makeText(parent, "Unable to connect", Toast.LENGTH_LONG).show();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}


		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// updating UI from Background Thread
			runOnUiThread(new Runnable() {
				public void run() {
					// dismiss the dialog after getting all products
					if(ppDialog.isShowing()){
						ppDialog.dismiss();
					}
					Intent intent = new Intent(parent, parent.redirect.getClass());
					intent.putExtras(ConnectToDBActivity.this._doStuff());
					parent.startActivity(intent);
				}
			});
		}
	}
}
