package android.icommunity.communityAdapter;

import android.content.Context;
import android.icommunity.R;
import android.icommunity.utility.ForumList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2014/9/3.
 */
public class ForumMainAdatper extends BaseAdapter {
    private Context mContext;
    private List<ForumList> mDatas;
    private LayoutInflater mInflater;

    public ForumMainAdatper(Context context, List<ForumList> mDatas)
    {
        mContext = context;
        this.mDatas = mDatas;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount()
    {
        return mDatas.size();
    }

    public Object getItem(int position)
    {
        return  mDatas.get(position);
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
            convertView = mInflater.inflate(R.layout.forumitem_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mTitle = (TextView)convertView.findViewById(R.id.tv_title);
            viewHolder.mPoster = (TextView)convertView.findViewById(R.id.tv_poster);
            viewHolder.mTime = (TextView)convertView.findViewById(R.id.tv_time);
            viewHolder.mReplyNum = (TextView)convertView.findViewById(R.id.tv_replynum);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.mTitle.setText(mDatas.get(position).GetTitle());
        viewHolder.mPoster.setText(mDatas.get(position).GetPoster());
        viewHolder.mTime.setText(mDatas.get(position).GetTime());
        viewHolder.mReplyNum.setText(mDatas.get(position).GetReplyNum());
        return convertView;
    }

    private final class ViewHolder
    {
        TextView mTitle;
        TextView mPoster;
        TextView mTime;
        TextView mReplyNum;
    }
}
