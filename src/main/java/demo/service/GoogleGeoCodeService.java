/**
 * 
 */
package demo.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

/**
 * @author Deepak Sangvikar
 *
 */
@Service
public class GoogleGeoCodeService {

	private GeoApiContext context;

	@Value("${geocode.API_KEY}")
	private String geoCodeAPIKey;

	public GeoApiContext getContext() {
		return context;
	}

	public void setContext(GeoApiContext context) {
		this.context = context;
	}

	public String getGeoCodeAPIKey() {
		return geoCodeAPIKey;
	}

	public void setGeoCodeAPIKey(String geoCodeAPIKey) {
		this.geoCodeAPIKey = geoCodeAPIKey;
	}

	@PostConstruct
	public void init()

	{
		context = new GeoApiContext().setApiKey(geoCodeAPIKey);
	}

	public GeocodingResult getLocation(String address) throws Exception {
		GeocodingResult[] results;

		results = GeocodingApi.geocode(context, address).await();

		if (results != null && results.length > 0)
			return results[0];

		return null;
	}
}
