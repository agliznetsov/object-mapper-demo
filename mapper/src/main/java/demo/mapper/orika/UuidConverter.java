package demo.mapper.orika;

import java.util.UUID;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class UuidConverter extends BidirectionalConverter<UUID, String> {

   @Override
   public String convertTo(UUID uuid, Type<String> type, MappingContext mappingContext) {
      return uuid.toString();
   }

   @Override
   public UUID convertFrom(String s, Type<UUID> type, MappingContext mappingContext) {
      return UUID.fromString(s);
   }

}