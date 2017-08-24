package reco.frame.tv.db.sqlite;

import reco.frame.tv.TvDb;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by pwy on 13-7-25.
 */
public class ManyToOneLazyLoader<M,O> {
    M manyEntity;
    Class<M> manyClazz;
    Class<O> oneClazz;
    TvDb db;
    /**
     * ??��??
     */
    private Object fieldValue;
    public ManyToOneLazyLoader(M manyEntity, Class<M> manyClazz, Class<O> oneClazz, TvDb db){
        this.manyEntity = manyEntity;
        this.manyClazz = manyClazz;
        this.oneClazz = oneClazz;
        this.db = db;
    }
    O oneEntity;
    boolean hasLoaded = false;

    /**
     * �??????��????????载�?????�????loadManyToOne�??????��??
     * @return
     */
    public O get(){
        if(oneEntity==null && !hasLoaded){
            this.db.loadManyToOne(null,this.manyEntity,this.manyClazz,this.oneClazz);
            hasLoaded = true;
        }
        return oneEntity;
    }
    public void set(O value){
        oneEntity = value;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
}
