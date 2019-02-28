/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pet.spooch.jooq;

import io.github.jklingsporn.vertx.jooq.generate.classic.ClassicAsyncVertxGenerator;
import io.pet.spooch.jooq.types.Point;
import org.jooq.codegen.JavaWriter;
import org.jooq.meta.TypedElementDefinition;
import java.time.LocalDateTime;
import io.vertx.core.json.JsonArray;

/**
 *
 * @author Owen Grant
 */
public class Generator extends ClassicAsyncVertxGenerator{
     @Override
    protected boolean handleCustomTypeFromJson(TypedElementDefinition<?> column, String setter, String columnType, String javaMemberName, JavaWriter out) {
        if(isType(columnType, LocalDateTime.class)){
            out.tab(2).println("%s(json.getString(\"%s\")==null?null:LocalDateTime.parse(json.getString(\"%s\")));", setter, javaMemberName, javaMemberName);
            return true;
        }
        else if(isType(columnType, Point.class)){
            out.tab(2).println("%s(json.getJsonArray(\"%s\")==null?null:new Point(json.getJsonArray(\"%s\")));", setter, javaMemberName, javaMemberName);
        } 
        return super.handleCustomTypeFromJson(column, setter, columnType, javaMemberName, out);
    }

    @Override
    protected boolean handleCustomTypeToJson(TypedElementDefinition<?> column, String getter, String columnType, String javaMemberName, JavaWriter out) {
        if(isType(columnType, LocalDateTime.class)){
            out.tab(2).println("json.put(\"%s\",%s()==null?null:%s().toString());", getJsonKeyName(column),getter,getter);
            return true;
        }
        else if(isType(columnType, Point.class)){
            out.tab(2).println("json.put(\"%s\",%s()==null?null:%s().toJson());", getJsonKeyName(column),getter,getter);
        } 
        return super.handleCustomTypeToJson(column, getter, columnType, javaMemberName, out);
    }
}
