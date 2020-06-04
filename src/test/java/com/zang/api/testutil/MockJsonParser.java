package com.zang.api.testutil;

import org.codehaus.jackson.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;


public class MockJsonParser extends JsonParser {

    private String text;

    public MockJsonParser(String text) {
        this.text = text;
    }


    @Override
    public ObjectCodec getCodec() {
        return null;
    }

    @Override
    public void setCodec(ObjectCodec objectCodec) {

    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public JsonToken nextToken() throws IOException, JsonParseException {
        return null;
    }

    @Override
    public JsonParser skipChildren() throws IOException, JsonParseException {
        return null;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public String getCurrentName() throws IOException, JsonParseException {
        return null;
    }

    @Override
    public JsonStreamContext getParsingContext() {
        return null;
    }

    @Override
    public JsonLocation getTokenLocation() {
        return null;
    }

    @Override
    public JsonLocation getCurrentLocation() {
        return null;
    }

    @Override
    public String getText() throws IOException, JsonParseException {
        return text;
    }

    @Override
    public char[] getTextCharacters() throws IOException, JsonParseException {
        return new char[0];
    }

    @Override
    public int getTextLength() throws IOException, JsonParseException {
        return 0;
    }

    @Override
    public int getTextOffset() throws IOException, JsonParseException {
        return 0;
    }

    @Override
    public Number getNumberValue() throws IOException, JsonParseException {
        return null;
    }

    @Override
    public NumberType getNumberType() throws IOException, JsonParseException {
        return null;
    }

    @Override
    public int getIntValue() throws IOException, JsonParseException {
        return 0;
    }

    @Override
    public long getLongValue() throws IOException, JsonParseException {
        return 0;
    }

    @Override
    public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
        return null;
    }

    @Override
    public float getFloatValue() throws IOException, JsonParseException {
        return 0;
    }

    @Override
    public double getDoubleValue() throws IOException, JsonParseException {
        return 0;
    }

    @Override
    public BigDecimal getDecimalValue() throws IOException, JsonParseException {
        return null;
    }

    @Override
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        return new byte[0];
    }
}
