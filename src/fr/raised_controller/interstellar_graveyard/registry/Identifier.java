package fr.raised_controller.interstellar_graveyard.registry;

import java.util.Objects;

public class Identifier {
	
	private static final String DEFAULT_NAMESPACE = "ig";
	
	private String namespace;
	private String path;
	
	public Identifier(String namespace, String path)
	{
		this.namespace = namespace;
		this.path = path;
	}
	
	public Identifier(String path)
	{
		this(DEFAULT_NAMESPACE, path);
	}
	
	

	public String getNamespace() {
		return namespace;
	}

	public String getPath() {
		return path;
	}

	@Override
	public int hashCode() {
		return Objects.hash(namespace, path);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identifier other = (Identifier) obj;
		return Objects.equals(namespace, other.namespace) && Objects.equals(path, other.path);
	}
}
