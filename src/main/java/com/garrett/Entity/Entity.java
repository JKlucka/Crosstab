package com.garrett.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entity {
    protected List<List<String>> dataList;
    protected Map<String, String> entityMap = new HashMap<>();
    protected String relName;

    public Entity(List<List<String>> dataList, String relName) {
        this.relName = relName;
        this.dataList = dataList;
    }

    public abstract void extractEntity();

    public Map<String, String> getEntityMap() {
        return entityMap;
    }

    public void showMap() {
        for(Map.Entry<String, String> entry : entityMap.entrySet()) {
            System.out.println(this.getClass().getName() + " - " + entry.getKey() + " : " + entry.getValue());
        }

    }
}
