package br.com.caelum.vraptor.infrastructure;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CreatorPersistenceManagerFactory implements
		ComponentFactory<PersistenceManagerFactory> {
	private PersistenceManagerFactory persistenceManagerFactory;

	@PostConstruct
	public void open() {
		persistenceManagerFactory = JDOHelper
				.getPersistenceManagerFactory("transactions-optional");
	}

	@PreDestroy
	public void close() {
		persistenceManagerFactory.close();
	}

	public PersistenceManagerFactory getInstance() {
		return persistenceManagerFactory;
	}
}
