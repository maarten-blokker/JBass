package com.github.jbass.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MBlokker
 */
public class StructMetadata {

    private String name;
    private List<PropertyMetadata> properties = new ArrayList<>();

    public StructMetadata() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PropertyMetadata> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyMetadata> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "StructMetadata{" + "name=" + name + ", properties=" + properties + '}';
    }
}
