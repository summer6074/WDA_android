package android.icommunity.utility;

/**
 * Created by Administrator on 2014/9/14.
 */
public class RepairInfoList {

    private String mRepairContent = null;
    private String mRepairTime = null;
    private String mRepairContacter = null;
    private String mRepairPhone = null;
    private String mRepairPostTime = null;
    private Boolean mRepirStatus = false;

    public void SetRepairContent(String content)
    { mRepairContent = content; }

    public void SetRepairTime(String repairTime)
    { mRepairTime = repairTime; }

    public void SetRepairContacter(String repairContacter)
    { mRepairContacter = repairContacter; }

    public void SetRepairPhone(String repairPhone)
    { mRepairPhone = repairPhone; }

    public void SetRepairPostTime(String repairPostTime)
    { mRepairPostTime = repairPostTime; }

    public void SetmRepirStatus(Boolean status)
    { mRepirStatus = status; }

    public String GetRepairContent()
    { return mRepairContent; }

    public String GetRepairTime()
    { return mRepairTime; }

    public String GetRepairContacter()
    { return mRepairContacter; }

    public String GetRepairPhone()
    { return mRepairPhone; }

    public String GetRepairPostTime()
    { return mRepairPostTime; }

    public Boolean GetRepairStatus()
    { return mRepirStatus; }
}
