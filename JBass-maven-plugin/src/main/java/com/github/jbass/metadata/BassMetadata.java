package com.github.jbass.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maarten
 */
public class BassMetadata {

    private List<StructMetadata> structMetadata = new ArrayList<>();
    private List<FunctionMetadata> functionMetadata = new ArrayList<>();
    private List<CallbackMetadata> callbackMetadata = new ArrayList<>();

    public List<StructMetadata> getStructMetadata() {
        return structMetadata;
    }

    public void setStructMetadata(List<StructMetadata> structMetadata) {
        this.structMetadata = structMetadata;
    }

    public List<FunctionMetadata> getFunctionMetadata() {
        return functionMetadata;
    }

    public void setFunctionMetadata(List<FunctionMetadata> functionMetadata) {
        this.functionMetadata = functionMetadata;
    }

    public List<CallbackMetadata> getCallbackMetadata() {
        return callbackMetadata;
    }

    public void setCallbackMetadata(List<CallbackMetadata> callbackMetadata) {
        this.callbackMetadata = callbackMetadata;
    }

}
