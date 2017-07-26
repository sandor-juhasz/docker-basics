package hu.sjuhasz.twelvefactor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TFConfig {

	private final List<ConfigEntry> entries;
	
	private TFConfig(Collection<ConfigEntry> entries) {
		this.entries = new ArrayList<>(entries);
	}
	
	public void validate() {
		Set<String> emptyVars = new HashSet<String>();
		
		for (ConfigEntry entry : entries) {
			if (System.getenv(entry.getName()) == null) {
				emptyVars.add(entry.getName());
			}
		}
		if (!emptyVars.isEmpty()) {
			throw new IllegalStateException("Environment variables "+emptyVars+" are empty.");
		}
	}
	
	public int getInt(String environmnetVariable) {
		return Integer.parseInt(System.getenv(environmnetVariable));
	}
	
	public String get(String environmentVariable) {
		return System.getenv(environmentVariable);
	}
	
	/*
	 * Singleton pattern
	 */
	
	private static TFConfig config;

	public static TFConfig getConfig() {
		return config;
	}
	
	/*
	 * Config builder 
	 */
	
	public static class Builder {
	
		private List<ConfigEntry> entries = new ArrayList<>();
		
		public Builder addConfig(String name, String description) {
			entries.add(new ConfigEntry(name, description));
			return this;
		}
		
		public void initialize() {
			TFConfig.config = new TFConfig(entries);
		}
	}
	
}
