package com.startup.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import java.io.IOException;

/**
 * Created by Justin on 4/8/2016.
 */
public class PolygonToJsonSerializer extends JsonSerializer<Polygon> {

    @Override
    public void serialize(Polygon polygon, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String jsonValue = "null";
        try {
            if (polygon != null) {
                Coordinate[] coordinates = polygon.getCoordinates();

                StringBuffer buffer = new StringBuffer();
                buffer.append("POLYGON ");

                for (Coordinate coordinate : coordinates){
                    if (coordinate != coordinates[0]) {
                        buffer.append(",");
                    }
                    buffer.append("(");
                    buffer.append(getRoundedDouble(coordinate.x));
                    buffer.append(", ");
                    buffer.append(getRoundedDouble(coordinate.y));
                    buffer.append(")");
                }

                jsonValue = buffer.toString();
            }
        } catch (Exception e) {
        }

        jsonGenerator.writeString(jsonValue);
    }

    private Double getRoundedDouble(Double coordinate) {
        Double value = coordinate;
        value = value * 100;
        value = Double.valueOf(Math.round(value));
        value = value / 100;

        return value;
    }
}