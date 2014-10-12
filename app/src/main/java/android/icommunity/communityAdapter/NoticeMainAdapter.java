package android.icommunity.communityAdapter;

import android.content.Context;
import android.icommunity.R;
import android.icommunity.utility.ForumList;
import android.icommunity.utility.NoticeList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2014/9/14.
 */
public class NoticeMainAdapter extends BaseAdapter{
    private Context mContext;
    private List<NoticeList> mNotice;
    private LayoutInflater mInflater;

    public NoticeMainAdapter(Context context, List<NoticeList> mDatas)
    {
        mContext = context;
        this.mNotice = mDatas;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount()
    {
        return mNotice.size();
    }

    public Object getItem(int position)
    {
        return  mNotice.get(position);
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
            convertView = mInflater.inflate(R.layout.noticeitem_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mTitle = (TextView)convertView.findViewById(R.id.notice_title);
            viewHolder.mTime = (TextView)convertView.findViewById(R.id.notice_time);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.mTitle.setText(mNotice.get(position).GetTitle());
        viewHolder.mTime.setText(mNotice.get(position).GetTime());
        return convertView;
    }

    private final class ViewHolder
    {
        TextView mTitle;
        TextView mTime;
    }
}
