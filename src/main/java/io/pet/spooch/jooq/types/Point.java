/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pet.spooch.jooq.types;

import io.vertx.core.json.JsonArray;
import io.github.jklingsporn.vertx.jooq.shared.JsonType;

/**
 *
 * @author Anala
 */
public class Point extends org.postgis.Point implements JsonType{
    
    public Point(org.postgis.Point val){
        x = val.x;
        y = val.y;
        srid = val.srid;
    }
    
    public Point(JsonArray arr){
        x = arr.getDouble(0);
        y = arr.getDouble(1);
        srid = 4326;
    }
    
    @Override
    public JsonArray toType(){
        return new JsonArray().add(x).add(y);
    }
    
}
