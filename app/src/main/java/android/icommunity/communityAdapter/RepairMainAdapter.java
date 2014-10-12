package android.icommunity.communityAdapter;

import android.content.Context;
import android.icommunity.R;
import android.icommunity.utility.RepairInfoList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2014/9/14.
 */
public class RepairMainAdapter extends BaseAdapter {
    private Context mContext;
    private List<RepairInfoList> mRepairInfo;
    private LayoutInflater mInflater;

    public RepairMainAdapter(Context context, List<RepairInfoList> mDatas)
    {
        mContext = context;
        this.mRepairInfo = mDatas;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount()
    {
        return mRepairInfo.size();
    }

    public Object getItem(int position)
    {
        return  mRepairInfo.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.needrepairitem_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mRepairContent = (TextView)convertView.findViewById(R.id.repair_content);
            viewHolder.mRepairTime = (TextView)convertView.findViewById(R.id.repair_time);
            viewHolder.mRepairContacter = (TextView)convertView.findViewById(R.id.repair_contacter);
            viewHolder.mRepairPhone = (TextView)convertView.findViewById(R.id.repair_phone);
            viewHolder.mRepairPostTime = (TextView)convertView.findViewById(R.id.repair_poste_time);
            viewHolder.mRepirStatus = (TextView)convertView.findViewById(R.id.repair_status);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.mRepairContent.setText(mRepairInfo.get(position).GetRepairContent());
        viewHolder.mRepairTime.setText(mRepairInfo.get(position).GetRepairTime());
        viewHolder.mRepairContacter.setText(mRepairInfo.get(position).GetRepairContacter());
        viewHolder.mRepairPhone.setText(mRepairInfo.get(position).GetRepairPhone());
        viewHolder.mRepairPostTime.setText(mRepairInfo.get(position).GetRepairPostTime());
        if(mRepairInfo.get(position).GetRepairStatus() == true)
        {
            viewHolder.mRepirStatus.setText("已受理");
        }
        else
        {
            viewHolder.mRepirStatus.setText("正在受理中");
        }
        return convertView;
    }

    private final class ViewHolder
    {
        TextView mRepairContent;
        TextView mRepairTime;
        TextView mRepairContacter;
        TextView mRepairPhone;
        TextView mRepairPostTime;
        TextView mRepirStatus;
    }
}
