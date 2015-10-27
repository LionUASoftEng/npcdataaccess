package org.npc.dataaccess.repository;

public enum DatabaseTable {
	NONE(""),
	PRODUCT("product"),
	EMPLOYEE("employee"),
	TRANSACTION("transaction"),
	TRANSACTIONENTRY("transactionentry"),
	TENDERENTRY("tenderentry");
	
	public String getLabel() {
		return label;
	}
	
	private final String label;
	
	private DatabaseTable(String label) {
		this.label = label;
	}
}
