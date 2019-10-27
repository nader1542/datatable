package com.example.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class DataTableResultInfo {
	private List<Employee> data;
	private int draw;// the NO.of requests
	private int length;
	private long recordsTotal;
	private long recordsFiltered;

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

}
