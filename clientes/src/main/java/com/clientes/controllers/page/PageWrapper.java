package com.clientes.controllers.page;

import org.springframework.data.domain.Page;
import org.springframework.util.comparator.InvertibleComparator;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageWrapper<T> {
	private Page<T> page;
	private UriComponentsBuilder uriBuilder;
	private static final int MAX_PAGE_ITEM_DISPLAY = 5;
	private List<PageItem> itens;
	private int currentNumber;

	public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest) {
		this.page = page;
		String httpUrl = httpServletRequest.getRequestURL()
				.append(httpServletRequest.getQueryString() != null ? "?" + httpServletRequest.getQueryString() : "")
				.toString().replaceAll("\\", "%20");
		this.uriBuilder = UriComponentsBuilder.fromHttpUrl(httpUrl);

		itens = new ArrayList<PageItem>();

		currentNumber = page.getNumber() + 1;

		int start, size = 0;

		if (page.getTotalPages() <= MAX_PAGE_ITEM_DISPLAY) {
			start = 1;
			size = page.getTotalPages();
		} else {
			if (currentNumber <= MAX_PAGE_ITEM_DISPLAY - MAX_PAGE_ITEM_DISPLAY / 2) {
				start = 1;
				size = MAX_PAGE_ITEM_DISPLAY;
			} else if (currentNumber >= page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY / 2) {
				start = page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY + 1;
				size = MAX_PAGE_ITEM_DISPLAY;
			} else {
				start = currentNumber - MAX_PAGE_ITEM_DISPLAY;
				size = MAX_PAGE_ITEM_DISPLAY;
			}

			for (int i = 0; i < size; i++) {
				itens.add(new PageItem(start + i, (start + i) == currentNumber));
			}

		}
	}
	
	public List<PageItem> getItens(){
		return itens;
	}
	
	public List<T> getConteudo(){
		return page.getContent();
	}
	
	public boolean isVazia() {
		return page.getContent().isEmpty();
	}
	
	public int getAtual() {
		return page.getNumber();
	}
	
	public int getNumber() {
		return currentNumber;
	}
	
	public boolean isPrimeira(){
		return page.isFirst();
	}
	
	public boolean isUltima() {
		return page.isLast();
	}
	
	public int getTotal() {
		return page.getTotalPages();
	}
	public long getTotalElementos() {
		return page.getTotalElements();
	}
	
	public int getSize() {
		return page.getSize(); 
	}
	
	public boolean isHasPreviousPage() {
		return page.hasPrevious();
	}
	
	public boolean isHasNextPage() {
		return page.hasNext();
	}
	
	public String urlParaPagina(int pagina) {
		return uriBuilder.replaceQueryParam("page", pagina).build(true).encode().toUriString();
	}
	
	public String urlOrdenada(String propriedades) {
		UriComponentsBuilder uriBuilderOrder = UriComponentsBuilder.fromUriString(uriBuilder.build(true).encode().toUriString());
		String valorSort = String.format("%S,%s",propriedades, inverteDirecao(propriedades));
		return uriBuilderOrder.replaceQueryParam("sort",valorSort).build(true).encode().toUriString();
	}

	private Object inverteDirecao(String propriedades) {
		// TODO Auto-generated method stub
		return null;
	}

	public class PageItem {
		private int number;
		private boolean current;

		public PageItem(int number, boolean current) {
			super();
			this.number = number;
			this.current = current;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public boolean isCurrent() {
			return current;
		}

		public void setCurrent(boolean current) {
			this.current = current;
		}

	}

}
