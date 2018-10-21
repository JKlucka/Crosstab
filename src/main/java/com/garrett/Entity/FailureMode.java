package com.garrett.Entity;

import java.util.List;

public class FailureMode extends Entity {
    public FailureMode(List<List<String>> dataList, String relName ) {
        super(dataList, relName);
        extractEntity();
    }

    @Override
    public void extractEntity() {
        for(List<String> l : dataList) {
            if(l.get(0).equalsIgnoreCase(relName)) {
                entityMap.put(l.get(3), l.get(2));
            }
            else
                continue;
        }
    }

}