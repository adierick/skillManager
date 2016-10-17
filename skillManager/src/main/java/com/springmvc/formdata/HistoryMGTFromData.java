package com.springmvc.formdata;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.HistoryMGT;

@Component
public class HistoryMGTFromData {

	@Valid
	private HistoryMGT historyMGT;
	private Long personId;
	
	public HistoryMGTFromData() {
		super();
	}

	public HistoryMGTFromData(HistoryMGT historyMGT, Long personId) {
		super();
		this.historyMGT = historyMGT;
		this.personId = personId;
	}

	public HistoryMGT getHistoryMGT() {
		return historyMGT;
	}

	public void setHistoryMGT(HistoryMGT historyMGT) {
		this.historyMGT = historyMGT;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

}
