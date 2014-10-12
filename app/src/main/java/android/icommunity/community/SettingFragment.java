package android.icommunity.community;

import android.app.Fragment;
import android.content.Intent;
import android.icommunity.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2014/9/2.
 */
public class SettingFragment extends Fragment {

    private LinearLayout info_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_layout, container, false);
        info_layout = (LinearLayout)view.findViewById(R.id.setting_layout_1);
        info_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(getActivity(), SettingPersonalInfoDetail.class);
                startActivity(infoIntent);
            }
        });
        return view;
    }
}
