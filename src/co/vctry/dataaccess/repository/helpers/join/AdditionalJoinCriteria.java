package co.vctry.dataaccess.repository.helpers.join;

import org.apache.commons.lang3.StringUtils;

import co.vctry.dataaccess.repository.DatabaseTable;
import co.vctry.dataaccess.repository.helpers.SQLComparisonType;
import co.vctry.dataaccess.repository.helpers.SQLConditionalType;
import co.vctry.dataaccess.repository.helpers.PostgreFunctionType;

public class AdditionalJoinCriteria {
	private SQLConditionalType conditional;
	private DatabaseTable joinOnTable;
	private String joinOnTableName;
	private SQLComparisonType comparison;
	private PostgreFunctionType joinOnApplyFunction;
	private String joinOnFieldName;
	private DatabaseTable externalTable;
	private String externalTableName;
	private String externalTableFieldName;
	
	public AdditionalJoinCriteria conditional(SQLConditionalType conditional) {
		this.conditional = conditional;
		return this;
	}
	
	public AdditionalJoinCriteria joinOnTable(DatabaseTable joinOnTable) {
		this.joinOnTable = joinOnTable;
		return this;
	}
	
	public AdditionalJoinCriteria conditional(String joinOnTableName) {
		this.joinOnTableName = joinOnTableName;
		return this;
	}
	
	public AdditionalJoinCriteria comparison(SQLComparisonType comparison) {
		this.comparison = comparison;
		return this;
	}
	
	public AdditionalJoinCriteria joinOnApplyFunction(PostgreFunctionType joinOnApplyFunction) {
		this.joinOnApplyFunction = joinOnApplyFunction;
		return this;
	}
	
	public AdditionalJoinCriteria joinOnFieldName(String joinOnFieldName) {
		this.joinOnFieldName = joinOnFieldName;
		return this;
	}
	
	public AdditionalJoinCriteria externalTable(DatabaseTable externalTable) {
		this.externalTable = externalTable;
		return this;
	}
	
	public AdditionalJoinCriteria externalTableName(String externalTableName) {
		this.externalTableName = externalTableName;
		return this;
	}
	
	public AdditionalJoinCriteria externalTableFieldName(String externalTableFieldName) {
		this.externalTableFieldName = externalTableFieldName;
		return this;
	}
	
	@Override
	public String toString() {
		if (!validate()) {
			return StringUtils.EMPTY;
		}
		
		if (joinOnTable != DatabaseTable.NONE) {
			joinOnTableName = joinOnTable.getLabel();
		}
		if (externalTable != DatabaseTable.NONE) {
			externalTableName = externalTable.getLabel();
		}

		StringBuilder sb = new StringBuilder(SPACE).
			append(conditional.getLabel()).
			append(SPACE);
	
		if (joinOnApplyFunction != PostgreFunctionType.NONE) {
			sb.append(joinOnApplyFunction.getLabel()).
			append(OPEN_FUNCTION);
		}
	
		sb.append(joinOnTableName).
			append(TABLE_FIELD_SEPARATOR).
			append(joinOnFieldName);
	
		if (joinOnApplyFunction != PostgreFunctionType.NONE) {
			sb.append(CLOSE_FUNCTION);
		}
	
		sb.append(SPACE).
			append(comparison.getLabel()).
			append(SPACE);
	
		if (externalTable == DatabaseTable.NONE) {
			sb.append(PARAMETER_DESIGNATOR).
				append(joinOnTableName).
				append(joinOnFieldName);
		} else {
			sb.append(externalTableName).
				append(TABLE_FIELD_SEPARATOR).
				append(externalTableFieldName);
		}
	
		return sb.toString();
	}
	
	private boolean validate() {
		boolean valid = true;
		
		if (conditional == SQLConditionalType.NONE) {
			valid = false;
		}
		if (valid && (joinOnTable == DatabaseTable.NONE) && joinOnTableName.equals(StringUtils.EMPTY)) {
			valid = false;
		}
		if (valid && joinOnFieldName.equals(StringUtils.EMPTY)) {
			valid = false;
		}
		if (valid && (comparison == SQLComparisonType.NONE)) {
			valid = false;
		}
		if (valid && (externalTable == DatabaseTable.NONE) && externalTableName.equals(StringUtils.EMPTY)) {
			valid = false;
		}
		if (valid && externalTableFieldName.equals(StringUtils.EMPTY)) {
			valid = false;
		}
		
		return valid;
	}
	
	private static final String SPACE = " ";
	private static final String OPEN_FUNCTION = "(";
	private static final String CLOSE_FUNCTION = ")";
	private static final String PARAMETER_DESIGNATOR = ":";
	private static final String TABLE_FIELD_SEPARATOR = ".";

	public AdditionalJoinCriteria() {
		conditional = SQLConditionalType.NONE;
		joinOnTable = DatabaseTable.NONE;
		joinOnTableName = StringUtils.EMPTY;
		comparison = SQLComparisonType.NONE;
		joinOnApplyFunction = PostgreFunctionType.NONE;
		joinOnFieldName = StringUtils.EMPTY;
		externalTable = DatabaseTable.NONE;
		externalTableName = StringUtils.EMPTY;
		externalTableFieldName = StringUtils.EMPTY;
	}
}
