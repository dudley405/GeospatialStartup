package com.startup.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.startup.helper.JsonToPointDeserializer;
import com.startup.helper.PointToJsonSerializer;
import com.vividsolutions.jts.geom.Geometry;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Justin on 3/26/2016.
 */
public class GeometryDataVO {

    @JsonSerialize(using = PointToJsonSerializer.class)
    @JsonDeserialize(using = JsonToPointDeserializer.class)
    private Geometry geometry;
    private Map<String, String> properties = new HashMap<String, String>();

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Object object) {
        ReflectionUtils.doWithFields(object.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(final Field field)
                    throws IllegalArgumentException, IllegalAccessException {
                if(field != null) {
                    field.setAccessible(true);
                    if(field.getName() != null && field.get(object) != null && !field.getName().equals("geom")) {
                        properties.put(field.getName(), field.get(object).toString());
                    } else if (field.getName().equals("geom")) {
                        if (geometry.getCoordinates().length == 1) {
                            properties.put("CoordinateType", "point");
                            properties.put("Lat", String.valueOf(geometry.getCoordinate().getOrdinate(1)));
                            properties.put("Long", String.valueOf(geometry.getCoordinate().getOrdinate(0)));
                        }
                    }
                }
            }
        });
    }
}

