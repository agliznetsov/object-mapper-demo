package demo.mapper.mapstruct;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import demo.mapper.Converter;
import demo.model.destination.Asset;
import demo.model.source.TermImpl;

@Mapper
public interface MapStructConverter extends Converter {
    MapStructConverter MAPPER = Mappers.getMapper(MapStructConverter.class);

    @Override
    @Mapping(source = "lastModified", target = "lastModifiedOn")
    @Mapping(source = "signifier", target = "name")
    @Mapping(source = "vocabulary", target = "domain")
    @Mapping(source = "excludedFromHyperlinking", target = "excludedFromAutoHyperlinking")
    Asset convert(TermImpl term);

    default String map(UUID value) {
        return value.toString();
    }

    default UUID map(String value) {
        return value == null ? null : UUID.fromString(value);
    }

}
