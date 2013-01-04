package br.com.caelum.vraptor.infrastructure.daos;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.models.entities.Product;

@Component
public class ProductDao {
	private final PersistenceManager persistenceManager;
	
	public ProductDao(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}
	
	public void create(Product product) {
		product.setRegistrationDate(new Date());
		persistenceManager.makePersistent(product);
	}
	
	public Product read(Long id) {
		Product product = persistenceManager.getObjectById(Product.class, id);
		return product;
	}
	
	public void update(Product newProduct) {
		Product currentProduct = persistenceManager.getObjectById(Product.class, newProduct.getId());
		currentProduct.setName(newProduct.getName());
		currentProduct.setDescription(newProduct.getDescription());
		currentProduct.setPrice(newProduct.getPrice());
		currentProduct.setAmount(newProduct.getAmount());
		currentProduct.setUpdateDate(new Date());
	}
	
	public void delete(Product product) {
		persistenceManager.deletePersistent(product);
	}
	
	public List<Product> listAll() {
		Query query = persistenceManager.newQuery(Product.class);
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.execute();
		products.size(); // check after
		query.closeAll(); // implement to close before persistenceManager close
		return products;
	}
	
	public List<Product> search(String name) {
		Query query = persistenceManager.newQuery(Product.class);
		query.setFilter("nameUpperCase.startsWith(searchedName)");
		query.declareParameters("String searchedName");
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.execute(name.toUpperCase());
		products.size(); // check after
		query.closeAll(); // implement to close before persistenceManager close
		return products;
	}
	
	public void refresh(Product product) {
		persistenceManager.refresh(product);
	}
}
