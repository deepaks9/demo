
package demo;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import demo.ShopApplicationConfiguration;
import demo.domain.Shop;
import demo.domain.ShopAddress;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplicationConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class ShopApplicationConfigurationTest {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testGetNearest() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate
				.getForEntity("http://localhost:" + this.port + "/shops?lattitude=10&longitude=36", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void testSaveShop() throws Exception {
		@SuppressWarnings("rawtypes")

		Shop shop = new Shop();
		shop.setShopName("Dmart Baner Pune MH");
		shop.setShopAddress(new ShopAddress());
		shop.getShopAddress().setNumber("1");
		shop.getShopAddress().setPostCode("411045");

		ResponseEntity<Map> entity = this.testRestTemplate.postForObject("http://localhost:" + this.port + "/shops",
				shop, ResponseEntity.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
