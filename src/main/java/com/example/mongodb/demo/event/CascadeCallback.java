package com.example.mongodb.demo.event;

import com.example.mongodb.demo.annotation.CascadeSave;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class CascadeCallback implements ReflectionUtils.FieldCallback {

    private Object source;
    private MongoOperations mongoOperations;

    CascadeCallback(final Object source, final MongoOperations mongoOperations) {
        this.source = source;
        this.setMongoOperations(mongoOperations);
    }

    @Override
    public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
        ReflectionUtils.makeAccessible(field);

        if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
            final Object fieldValue = field.get(getSource());
            if(fieldValue != null){
                if(List.class.equals(field.getType())){
                    for(Object obj : (List) fieldValue){
                        getMongoOperations().save(obj);
                    }
                }else if(Set.class.equals(field.getType())){
                    for(Object obj : (Set) fieldValue){
                        getMongoOperations().save(obj);
                    }
                }else{
                    if (fieldValue != null) {
                        final FieldCallback callback = new FieldCallback();
                        ReflectionUtils.doWithFields(fieldValue.getClass(), callback);
                        getMongoOperations().save(fieldValue);
                    }
                }
            }
        }
    }

    private Object getSource() {
        return source;
    }

    public void setSource(final Object source) {
        this.source = source;
    }

    private MongoOperations getMongoOperations() {
        return mongoOperations;
    }

    private void setMongoOperations(final MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
}