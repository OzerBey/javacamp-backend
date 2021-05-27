package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.enitites.concretes.Product;

@RestController // Controller oldugunu belirtiyoruz ! Java olmayan kullanıcılar da
				// kullanabilmesi için
@RequestMapping("/api/products") // domain adersinin path (yolunu) belirtiriz
public class ProductsController { // backend ile diğer teknolojiler arasında köprü görevi gören api bağlantısının
									// yapıldıgı yer

	private ProductService productService;

	@Autowired // kısaca IoC göevi görüyor ,spring arka planda ProductService yi kim implemete
				// etmiş diyor ve arka planda ProductManager p=new ProductManger(ProductService
				// service) ile new leme yapıyor
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") // Get request localhost:/api/products/getall aderse girilirse bu metot çalışmış
							// olacak
	public DataResult<List<Product>> getAll() {

		return this.productService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) { // @RequestBody : hem istek atıyor hemde datayı yolluyor
		return this.productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) { // yapılan isteign parametrelerine
																					// bak ona göre oradan oku ataması
																					// yap ve gönder
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
			@RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
}
