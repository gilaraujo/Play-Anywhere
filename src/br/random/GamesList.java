package br.random;

import com.actionbarsherlock.app.SherlockListActivity;

import br.random.DatabaseHelper;
import android.annotation.SuppressLint;
import android.app.*;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class GamesList extends SherlockListActivity {
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected SimpleExpandableListAdapter adapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameslist);
        getSherlock().getActionBar().setDisplayHomeAsUpEnabled(true);
/*        
        db = (new DatabaseHelper(this)).getWritableDatabase();
        
        cursor = db.rawQuery("SELECT idchar _id, name, story FROM tbchars",
				new String[]{ });
		adapter = new SimpleExpandableListAdapter(this, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom, groupTo, childData, childLayout, childFrom, childTo)
				
				SimpleCursorAdapter(
		this, 
		R.layout.game_list_item, 
		cursor, 
		new String[] {"_id", "name", "story"},
		new int[] {R.id.char_id, R.id.char_name, R.id.char_story});
		setListAdapter(adapter);
		
		for (int i=0;i<cursor.getCount();i++) {
			ListView listView = (ListView)this.getListAdapter().getView(i, null, null).findViewById(R.id.listView1);
			SQLiteDatabase db2 = (new DatabaseHelper(getApplicationContext())).getWritableDatabase();
			Cursor cursor2 = db2.rawQuery("SELECT idchar _id, story, name FROM tbchars",
					new String[]{ });
			View item = inflater.inflate(R.layout.game_list_item, null);
			TextView story = (TextView)item.findViewById(R.id.char_story);
			story.setText("tjeoisjt");
			listView.addView(item);
		}
*/
		this.getListView().setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
/*				SQLiteDatabase db2 = (new DatabaseHelper(getApplicationContext())).getWritableDatabase();
				Cursor cursor2 = db2.rawQuery("SELECT idchar _id, name, story FROM tbchars",
						new String[]{ });
				ListAdapter adapter2 = new SimpleCursorAdapter(
						getApplicationContext(), 
						R.layout.game_list_item, 
						cursor2, 
						new String[] {"_id", "name", "story"}, 
						new int[] {R.id.char_id, R.id.char_name, R.id.char_story});
				
				ListView listView = (ListView)arg1.findViewById(R.id.listView1);
				listView.getChildAt();
				listView.setAdapter(adapter2);
				adapter2.notifyDataSetChanged();*/
				
				/*for (int i=0;i<cursor2.getCount();i++) {
					View item = inflater.inflate(R.layout.game_list_item, null);
					TextView story = (TextView)findViewById(R.id.char_story);
					story.setText("foidjfo");
					listView.addView(item);
				}*/
			}
		});
		db.close();
	}
}
