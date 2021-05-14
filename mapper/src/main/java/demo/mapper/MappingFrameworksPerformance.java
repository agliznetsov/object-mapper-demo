package demo.mapper;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import demo.mapper.dozer.DozerConverter;
import demo.mapper.manual.ManualConverter;
import demo.mapper.mapstruct.MapStructConverter;
import demo.mapper.orika.OrikaConverter;
import demo.model.destination.Asset;
import demo.model.source.TermImpl;

@State(Scope.Benchmark)
public class MappingFrameworksPerformance {
	private TermImpl term = TermImpl.randomTerm();

	private static final OrikaConverter ORIKA_CONVERTER = new OrikaConverter();
	private static final DozerConverter DOZER_CONVERTER = new DozerConverter();
	private static final MapStructConverter MAPSTRUCT_CONVERTER = MapStructConverter.MAPPER;
	private static final ManualConverter MANUAL_CONVERTER = new ManualConverter();

	@Setup
	public void setUp() {
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public Asset orika() {
		return ORIKA_CONVERTER.convert(term);
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public Asset dozer() {
		return DOZER_CONVERTER.convert(term);
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public Asset mapStruct() {
		return MAPSTRUCT_CONVERTER.convert(term);
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public Asset manual() {
		return MANUAL_CONVERTER.convert(term);
	}




}
