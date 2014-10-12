package android.icommunity.communityAdapter;

import android.icommunity.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.icommunity.utility.DataItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/9/2.
 */
public class ImageAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<DataItem.Category> items;

    public ImageAdapter(LayoutInflater inflater, ArrayList<DataItem.Category> items) {
        this.inflater = inflater;
        this.items = items;
    }

    public int getCount()
    {
        return items.size();
    }

    @Override
    public DataItem.Category getItem(int position)
    {
        // 根据screenNo计算第position个列表项的数据
        return items.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position , View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (convertView == null)
        {
            view = inflater.inflate(R.layout.gridviewlisticon, null);
        }
        ImageView imageView = (ImageView)view.findViewById(R.id.imageview);
        imageView.setImageDrawable(getItem(position).drawable);
        TextView textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(getItem(position).dataName);
        return view;
    }
}
