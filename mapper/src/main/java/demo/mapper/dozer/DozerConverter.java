package demo.mapper.dozer;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import demo.mapper.Converter;
import demo.model.destination.Asset;
import demo.model.source.TermImpl;

public class DozerConverter implements Converter {
	private final Mapper mapper;

	public DozerConverter() {
		this.mapper = DozerBeanMapperBuilder.create()
				.withMappingBuilder(new MappingBuilder())
				.build();
	}

	@Override
	public Asset convert(TermImpl term) {
		return mapper.map(term, Asset.class);
	}

}
