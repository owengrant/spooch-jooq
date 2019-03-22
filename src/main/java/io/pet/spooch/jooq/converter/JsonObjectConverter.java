package io.pet.spooch.jooq.converter;

import io.vertx.core.json.JsonObject;
import org.jooq.Converter;

public class JsonObjectConverter implements Converter<Object, JsonObject> {

    @Override
    public JsonObject from(Object o) {
        return o != null ? new JsonObject(o.toString()) : null;
    }

    @Override
    public Object to(JsonObject entries) {
        return entries != null ? (Object)entries.encode() :  null;
    }

    @Override
    public Class<Object> fromType() {
        return Object.class;
    }

    @Override
    public Class<JsonObject> toType() {
        return JsonObject.class;
    }
}
