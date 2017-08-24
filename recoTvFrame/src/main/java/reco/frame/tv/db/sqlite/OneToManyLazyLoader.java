package reco.frame.tv.db.sqlite;


import java.util.ArrayList;
import java.util.List;

import reco.frame.tv.TvDb;

/**
*

*/
public class OneToManyLazyLoader<O,M> {
    O ownerEntity;
    Class<O> ownerClazz;
    Class<M> listItemClazz;
    TvDb db;
    public OneToManyLazyLoader(O ownerEntity,Class<O> ownerClazz,Class<M> listItemclazz,TvDb db){
        this.ownerEntity = ownerEntity;
        this.ownerClazz = ownerClazz;
        this.listItemClazz = listItemclazz;
        this.db = db;
    }
    List<M> entities;

    /**
     * �������δ���أ������loadOneToMany�������
     * @return
     */
    public List<M> getList(){
        if(entities==null){
            this.db.loadOneToMany((O)this.ownerEntity,this.ownerClazz,this.listItemClazz);
        }
        if(entities==null){
            entities =new ArrayList<M>();
        }
        return entities;
    }
    public void setList(List<M> value){
        entities = value;
    }

}
