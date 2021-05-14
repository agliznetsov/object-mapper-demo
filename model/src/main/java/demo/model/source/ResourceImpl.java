package demo.model.source;

import java.util.UUID;

import lombok.Data;

@Data
public abstract class ResourceImpl {

	private String id;
	private String name;

	private String createdBy;
	private Long createdOn;
	private String lastModifiedBy;
	private Long lastModified;
	private boolean system;

	protected static void fill(ResourceImpl resource) {
		resource.setId(UUID.randomUUID().toString());
		resource.setName("name");
		resource.setCreatedBy(UUID.randomUUID().toString());
		resource.setCreatedOn(System.currentTimeMillis());
		resource.setLastModified(System.currentTimeMillis());
		resource.setLastModifiedBy(UUID.randomUUID().toString());
	}
}
