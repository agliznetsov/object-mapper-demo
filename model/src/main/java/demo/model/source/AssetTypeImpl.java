package demo.model.source;

import lombok.Data;

@Data
public class AssetTypeImpl extends ResourceImpl {

	private boolean meta;
	private boolean displayNameEnabled;
	private boolean ratingEnabled;

	public static AssetTypeImpl randomType() {
		AssetTypeImpl assetType = new AssetTypeImpl();
		ResourceImpl.fill(assetType);
		return assetType;
	}
}
