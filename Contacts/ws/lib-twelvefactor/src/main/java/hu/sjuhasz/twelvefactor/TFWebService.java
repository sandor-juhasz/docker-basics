package hu.sjuhasz.twelvefactor;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.component.LifeCycle.Listener;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public abstract class TFWebService {

	protected abstract void initializeConfig();

	protected abstract ResourceConfig getResourceConfig();

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
			}

			@Override
			public void lifeCycleStopped(LifeCycle arg0) {
			}

			@Override
			public void lifeCycleStopping(LifeCycle arg0) {
			}};
	}
	
	public void run() {
		initializeConfig();
		TFConfig cfg = TFConfig.getConfig();

		try {
			cfg.validate();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}

		Server server = new Server(cfg.getInt("PORT"));
		server.setStopAtShutdown(true);
		server.setStopTimeout(7_000);
		server.addLifeCycleListener(getLifecycleListener());

		ResourceConfig config = getResourceConfig();
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		ServletContextHandler context = new ServletContextHandler(server, "/");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}

	}

}
