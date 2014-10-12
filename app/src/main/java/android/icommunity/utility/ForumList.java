package android.icommunity.utility;

/**
 * Created by Administrator on 2014/9/3.
 */
public class ForumList {

    private String mTitle = null;
    private String mPoster = null;
    private String mTime = null;
    private String mReplyNum = null;

    public void SetTitle(String title)
    { mTitle = title; }

    public void SetPoster(String poster)
    { mPoster = poster; }

    public void SetTime(String time)
    { mTime = time; }

    public void SetReplyNum(String replyNum)
    { mReplyNum = replyNum; }

    public String GetTitle()
    { return mTitle; }

    public String GetPoster()
    {
        return mPoster;
    }

    public String GetTime()
    {
        return mTime;
    }

    public String GetReplyNum()
    { return mReplyNum; }
}