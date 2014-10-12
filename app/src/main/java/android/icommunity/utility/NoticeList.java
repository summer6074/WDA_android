package android.icommunity.utility;

/**
 * Created by Administrator on 2014/9/14.
 */
public class NoticeList {

    private String mTitle = null;
    private String mTime = null;

    public void SetTitle(String title)
    { mTitle = title; }

    public void SetTime(String time)
    { mTime = time; }

    public String GetTitle()
    { return mTitle; }

    public String GetTime()
    {
        return mTime;
    }

}
