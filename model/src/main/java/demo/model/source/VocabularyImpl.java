package demo.model.source;

import lombok.Data;

@Data
public class VocabularyImpl extends ResourceImpl {

	private String description;

	public static VocabularyImpl randomVocabulary() {
		VocabularyImpl vocabulary = new VocabularyImpl();
		ResourceImpl.fill(vocabulary);
		vocabulary.setDescription("desc");
		return vocabulary;
	}
}
