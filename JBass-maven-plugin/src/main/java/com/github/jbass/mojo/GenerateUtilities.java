package com.github.jbass.mojo;

import com.github.jbass.metadata.PropertyMetadata;

/**
 *
 * @author Maarten
 */
public class GenerateUtilities {

    public static String getJavaType(PropertyMetadata metadata) {
        String type = metadata.getType();
        switch (type) {
            case "BOOL":
                type = "boolean";
                break;
            case "DWORD":
            case "HMUSIC":
            case "HSAMPLE":
            case "HCHANNEL":
            case "HSTREAM":
            case "HRECORD":
            case "HSYNC":
            case "HDSP":
            case "HFX":
            case "HPLUGIN":
            case "HWND":
            case "GUID":
                type = "int";
                break;
            case "QWORD":
                type = "long";
                break;
        }

        if (type.equals("char") && metadata.isPointer()) {
            type = "String";
        } else if (type.equals("void") && metadata.isPointer()) {
            type = "ByteBuffer";
        }

        return type;
    }
}
