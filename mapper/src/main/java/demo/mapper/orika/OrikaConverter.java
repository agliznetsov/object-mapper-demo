package demo.mapper.orika;

import demo.mapper.Converter;
import demo.mapper.dozer.UUIDConverter;
import demo.model.destination.Asset;
import demo.model.destination.NamedResourceReference;
import demo.model.source.ResourceImpl;
import demo.model.source.TermImpl;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConverter implements Converter{
    private MapperFacade mapperFacade;

    public OrikaConverter() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.getConverterFactory().registerConverter(new UuidConverter());

        //no need, orika maps same fields by default
//        mapperFactory.classMap(ResourceImpl.class, NamedResourceReference.class).byDefault().register();

        mapperFactory.classMap(TermImpl.class, Asset.class).byDefault()
                .field("lastModified", "lastModifiedOn")
                .field("signifier", "name")
                .field("vocabulary", "domain")
                .field("excludedFromHyperlinking", "excludedFromAutoHyperlinking")
                .register();

        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Asset convert(TermImpl term) {
        return mapperFacade.map(term, Asset.class);
    }

}
