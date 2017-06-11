/**
 * 
 */
package demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.model.GeocodingResult;

import demo.domain.Shop;

/**
 * @author Deepak Sangvikar
 *
 */
@Service
public class ShopLocationService {

	@Autowired
	private GoogleGeoCodeService googleGeoCodeService;

	private List<Shop> shops = Collections.synchronizedList(new ArrayList<Shop>());

	/**
	 * Find out the longitude and lattitude of the shop and then save all
	 * information in in-memory list
	 * 
	 * @param shop
	 */
	public void saveShop(Shop shop) {
		// get the lattitude and logitude using google service
		StringBuffer geoCodeQuery = new StringBuffer(shop.getShopName());
		geoCodeQuery.append(", ");
		geoCodeQuery.append(shop.getShopAddress().getPostCode());

		GeocodingResult result = null;
		try {
			result = googleGeoCodeService.getLocation(geoCodeQuery.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == null) {

		} else {
			shop.setShopLattitude(result.geometry.location.lat);
			shop.setShopLongitude(result.geometry.location.lng);

			// add the shop to in-memory list
			shops.add(shop);
		}
	}

	/**
	 * Find the nearest shop from in-memory list by comparing differences of
	 * longitude and lattitude
	 * 
	 * @param lattitude
	 * @param longitude
	 * @return Shop - shop with minimum distance from passed longitude,
	 *         lattitude
	 */
	public Shop findNearestShop(double lattitude, double longitude) {
		Shop nearestShop = null;
		double nearestShopDistance = 999999;

		if (shops == null || shops.isEmpty())
			return null;

		synchronized (shops) {
			for (Shop shop : shops) {
				double latDiff = Math.abs(lattitude - shop.getShopLattitude());
				double lonDiff = Math.abs(longitude - shop.getShopLongitude());

				if (nearestShopDistance > (latDiff + lonDiff)) {
					nearestShop = shop;
					nearestShopDistance = latDiff + lonDiff;
				}
			}
		}

		return nearestShop;
	}

	public GoogleGeoCodeService getGoogleGeoCodeService() {
		return googleGeoCodeService;
	}

	public void setGoogleGeoCodeService(GoogleGeoCodeService googleGeoCodeService) {
		this.googleGeoCodeService = googleGeoCodeService;
	}

}
