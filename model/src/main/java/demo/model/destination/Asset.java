package demo.model.destination;

import java.util.UUID;

import lombok.Data;


@Data
public class Asset {

	private UUID id;

	private UUID createdBy;
	private Long createdOn;
	private UUID lastModifiedBy;
	private Long lastModifiedOn;
	private boolean system;

	private String name;

	private String displayName;
	private Double articulationScore;
	private boolean excludedFromAutoHyperlinking;
	private NamedResourceReference domain;
	private NamedResourceReference type;
	private NamedResourceReference status;
	private Double avgRating;
	private Integer ratingsCount;

}
