package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //beans proje class (sınıfı)dır
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.enitites.concretes.Product;

@Service // bu class projede servis görevi görecek diye springe belitrmiş oluyoruz
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired // spring, gidiip arka planda projede buna karşılık gelebilecek product dao nun instance si olabilecek bir tane sinifi üretip veriyor
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
 
	@Override
	public List<Product> getAll() {
		return this.productDao.findAll();
	}

}
