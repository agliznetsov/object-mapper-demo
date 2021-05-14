package demo.mapper.dozer;

import java.util.UUID;

import com.github.dozermapper.core.DozerConverter;

public class UUIDConverter extends DozerConverter<UUID,String> {

	public UUIDConverter() {
		super(UUID.class, String.class);
	}

	@Override
	public String convertTo(UUID source, String destination) {
		return convert(source);
	}

	@Override
	public String convertTo(UUID source) {
		return convert(source);
	}

	private String convert(UUID source) {
		if (source == null) {
			return null;
		}
		return source.toString();
	}

	@Override
	public UUID convertFrom(String source, UUID destination) {
		return convert(source);
	}

	private UUID convert(String source) {
		if (source == null || source.isEmpty()) {
			return null;
		}
		return toUuid(source);
	}

	@Override
	public UUID convertFrom(String source) {
		return convert(source);
	}

	protected UUID toUuid(String source) {
		return UUID.fromString(source);
	}
	
}
