package demo.mapper.dozer;

import static com.github.dozermapper.core.loader.api.FieldsMappingOptions.customConverter;

import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.TypeMappingBuilder;

import demo.model.destination.Asset;
import demo.model.destination.NamedResourceReference;
import demo.model.source.ResourceImpl;
import demo.model.source.TermImpl;

public class MappingBuilder extends BeanMappingBuilder {

	@Override
	protected void configure() {
		mapping(ResourceImpl.class,	NamedResourceReference.class)
				.fields("id", "id", customConverter(UUIDConverter.class))
				.fields("name", "name");

		TypeMappingBuilder assetMapping = mapping(TermImpl.class, Asset.class)
				.fields("signifier", "name")
				.fields("vocabulary", "domain")
				.fields("excludedFromHyperlinking", "excludedFromAutoHyperlinking");
		addResourceFields(assetMapping);

	}

	protected TypeMappingBuilder addResourceFields(TypeMappingBuilder mapping) {
		return mapping
				.fields("id", "id", customConverter(UUIDConverter.class))
				.fields("lastModifiedBy", field("lastModifiedBy").accessible(), customConverter(UUIDConverter.class))
				.fields("createdBy", field("createdBy").accessible(), customConverter(UUIDConverter.class))
				.fields(field("createdOn").accessible(), field("createdOn").accessible())
				.fields(field("system").accessible(), field("system").accessible())
				.fields(field("lastModified").accessible(), field("lastModifiedOn").accessible());
	}

}