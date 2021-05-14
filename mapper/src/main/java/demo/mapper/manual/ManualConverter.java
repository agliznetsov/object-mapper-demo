package demo.mapper.manual;

import java.util.UUID;

import demo.mapper.Converter;
import demo.model.destination.Asset;
import demo.model.destination.NamedResourceReference;
import demo.model.source.ResourceImpl;
import demo.model.source.TermImpl;

public class ManualConverter implements Converter {

	@Override
	public Asset convert(TermImpl term) {
		Asset asset = new Asset();
		asset.setId(UUID.fromString(term.getId()));
		asset.setCreatedBy(UUID.fromString(term.getCreatedBy()));
		asset.setCreatedOn(term.getCreatedOn());
		asset.setLastModifiedBy(UUID.fromString(term.getLastModifiedBy()));
		asset.setLastModifiedOn(term.getCreatedOn());
		asset.setSystem(term.isSystem());

		asset.setName(term.getSignifier());

		asset.setDisplayName(term.getDisplayName());
		asset.setArticulationScore(term.getArticulationScore());
		asset.setExcludedFromAutoHyperlinking(term.isExcludedFromHyperlinking());
		asset.setDomain(toRef(term.getVocabulary()));
		asset.setType(toRef(term.getType()));
		asset.setStatus(toRef(term.getStatus()));
		asset.setAvgRating(term.getAvgRating());
		asset.setRatingsCount(term.getRatingsCount());

		return asset;
	}

	private NamedResourceReference toRef(ResourceImpl resource) {
		NamedResourceReference res = new NamedResourceReference();
		res.setId(UUID.fromString(resource.getId()));
		res.setName(resource.getName());
		return res;
	}


}
