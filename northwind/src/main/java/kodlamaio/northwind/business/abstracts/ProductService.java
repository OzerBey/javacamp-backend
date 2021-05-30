package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.enitites.concretes.Product;
import kodlamaio.northwind.enitites.dtos.ProductWithCategoryDto;

public interface ProductService {

	DataResult<List<Product>> getAll();

	DataResult<List<Product>> getAllSorted();

	DataResult<List<Product>> getAll(int pageNo, int pageSize); // sayfalama :

	Result add(Product product);

	DataResult<Product> getByProductName(String productName); // Jpa ile hallediliyor

	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName); // productname gelen parametre içerenler

	DataResult<List<Product>> getByProductNameStartsWith(String productName); // Bu isimle başlayanları getir

	// DataResult<List<Product>> getByProductNameEndsWith(String productName); // Bu
	// isimle bitenleri getir

	// select * from products where product_name= 'bir şey' and categoryId= 1
	// //sordugus için

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
