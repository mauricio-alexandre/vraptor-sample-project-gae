package br.com.caelum.vraptor.controllers;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.infrastructure.daos.ProductDao;
import br.com.caelum.vraptor.models.entities.Product;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProductsController {
	
	private final ProductDao dao;
	private final Result result;
	private final Validator validator;

	public ProductsController(ProductDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Get("/products")
	public List<Product> list() {
		return dao.listAll();
	}

	@Get("/products/new")
	public void form() {

	}

	@Post("/products")
	public void add(Product product) {
		validateProduct(product);
		validator.onErrorUsePageOf(this).form();

		dao.create(product);
		// result.redirectTo(ProductsController.class).list();
		result.redirectTo(this).list();
	}

	@Get("/products/{id}")
	public Product edit(Long id) {
		return dao.read(id);
	}

	@Put("/products/{product.id}")
	public void update(Product product) {
		validateProduct(product);
		validator.onErrorUsePageOf(this).edit(product.getId());

		dao.update(product);
		result.redirectTo(this).list();
	}

	@Delete("/products/{id}")
	public void delete(Long id) {
		Product product = dao.read(id);
		dao.delete(product);
		result.redirectTo(this).list();
	}

	@Get
	public List<Product> search(String name) {
		result.include("name", name);
		return dao.search(name);
	}

	@Get("/products/search.json")
	public void searchJson(String q) {
		result.use(Results.json()).withoutRoot().from(dao.search(q))
				.exclude("id", "description").serialize();
	}

	private void validateProduct(final Product product) {
		validator.checking(new Validations() {
			{
				that(product.getName() != null
						&& product.getName().length() >= 3, "product.name",
						"name.mandatory");
				that(product.getDescription() != null
						&& product.getDescription().length() <= 40,
						"product.description", "product.mandatory");
				that(product.getPrice() != null && product.getPrice() > 0.0,
						"product.price", "product.positive");
				that(product.getAmount() != null && product.getAmount() > 0,
						"product.amount", "amount.mandatory");
			}
		});
	}
}
