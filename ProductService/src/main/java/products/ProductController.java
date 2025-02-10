package products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	StockFeignClient stockFeignClient;

	@RequestMapping("/product/{productid}")
	public Product getProduct(@PathVariable("productid") String productId) {
		Product product = new Product();
		product.setProductNumber(productId);
		product.setName("Test Product");

		int stock = stockFeignClient.getStock(productId);
		product.setNumberInStock(stock);
		return product;
	}

	@FeignClient(name = "stock-service")
	interface StockFeignClient {
		@GetMapping("/stock/{productid}")
		int getStock(@PathVariable("productid") String productId);
	}
}