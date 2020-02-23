package com.navinfo.dataservice.openapi.edit.service.bo.ad;

import com.navinfo.dataservice.openapi.edit.sdk.iface.IFaceTopo;
import com.navinfo.dataservice.openapi.edit.sdk.model.BasicRow;
import com.navinfo.dataservice.openapi.edit.sdk.model.ObjType;
import com.navinfo.dataservice.openapi.edit.service.bo.ObjName;
import com.navinfo.dataservice.openapi.edit.service.bo.relation.BasicFaceObj;

import java.util.List;

/**
 * @ClassName: ZoneFaceObj
 * @Author shenguoqiang
 * @Date 2018/5/15 20:50
 * @Description: ZoneFaceObj.java
 */
public class ZoneFaceObj extends BasicFaceObj {

    public ZoneFaceObj(BasicRow mainrow) {
        super(mainrow);
    }

    @Override
    public List<IFaceTopo> getFaceTopos() {
        return (List) getRowsByName(ZONE_FACE_TOPO);
    }

    @Override
    public IFaceTopo createFaceTopo() throws Exception {
        return null;
    }

    @Override
    public String objName() {
        return ObjName.ZONE_FACE;
    }

    @Override
    public String objType() {
        return ObjType.FEATURE;
    }

    public static final String ZONE_FACE = "ZONE_FACE";
    public static final String ZONE_FACE_TOPO = "ZONE_FACE_TOPO";
}