package com.startup.service.impl;

import com.startup.entity.BaseEntity;
import com.startup.service.FeatureService;
import com.vividsolutions.jts.geom.Coordinate;
import org.geojson.Feature;
import org.geojson.LngLatAlt;
import org.geojson.Polygon;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 4/8/2016.
 *
 * Class to build Feature (geoJSON) objects from entities
 */
@Service
public class FeatureServiceImpl implements FeatureService {

    private Feature feature;

    public Feature buildEntityFeature(BaseEntity entity) {
        if (entity.getGeom().getGeometryType().equals("Polygon")) {
            return buildPolygonFeature(entity);
        } else {
            return null;
        }
    }

    private Feature buildPolygonFeature(BaseEntity entity) {
        List<List<LngLatAlt>> allCoords = new ArrayList<List<LngLatAlt>>();
        feature = new Feature();

        List<LngLatAlt> coordinates = new ArrayList<LngLatAlt>();

        for(Coordinate coordinate : entity.getGeom().getCoordinates()) {
            LngLatAlt lngLatAlt = new LngLatAlt();
            lngLatAlt.setLongitude(coordinate.x);
            lngLatAlt.setLatitude(coordinate.y);

            coordinates.add(lngLatAlt);
        }

        allCoords.add(coordinates);

        Polygon polygon = new Polygon();
        polygon.setCoordinates(allCoords);
        feature.setGeometry(polygon);

        setProperties(entity);

        return feature;
    }


    private void setProperties(Object object) {
        ReflectionUtils.doWithFields(object.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(final Field field)
                    throws IllegalArgumentException, IllegalAccessException {
                if (field != null) {
                    field.setAccessible(true);
                    if (field.getName() != null && field.get(object) != null && !field.getName().equals("geom")) {
                        feature.setProperty(field.getName(), field.get(object).toString());
                    }
                }
            }
        });
    }
}
