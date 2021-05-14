package demo.model.destination;

import java.util.UUID;

import lombok.Data;

@Data
public class NamedResourceReference {

	private String name;
	private UUID id;
//	private ResourceType resourceType;

}
