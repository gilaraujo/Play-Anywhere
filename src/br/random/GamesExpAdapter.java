package br.random;

import java.util.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.*;

public class GamesExpAdapter extends BaseExpandableListAdapter
{
    /*-------------------------- Fields --------------------------*/
 
    private final HashMap<String, ArrayList<String>> myData = new HashMap<String, ArrayList<String>>();
    private final HashMap<Integer, String> lookUp = new HashMap<Integer, String>();
    private final Context context;
 
 
 
    /*-------------------------- Public --------------------------*/
 
    public GamesExpAdapter(final Context con)
    {
        context = con;
    }
 
    public boolean AddGroup(final String groupName, final ArrayList<String> list)
    {
        final ArrayList<String> prev = myData.put(groupName, list);
  
        if (prev != null)
            return false;
  
        lookUp.put(myData.size() - 1, groupName);
  
        notifyDataSetChanged();
        return true;
    }
 
    public Object getChild(int groupPos, int childPos) 
    {
        if (lookUp.containsKey(groupPos))
        {
            final String str = lookUp.get(groupPos);
            final ArrayList<String> data = myData.get(str);
   
            return data.get(childPos);
        }
  
        return null;
    }

    public long getChildId(int groupPos, int childPos) 
    {  
        return 0;
    }

    public View getChildView(int groupPos, int childPos, boolean isLastChild, 
                             View convertView, ViewGroup parent) 
    {
        LinearLayout linear = new LinearLayout(context);
  
        final LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
  
        TextView text = new TextView(context);
  
        // Indent
        final String str = "\t\t\t" + (String)getChild(groupPos, childPos);
  
        linear = new LinearLayout(context);
        linear.setOrientation(LinearLayout.VERTICAL);
  
        text.setLayoutParams(params);
        text.setText(str);
        linear.addView(text);
  
        return linear;
    }

    public int getChildrenCount(int groupPos) 
    {
        if (lookUp.containsKey(groupPos))
            return myData.get(lookUp.get(groupPos)).size();

        return 0;
    }

    public Object getGroup(int groupPos) 
    {
        if (lookUp.containsKey(groupPos))
            return myData.get(lookUp.get(groupPos));

        return null;
    }

    public int getGroupCount() 
    {
        return myData.size();
    }

    public long getGroupId(int groupPos) 
    {
        return 0;
    }

    public View getGroupView(int groupPos, boolean isExpanded, View convertView, ViewGroup parent) 
    {
        LinearLayout linear = new LinearLayout(context);
  
        final LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
  
        TextView text = new TextView(context);
  
        // Push the group name slightly to the right for drop down icon
        final String str = "\t\t" + lookUp.get(groupPos);
  
        linear = new LinearLayout(context);
        linear.setOrientation(LinearLayout.VERTICAL);
  
        text.setLayoutParams(params);
        text.setText(str);
        text.setTextSize(18.0f);
        linear.addView(text);
  
        return linear;
    }

    public boolean hasStableIds() 
    {
        return false;
    }

    public boolean isChildSelectable(int groupPos, int childPos) 
    {
        return false;
    }
}