/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pet.spooch.jooq.types;

import io.github.jklingsporn.vertx.jooq.shared.async.JsonPojo;
import io.vertx.core.json.JsonArray;

/**
 *
 * @author Anala
 */
public class Point extends org.postgis.Point implements JsonPojo{
    
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
    public JsonArray toJson(){
        return new JsonArray().add(x).add(y);
    }
    
}
