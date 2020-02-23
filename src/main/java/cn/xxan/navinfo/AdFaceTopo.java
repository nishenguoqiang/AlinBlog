package com.navinfo.dataservice.openapi.edit.service.glm.ad.face;

import com.navinfo.dataservice.openapi.edit.sdk.iface.IFaceTopo;
import com.navinfo.dataservice.openapi.edit.sdk.model.BasicRow;
import com.navinfo.dataservice.openapi.edit.sdk.util.CheckValueUtils;

/**
 * @ClassName: AdFaceTopo
 * @Author shenguoqiang
 * @Date 2018/5/15 20:50
 * @Description: AdFaceTopo.java
 */
public class AdFaceTopo extends BasicRow implements IFaceTopo{

    public AdFaceTopo(long objPid) {
        super(objPid);
    }

    protected long facePid = 0;

    protected int seqNum = 1;

    protected long linkPid = 0;

    public void setFacePid(long facePid) {
        if (CheckValueUtils.checkValue(this, "FACE_PID", this.facePid, facePid)) {
            this.facePid = facePid;
        }
    }

    public long getFacePid() {
        return facePid;
    }

    public void setSeqNum(int seqNum) {
        if (CheckValueUtils.checkValue(this, "SEQ_NUM", this.seqNum, seqNum)) {
            this.seqNum = seqNum;
        }
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setLinkPid(long linkPid) {
        if (CheckValueUtils.checkValue(this, "LINK_PID", this.linkPid, linkPid)) {
            this.linkPid = linkPid;
        }
    }

    public long getLinkPid() {
        return linkPid;
    }

    @Override
    public String tableName() {
        return "AD_FACE_TOPO";
    }

    public static final String FACE_PID = "FACE_PID";
    public static final String SEQ_NUM = "SEQ_NUM";
    public static final String LINK_PID = "LINK_PID";
}