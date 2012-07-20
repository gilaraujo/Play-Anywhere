package br.random;

import java.util.*;

import android.content.*;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.*;

class GroupInfo {
	public GroupInfo(String id, String campaign, String charName) {
		this.id = id; this.campaign = campaign; this.charName = charName;
	}
	private String id;
	public String getId() { return this.id; }
	private String campaign;
	public String getCampaign() { return this.campaign; }
	private String charName;
	public String getCharName() { return this.charName; }
}

public class CampaignExpAdapter extends BaseExpandableListAdapter
{
    /*-------------------------- Fields --------------------------*/
 
    private final HashMap<String, ArrayList<String>> myQuests = new HashMap<String, ArrayList<String>>();
    private final HashMap<Integer, String> lookUp = new HashMap<Integer, String>();
    private final ArrayList<GroupInfo> groups;
    private final Context context;
    private LayoutInflater inflater;
 
 
    /*-------------------------- Public --------------------------*/
 
    public CampaignExpAdapter(final Context con)
    {
        context = con;
        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        groups = new ArrayList<GroupInfo>();
    }
 
    public boolean AddGroup(final String[] group, final ArrayList<String> quests)
    {
    	final ArrayList<String> prev = myQuests.put(group[0], quests);
  
        if (prev != null)
            return false;
  
        lookUp.put(myQuests.size() - 1, group[0]);
        GroupInfo groupInfo = new GroupInfo(group[0],group[1],group[2]);
        groups.add(groupInfo);
        
        notifyDataSetChanged();
        return true;
    }
 
    public Object getChild(int groupPos, int childPos) 
    {
        if (lookUp.containsKey(groupPos))
        {
            final String str = lookUp.get(groupPos);
            final ArrayList<String> data = myQuests.get(str);
   
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
    	RelativeLayout relative = new RelativeLayout(context);
    	  
        View row = inflater.inflate(R.layout.campaign_list_subitem, null);
        TextView quest = (TextView)row.findViewById(R.id.quest_name);
        // Indent
  
        relative = new RelativeLayout(context);
        
        quest.setText("\t\t\t"+(String)getChild(groupPos, childPos));

        relative.addView(row);
  
        return relative;
    }
    
    public int getChildrenCount(int groupPos) 
    {
        if (lookUp.containsKey(groupPos))
            return myQuests.get(lookUp.get(groupPos)).size();

        return 0;
    }

    public Object getGroup(int groupPos) 
    {
        if (lookUp.containsKey(groupPos))
            return lookUp.get(groupPos);

        return null;
    }

    public int getGroupCount() 
    {
        return myQuests.size();
    }

    public long getGroupId(int groupPos) 
    {
        return 0;
    }

    public View getGroupView(int groupPos, boolean isExpanded, View convertView, ViewGroup parent) 
    {
    	RelativeLayout relative = new RelativeLayout(context);
  	  
        View row = inflater.inflate(R.layout.campaign_list_item, null);
        TextView campaignId = (TextView)row.findViewById(R.id.campaign_id);
        TextView campaignName = (TextView)row.findViewById(R.id.campaign_name);
        TextView charName = (TextView)row.findViewById(R.id.char_name);
        // Indent
  
        relative = new RelativeLayout(context);
        
        campaignId.setText(groups.get(groupPos).getId());
        campaignName.setText("\t\t\t" + groups.get(groupPos).getCampaign());
        charName.setText(groups.get(groupPos).getCharName());

        relative.addView(row);
  
        return relative;
    }

    public boolean hasStableIds() 
    {
        return false;
    }

    public boolean isChildSelectable(int groupPos, int childPos) 
    {
        return true;
    }
}