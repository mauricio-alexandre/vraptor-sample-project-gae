package br.com.caelum.vraptor.infrastructure;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CreatorPersistenceManager implements
		ComponentFactory<PersistenceManager> {
	private final PersistenceManagerFactory persistenceManagerFactory;
	private PersistenceManager persistenceManager;

	public CreatorPersistenceManager(
			PersistenceManagerFactory persistenceManagerFactory) {
		this.persistenceManagerFactory = persistenceManagerFactory;
	}

	@PostConstruct
	public void open() {
		persistenceManager = persistenceManagerFactory.getPersistenceManager();
	}

	@PreDestroy
	public void close() {
		persistenceManager.close();
	}

	public PersistenceManager getInstance() {
		return persistenceManager;
	}
}
