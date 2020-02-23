package com.navinfo.dataservice.openapi.edit.sdk.iface;

import com.vividsolutions.jts.geom.Geometry;

/**
 * @ClassName: IFace
 * @Author shenguoqiang
 * @Date 2018/5/18 10:28
 * @Description: IFace.java
 */
public interface IFace {
    public long getFacePid();
    public void setFacePid(long facePid);

    public double getArea();
    public void setArea(double area);

    public double getPerimeter();
    public void setPerimeter(double perimeter);

    public Geometry getGeometry();
    public void setGeometry(Geometry geometry);

    public int getMeshId();
    public void setMeshId(int meshId);
}
