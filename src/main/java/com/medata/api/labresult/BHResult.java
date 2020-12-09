package com.medata.api.labresult;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "BH")
public class BHResult extends LabResult {

	@OneToOne
	@JoinColumn(name = "ExtendedResultsId")
	private BHData bhData = null;

	@Transient
	String testResultType = "BH";

	public BHData getBhData() {
		return bhData;
	}

	public void setBhData(BHData bhData) {
		this.bhData = bhData;
	}
}
