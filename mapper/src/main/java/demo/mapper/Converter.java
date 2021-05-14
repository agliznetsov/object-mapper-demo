package demo.mapper;

import demo.model.destination.Asset;
import demo.model.source.TermImpl;

public interface Converter {
    Asset convert(TermImpl term);
}
