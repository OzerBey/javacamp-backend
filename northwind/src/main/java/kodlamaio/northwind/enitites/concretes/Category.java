package kodlamaio.northwind.enitites.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "products" }) // verdiğim yerler hakkında sorgu yaz
																				// demektir
public class Category {
	@Id
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category") // ana(category) tablodan products ile one2many ilişkisi var
	private List<Product> products;
}
