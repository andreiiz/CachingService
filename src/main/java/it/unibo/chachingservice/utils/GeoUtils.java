package it.unibo.chachingservice.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.util.GeometricShapeFactory;

public class GeoUtils {

	private GeoUtils() {}
	
	private static final Logger logger = LogManager.getLogger(GeoUtils.class);

	public static Boolean isNodeNear(Float thisNodeLatitude, Float thisNodeLongitude,
			Float targetNodeLatitude, Float targetNodeLongitude, double circle, double targetCircle) {
		logger.info("thisNodeLatitude: {}", thisNodeLatitude);
		logger.info("thisNodeLongitude: {}", thisNodeLongitude);
		logger.info("targetNodeLatitude: {}", targetNodeLatitude);
		logger.info("targetNodeLongitude: {}", targetNodeLongitude);

	    Polygon thisNodeCircle = getCircle(thisNodeLatitude, thisNodeLongitude, circle);
	    Polygon targetNodeCircle = getCircle(targetNodeLatitude, targetNodeLongitude, targetCircle);
	    
	    return thisNodeCircle.contains(targetNodeCircle);
	}

	private static Polygon getCircle(Float thisNodeLatitude, Float thisNodeLongitude, double thisNodeDiameterInMeters) {
		GeometricShapeFactory thisNodeShapeFactory = new GeometricShapeFactory();
	    thisNodeShapeFactory.setNumPoints(64);
	    thisNodeShapeFactory.setCentre(new Coordinate(thisNodeLatitude, thisNodeLongitude));
	    thisNodeShapeFactory.setWidth(thisNodeDiameterInMeters/111320d);
	    thisNodeShapeFactory.setHeight(thisNodeDiameterInMeters / (40075000 * Math.cos(Math.toRadians(thisNodeLatitude)) / 360));
	    return thisNodeShapeFactory.createEllipse();
	}
}
