package demo.mapper;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.UUID;

import org.junit.Test;

import demo.mapper.dozer.DozerConverter;
import demo.mapper.manual.ManualConverter;
import demo.mapper.mapstruct.MapStructConverter;
import demo.mapper.orika.OrikaConverter;
import demo.model.destination.Asset;
import demo.model.source.TermImpl;

public class MapperTest {
	private static final OrikaConverter ORIKA_CONVERTER = new OrikaConverter();
	private static final DozerConverter DOZER_CONVERTER = new DozerConverter();
	private static final MapStructConverter MAPSTRUCT_CONVERTER = MapStructConverter.MAPPER;
	private static final ManualConverter MANUAL_CONVERTER = new ManualConverter();

	@Test
	public void testDozer() throws Exception {
		test(DOZER_CONVERTER);
	}

	@Test
	public void testOrika() throws Exception {
		test(ORIKA_CONVERTER);
	}

	@Test
	public void testMapStruct() throws Exception {
		test(MAPSTRUCT_CONVERTER);
	}

	@Test
	public void testManual() throws Exception {
		test(MANUAL_CONVERTER);
	}

	private void test(Converter converter) throws Exception {
		TermImpl term = TermImpl.randomTerm();
		Asset asset = converter.convert(term);
		assertObject("asset", asset);
		System.out.println(asset.toString());
	}

	private void assertObject(String name, Object object) throws Exception {
		assertNotNull("Field is null: " + name, object);
		if (object.getClass().getName().startsWith("demo.model")) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				Object value = f.get(object);
				assertObject(name + "." + f.getName(), value);
			}
		}
	}
}
