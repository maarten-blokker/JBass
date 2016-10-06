package com.github.jbass.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MBlokker
 */
public class FunctionMetadata {

    private PropertyMetadata result;
    private String name;
    private List<PropertyMetadata> parameters = new ArrayList<>();
    private String documentation;

    public FunctionMetadata() {
    }

    public PropertyMetadata getResult() {
        return result;
    }

    public void setResult(PropertyMetadata result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PropertyMetadata> getParameters() {
        return parameters;
    }

    public void setParameters(List<PropertyMetadata> parameters) {
        this.parameters = parameters;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    @Override
    public String toString() {
        return "FunctionMetadata{" + "result=" + result + ", name=" + name + ", parameters=" + parameters + '}';
    }

}
