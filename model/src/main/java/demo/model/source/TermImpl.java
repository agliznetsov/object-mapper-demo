package demo.model.source;

import java.util.UUID;

import lombok.Data;

@Data
public class TermImpl extends ResourceImpl {

	private StatusImpl status;
	private VocabularyImpl vocabulary;
	private AssetTypeImpl type;

	private boolean excludedFromHyperlinking;

	protected String signifier;
	protected String displayName;
	protected Double articulationScore;
	protected Double avgRating;
	protected Integer ratingsCount;

	public static TermImpl randomTerm() {
		TermImpl term = new TermImpl();
		ResourceImpl.fill(term);
		term.setStatus(StatusImpl.randomStatus());
		term.setVocabulary(VocabularyImpl.randomVocabulary());
		term.setStatus(StatusImpl.randomStatus());
		term.setType(AssetTypeImpl.randomType());
		term.setSignifier("signifier");
		term.setDisplayName("displayname");
		term.setArticulationScore(1.0);
		term.setAvgRating(1.0);
		term.setRatingsCount(1);
		return term;
	}
}
