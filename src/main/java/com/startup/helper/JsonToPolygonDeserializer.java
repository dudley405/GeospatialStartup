package com.startup.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.vividsolutions.jts.geom.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 4/8/2016.
 */
public class JsonToPolygonDeserializer implements JsonDeserializer<Polygon> {

    private final static GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910);

    private Double getRoundedDouble(String coordinate) {
        Double value = Double.parseDouble(coordinate);
        value = value * 100;
        value = Double.valueOf(Math.round(value));
        value = value / 100;

        return value;
    }

    @Override
    public Polygon deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            List<Coordinate> polyCoords = new ArrayList<Coordinate>();
            String text = jsonElement.getAsString();
            if(text == null || text.length() <= 0)
                return null;

            String[] coordinates = text.replaceFirst("POLYGON ?\\(", "").replaceFirst("\\)", "").split(" ");

            for (int i = 0; i < coordinates.length; i++) {
                Double point1 = getRoundedDouble(coordinates[i]);
                Double point2 = getRoundedDouble(coordinates[i+1]);
                polyCoords.add(new Coordinate(point1, point2));
            }

            Polygon polygon = geometryFactory.createPolygon((Coordinate[])polyCoords.toArray());

            return polygon;
        }
        catch(Exception e){
            return null;
        }
    }
}
