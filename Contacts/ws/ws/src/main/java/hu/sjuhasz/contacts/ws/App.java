package hu.sjuhasz.contacts.ws;

import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.component.LifeCycle.Listener;
import org.glassfish.jersey.server.ResourceConfig;

import hu.sjuhasz.contacts.persistence.PersistenceManager;
import hu.sjuhasz.twelvefactor.TFConfig;
import hu.sjuhasz.twelvefactor.TFWebService;

/**
 * The main class which starts the Jetty server.
 * 
 * @author developer
 *
 */
public class App extends TFWebService {

	@Override
	protected void initializeConfig() {
		new TFConfig.Builder()
		.addConfig("PORT", "The port the web service is listening to.")
		.addConfig("CONTACTS_DB_URL", "The JDBC URL of the Contacts database.")
		.addConfig("CONTACTS_DB_USERNAME", "The user name to connect to the database.")
		.addConfig("CONTACTS_DB_PASSWORD", "The password used to connect to the database.")
		.initialize();
	}

	@Override
	protected ResourceConfig getResourceConfig() {
		ResourceConfig config = new ResourceConfig();
	    config.packages("hu.sjuhasz.contacts.ws.resources");
	    
	    return config;
	}

	@Override
	protected Listener getLifecycleListener() {
		return new Listener() {

			@Override
			public void lifeCycleFailure(LifeCycle arg0, Throwable arg1) {
			}

			@Override
			public void lifeCycleStarted(LifeCycle arg0) {
			}

			@Override
			public void lifeCycleStarting(LifeCycle arg0) {
				TFConfig cfg = TFConfig.getConfig();
				PersistenceManager.init(cfg.get("CONTACTS_DB_URL"),
						cfg.get("CONTACTS_DB_USERNAME"),
						cfg.get("CONTACTS_DB_PASSWORD"));
			}

			@Override
			public void lifeCycleStopped(LifeCycle arg0) {
			}

			@Override
			public void lifeCycleStopping(LifeCycle arg0) {
				PersistenceManager.close();
			}
		};
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

}
