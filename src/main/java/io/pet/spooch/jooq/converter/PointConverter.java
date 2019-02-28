/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pet.spooch.jooq.converter;

import io.pet.spooch.jooq.types.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jooq.Converter;
import java.sql.SQLException;
import org.postgis.PGgeometry;

/**
 *
 * @author Anala
 */
public class PointConverter implements Converter<Object, Point>{

    @Override
    public Point from(Object databaseObject) {
        try {	
            return databaseObject == null ? null : new Point((org.postgis.Point)PGgeometry.geomFromString(databaseObject.toString()));
        } catch (SQLException ex) {
            Logger.getLogger(PointConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object to(Point userObject) {
        return userObject;
    }

    @Override
    public Class<Object> fromType() {
        return Object.class;
    }

    @Override
    public Class<Point> toType() {
        return Point.class;
    }
    
}
