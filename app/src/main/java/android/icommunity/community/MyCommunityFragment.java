package android.icommunity.community;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icommunity.R;
import android.icommunity.communityAdapter.ImageAdapter;
import android.icommunity.utility.DataItem;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/9/2.
 */
public class MyCommunityFragment extends Fragment {
    private int[] imageIds = new int[]{
            R.drawable.bx_icon_selector , R.drawable.ts_icon_selector, R.drawable.fw_icon_selector
    };

    private String[] imageName = new String[]{
            "报修服务", "投诉建议", "定制服务"
    };

    private ArrayList<DataItem.Category> items = new ArrayList<DataItem.Category>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mycommunity_layout, container, false);
        GridView gridview = (GridView)view.findViewById(R.id.gridview);
        for (int i = 0; i < imageIds.length; i++)
        {
            DataItem.Category item = new DataItem.Category();
            Drawable drawable = getResources().getDrawable(imageIds[i]);
            item.dataName = imageName[i];
            item.drawable = drawable;
            items.add(item);
        }

        ImageAdapter imageAdapter = new ImageAdapter(inflater, items);
        gridview.setAdapter(imageAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //报修
                        Intent noticeIntent = new Intent(getActivity(), NeedRepairMainActivity.class);
                        startActivity(noticeIntent);
                        break;
                    case 1:
                        Intent complaintIntent = new Intent(getActivity(), ComplainActivity.class);
                        startActivity(complaintIntent);
                        break;
                    case 2:
                        Toast.makeText(getActivity(), imageName[2], Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getActivity(), "其他", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return view;
    }


}
