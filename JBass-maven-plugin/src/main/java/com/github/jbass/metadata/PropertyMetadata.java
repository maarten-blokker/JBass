package com.github.jbass.metadata;

/**
 *
 * @author MBlokker
 */
public class PropertyMetadata {

    private String type;
    private String name;
    private boolean pointer;
    private int arraySize;
    private String documentation;
    private String modifier;

    public PropertyMetadata() {
    }

    public PropertyMetadata(String type) {
        this.type = type;
    }

    public PropertyMetadata(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPointer() {
        return pointer;
    }

    public void setPointer(boolean pointer) {
        this.pointer = pointer;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "PropertyMetadata{" + "propertyType=" + type + ", propertyName=" + name + ", pointer=" + pointer + ", arraySize=" + arraySize + '}';
    }
}
