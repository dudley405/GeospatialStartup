package com.startup.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Point;

import java.io.IOException;

/**
 * Created by Justin on 3/26/2016.
 */
public class PointToJsonSerializer extends JsonSerializer<Point> {
    @Override
    public void serialize(Point point, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String jsonValue = "null";
        try
        {
            if(point != null) {
                double lat = point.getY();
                double lon = point.getX();
                jsonValue = String.format("POINT (%s %s)", lat, lon);
            }
        }
        catch(Exception e) {}

        jsonGenerator.writeString(jsonValue);
    }
}
