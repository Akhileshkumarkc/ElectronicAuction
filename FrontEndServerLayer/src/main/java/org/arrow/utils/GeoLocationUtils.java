/**
 * 
 */
package org.arrow.utils;

import java.io.IOException;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

/**
 * @author aravind
 *
 */
public class GeoLocationUtils {
	
	public static String getLocation(String lat,String longitude) throws IOException
	{
		String resultAddr="";
	    Geocoder geocoder = new Geocoder();
	    GeocoderRequest geocoderRequest;
	    GeocodeResponse geocoderResponse;

	    geocoderRequest = new GeocoderRequestBuilder()
	            .setLocation(new LatLng(lat, longitude))
	            .setLanguage("en").getGeocoderRequest();
	    geocoderResponse = geocoder.geocode(geocoderRequest);
	    if (geocoderResponse != null) {
	        if (geocoderResponse.getStatus() == GeocoderStatus.OK) {
	            if (!geocoderResponse.getResults().isEmpty()) {
	                GeocoderResult geocoderResult = // Get the first result
	                        geocoderResponse.getResults().iterator().next();
	                resultAddr = geocoderResult.getFormattedAddress().substring(0, geocoderResult.getFormattedAddress().indexOf(","));
	                return resultAddr;
	            }
	        }
	    }
	    return null;
	}

}
