package TechboostJune2020.CodeTrial;

public enum enumClass {
	ROLE_CREATED("Role is created"),
	ROLE_DESCRIPTION_UPDATED("Role description is updated"),
	ROLE_DELETED("Role is deleted"),
	UNKNOWN("unknown");

	private final String actionDetail;

	public String getActionDetail() {
		return this.actionDetail;
	}

	enumClass(final String actionDetail) {
		this.actionDetail = actionDetail;
	}
}
