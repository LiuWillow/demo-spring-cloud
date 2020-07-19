package com.lwl.websocket.component;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wangjiawei
 * @date 2020/5/27
 **/
public class LongToStringCodec implements ObjectSerializer, ObjectDeserializer {
    private static LongToStringCodec instance = new LongToStringCodec();

    public static LongToStringCodec getInstance() {
        return instance;
    }



    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;

        if (object == null) {
            out.writeNull(SerializerFeature.WriteNullNumberAsZero);
        } else {
            String value = ((Long) object).toString();
            out.writeString(value);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        final JSONLexer lexer = parser.lexer;

        Long longObject;
        try {
            final int token = lexer.token();
            if (token == JSONToken.LITERAL_INT) {
                long longValue = lexer.longValue();
                lexer.nextToken(JSONToken.COMMA);
                longObject = Long.valueOf(longValue);
            } else if (token == JSONToken.LITERAL_FLOAT) {
                BigDecimal number = lexer.decimalValue();
                longObject = TypeUtils.longValue(number);
                lexer.nextToken(JSONToken.COMMA);
            } else {
                if (token == JSONToken.LBRACE) {
                    JSONObject jsonObject = new JSONObject(true);
                    parser.parseObject(jsonObject);
                    longObject = TypeUtils.castToLong(jsonObject);
                } else {
                    Object value = parser.parse();

                    longObject = TypeUtils.castToLong(value);
                }
                if (longObject == null) {
                    return null;
                }
            }
        } catch (Exception ex) {
            throw new JSONException("parseLong error, field : " + fieldName, ex);
        }

        return clazz == AtomicLong.class
                ? (T) new AtomicLong(longObject.longValue())
                : (T) longObject;
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
