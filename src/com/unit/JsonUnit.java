package com.unit;

/**
 * Created by hadoop on 16-8-23.
 */
public class JsonUnit {
    private StringBuffer stringBuffer;

    public JsonUnit() {
        stringBuffer = new StringBuffer();
        stringBuffer.append("{");
    }

    public void add(String key,Object value){
        stringBuffer.append(key);
        stringBuffer.append(":");
        stringBuffer.append(value);
        stringBuffer.append(",");
    }
    public String getJson(){
        stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length()-1);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

}
