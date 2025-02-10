package stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {

	@GetMapping("/{productId}")
	public int getName(@PathVariable("productId") String productId) {
		switch(productId){
			case "1":
				return 50;
			case "2":
				return 100;
			case "3":
				return 1000;
			default:
				return 1;
		}

	}
}
