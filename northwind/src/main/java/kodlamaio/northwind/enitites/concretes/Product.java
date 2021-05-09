package kodlamaio.northwind.enitites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity // veri tabanı nesnesi oldugunu belirtiyoruz
@Table(name = "products") // veri tabınında hangi tabloya denk geldigini belirtmiş oluyoruz
public class Product {
	@Id // işlelerini id ye göre yapacagı için jpa ya bu tablonun id sini belirtiyoruz
		// burada
	@GeneratedValue // veri tabanlarında id lerin tek tek artıralacagını belitiyoruz
	@Column(name = "product_id") // VT(DB) deki denk geldigi kolonları belirtilen yer
	private int id;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

}
