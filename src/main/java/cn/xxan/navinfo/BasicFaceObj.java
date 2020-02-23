package com.navinfo.dataservice.openapi.edit.service.bo.relation;

import com.navinfo.dataservice.openapi.edit.sdk.iface.IFace;
import com.navinfo.dataservice.openapi.edit.sdk.iface.IFaceTopo;
import com.navinfo.dataservice.openapi.edit.sdk.model.BasicObj;
import com.navinfo.dataservice.openapi.edit.sdk.model.BasicRow;
import com.navinfo.dataservice.openapi.edit.service.bo.geo.BasicLinkObj;

import java.util.*;

/**
 * @ClassName: BasicFaceObj
 * @Author shenguoqiang
 * @Date 2018/5/18 10:10
 * @Description: 1.行政区背景面、土地利用 、土地覆盖、zone 、cmg等要素面的维护
 *          2.继承本类的obj，对应要素的face模型需要实现IFace接口，拓扑关系模型需要实现IFaceTopo接口
 */
public abstract class BasicFaceObj extends BasicRelationObj{
    public BasicFaceObj(BasicRow mainrow) {
        super(mainrow);
    }

    public abstract List<IFaceTopo> getFaceTopos();
    public abstract IFaceTopo createFaceTopo() throws Exception;

    @Override
    public <T extends BasicObj> void breaks(Map<T, List<T>> map) throws Exception {
        IFace iFace = (IFace)this.mainrow;

        Map<Integer,Long> faceToposMap = this.getFaceToposMap();//key为linkPid，value为SeqNum

        for(Map.Entry<T, List<T>> entry:map.entrySet()){
            BasicLinkObj targetLink = (BasicLinkObj)entry.getKey();
            List<BasicLinkObj> newLinks = (List<BasicLinkObj>)entry.getValue();

            int seqNum = getKeyByValue(faceToposMap,targetLink.LinkPid());
            long previousLinkPid = 0;
            if (seqNum>1){
                previousLinkPid = faceToposMap.get(seqNum-1);
            } else if(seqNum==1){
                previousLinkPid = Collections.max(faceToposMap.keySet());
            }




            //需要计算新生成的link的seqNum序号


            for (BasicLinkObj basicLinkObj :newLinks){
                IFaceTopo faceTopo = createFaceTopo();
                faceTopo.setLinkPid(basicLinkObj.LinkPid());
                faceTopo.setSeqNum(seqNum);
            }

        }
    }

    @Override
    public <T extends BasicObj> void repairs(List<T> list) throws Exception {

    }

    @Override
    public <T extends BasicObj> void deletes(List<T> list) throws Exception {
        IFace iFace = (IFace)this.mainrow;
        List<IFaceTopo> faceTopos = this.getFaceTopos();

        for (BasicObj basicObj :list) {
            BasicLinkObj basicLinkObj = (BasicLinkObj)basicObj;
            for (IFaceTopo iFaceTopo:faceTopos){
                if (iFaceTopo.getLinkPid()==basicLinkObj.LinkPid()){
                    this.deleteObj();
                }
            }

        }
    }

    @Override
    public <T extends BasicObj> void updates(List<T> list) throws Exception {

    }

    public Map<Integer,Long> getFaceToposMap(){
        Map<Integer,Long> map = new TreeMap<>();
        List<IFaceTopo> faceTopos = this.getFaceTopos();
        for (IFaceTopo iFaceTopo:faceTopos){
            map.put(Integer.valueOf(iFaceTopo.getSeqNum()),iFaceTopo.getLinkPid());
        }
        return map;
    }

    public int getKeyByValue(Map<Integer,Long> treeMap,long value){
        int key = 0;
        for (Map.Entry<Integer,Long> entry:treeMap.entrySet()){
            if (entry.getValue()==value){
                key = entry.getKey();
            }
        }
        return key;
    }



}