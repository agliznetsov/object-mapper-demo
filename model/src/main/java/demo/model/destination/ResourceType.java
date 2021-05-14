package demo.model.destination;

import static java.util.Arrays.asList;

import java.util.List;

/**
 * Represents the possible types of resources there are in the system.
 */
public enum ResourceType {
	// When adding something here, don't forget to add the mapping to ResourceTypeConverter

	View,
	Asset,
	Community,
	Domain,
	AssetType,
	DomainType,
	Status,
	User,
	ClassificationMatch,
	UserGroup,
	Attribute,
	StringAttribute,
	ScriptAttribute,
	BooleanAttribute,
	DateAttribute,
	NumericAttribute,
	SingleValueListAttribute,
	MultiValueListAttribute,
	Comment,
	Attachment,
	Responsibility,
	Workflow,
	Job,
	Relation,
	RelationType,
	ComplexRelation,
	ComplexRelationType,
	ArticulationRule,
	Assignment,
	Scope,
	RelationTrace,
	@Deprecated
	ValidationRule,
	DataQualityRule,
	DataQualityMetric,
	Address,
	InstantMessagingAccount,
	Email,
	PhoneNumber,
	Website,
	Activity,
	FormProperty,
	WorkflowTask,
	ActivityChange,
	WorkflowInstance,
	Role,
	AttributeType,
	BooleanAttributeType,
	DateAttributeType,
	DateTimeAttributeType,
	MultiValueListAttributeType,
	NumericAttributeType,
	ScriptAttributeType,
	SingleValueListAttributeType,
	StringAttributeType,
	ViewSharingRule,
	ViewAssignmentRule,
	JdbcDriverFile,
	JdbcDriver,
	JdbcIngestionProperties,
	CsvIngestionProperties,
	ExcelIngestionProperties,
	ConnectionStringParameter,
	AssignedCharacteristicType,
	Notification,
	Tag,
	ComplexRelationLegType,
	ComplexRelationAttributeType,
	ComplexRelationLeg,
	BaseDataType,
	AdvancedDataType,
	DiagramPicture,
	DiagramPictureSharingRule,
	DiagramPictureAssignmentRule,
	Rating,
	Classification;


	private static final List<ResourceType> ATTRIBUTE_TYPES = asList(AttributeType, StringAttributeType,
			ScriptAttributeType, BooleanAttributeType, DateAttributeType, SingleValueListAttributeType,
			MultiValueListAttributeType, NumericAttributeType);

	private static final List<ResourceType> REPRESENTATIONS = asList(Asset, Workflow, Role, ComplexRelation);

	public boolean isAttributeType() {
		return ATTRIBUTE_TYPES.contains(this);
	}

	public boolean isRepresentation() {
		return REPRESENTATIONS.contains(this);
	}
}
