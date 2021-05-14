package demo.model.source;

import lombok.Data;

@Data
public class StatusImpl extends ResourceImpl {

	private String signifier;
	private String description;

	public static StatusImpl randomStatus() {
		StatusImpl status = new StatusImpl();
		status.setSignifier("signifier");
		status.setDescription("description");
		ResourceImpl.fill(status);
		return status;
	}
}
