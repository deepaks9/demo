package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.domain.Shop;
import demo.service.ShopLocationService;

@Controller
@RequestMapping("/shops")
public class ShopAddressController {

	@Autowired
	ShopLocationService shopLocationService;

	/**
	 * @return the shopLocationService
	 */
	public ShopLocationService getShopLocationService() {
		return shopLocationService;
	}

	/**
	 * @param shopLocationService
	 *            the shopLocationService to set
	 */
	public void setShopLocationService(ShopLocationService shopLocationService) {
		this.shopLocationService = shopLocationService;
	}

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Shop getNearestShop(@RequestParam(value = "longitude", required = true) double longitude,
			@RequestParam(value = "lattitude", required = true) double lattitude) {

		Shop nearestShop = shopLocationService.findNearestShop(lattitude, longitude);
		if (nearestShop != null)
			return nearestShop;

		return null;
	}

	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Shop saveShopAddress(@RequestBody Shop shop) {

		//check mandatory information
		if (shop == null || StringUtils.isEmpty(shop.getShopName()) || shop.getShopAddress() == null
				|| StringUtils.isEmpty(shop.getShopAddress().getPostCode())) {

		} else
			shopLocationService.saveShop(shop);

		return null;
	}

}
