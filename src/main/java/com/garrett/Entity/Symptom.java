package com.garrett.Entity;

import java.util.List;

public class Symptom extends Entity {
    public Symptom(List<List<String>> dataList, String relName ) {
        super(dataList, relName);
        extractEntity();
    }

    @Override
    public void extractEntity() {
        for(List<String> l : dataList) {
            if(l.get(0).equalsIgnoreCase(relName)) {
                entityMap.put(l.get(5), l.get(6));
            }
            else
                continue;
        }
    }
}
