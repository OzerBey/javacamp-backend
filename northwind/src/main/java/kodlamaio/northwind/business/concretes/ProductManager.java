package kodlamaio.northwind.business.concretes;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; //beans proje class (sınıfı)dır
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.enitites.concretes.Product;

@Service // bu class projede servis görevi görecek diye springe belitrmiş oluyoruz
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired // spring, gidip arka planda projede buna karşılık gelebilecek product dao nun
				// instance si olabilecek bir tane sinifi üretip veriyor
	public ProductManager(ProductDao productDao) { // constructor injection
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listelendi");
		// this.productDao.findAll();
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

}
