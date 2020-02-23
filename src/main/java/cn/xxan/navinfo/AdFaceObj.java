package com.navinfo.dataservice.openapi.edit.service.bo.ad;

import com.navinfo.dataservice.openapi.edit.sdk.exception.ObjCreateException;
import com.navinfo.dataservice.openapi.edit.sdk.exception.WrongOperationException;
import com.navinfo.dataservice.openapi.edit.sdk.iface.IFaceTopo;
import com.navinfo.dataservice.openapi.edit.sdk.model.BasicRow;
import com.navinfo.dataservice.openapi.edit.sdk.model.ObjType;
import com.navinfo.dataservice.openapi.edit.service.bo.ObjName;
import com.navinfo.dataservice.openapi.edit.service.bo.relation.BasicFaceObj;
import com.navinfo.dataservice.openapi.edit.service.glm.ad.face.AdFaceTopo;

import java.util.List;

/**
 * @ClassName: AdFaceObj
 * @Author shenguoqiang
 * @Date 2018/5/15 20:50
 * @Description: AdFaceObj.java
 */
public class AdFaceObj extends BasicFaceObj {

    public AdFaceObj(BasicRow mainrow) {
        super(mainrow);
    }

    @Override
    public List<IFaceTopo> getFaceTopos() {
        return (List) getRowsByName(AD_FACE_TOPO);
    }


    @Override
    public IFaceTopo createFaceTopo() throws WrongOperationException,ObjCreateException {
        IFaceTopo iFaceTopo = (AdFaceTopo)createSubRow(AD_FACE_TOPO);
        return iFaceTopo;
    }

    @Override
    public String objName() {
        return ObjName.AD_FACE;
    }

    @Override
    public String objType() {
        return ObjType.FEATURE;
    }

    public static final String AD_FACE = "AD_FACE";
    public static final String AD_FACE_TOPO = "AD_FACE_TOPO";
}