package com.projet.controller;

import java.util.List;

import com.projet.model.Country;

public class AffichageForRest<E> {
	 private Long totalElements;
	 private int size;
	 private int page;
	 private int lastPage;
	 
		public Long getTotalElements() {
			return totalElements;
		}
		public void setTotalElements(Long totalElements) {
			this.totalElements = totalElements;
		}
		
	 
	 
	 
	 
	 public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	private List<E> resultList;
	
	 public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public List<E> getResultList() {
		return resultList;
	}
	public void setResultList(List<E> resultList) {
		this.resultList = resultList;
	}

	
	
}
