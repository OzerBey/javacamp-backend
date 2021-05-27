package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.enitites.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	  Product getByProductName(String productName); // Jpa ile hallediliyor
	  
	  Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	// iki duruma göre where koşulu
		// select* from products where
		// product_name =
		// 'abc' and/or categoryId= 1
		// oluşturuyor
	  
	  List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	  
	  List<Product> getByCategoryIn(List<Integer> categories); // select * from products where categoryId in(1,2,3,4,5)
	  
	  List<Product> getByProductNameContains(String productName); // productname gelen parametre içerenler
	  
	  List<Product> getByProductNameStartsWith(String productName); // Bu isimle başlayanları getir
	  
	//List<Product> getByProductNameEndsWith(String productName); // Bu isimle bitenleri getir

		// select * from products where product_name= 'bir şey' and categoryId= 1
		// sordugus için
	  
	  @Query("From Product where productName=:productName and category.categoryId=:categoryId") // entity deki alanlar buraya girilir
	  List<Product> getByNameAndCategory(String productName, int categoryId);

	
//	Fail code (:
//	Product getByProductName(String productName); // Jpa ile hallediliyor
//
//	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); // iki duruma göre where koşulu
//	// select* from products where
//	// product_name =
//	// 'abc' and/or categoryId= 1
//	// oluşturuyor
//
//	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
//
//	List<Product> getByCategoryIn(List<Integer> categories); // select * from products where categoryId in(1,2,3,4,5)
//
//	List<Product> getByProductNameContains(String productName); // productname gelen parametre içerenler
//
//	List<Product> getByProductNameStartsWith(String productName); // Bu isimle başlayanları getir
//
//	//List<Product> getByProductNameEndsWith(String productName); // Bu isimle bitenleri getir
//
//	// select * from products where product_name= 'bir şey' and categoryId= 1
//	// sordugus için
//	@Query("From Product where productName=:productName and category.categoryId=:categoyId") // entity deki alanlar buraya girilir
//	List<Product> getByNameAndCategory(String productName, int categoryId);

}
