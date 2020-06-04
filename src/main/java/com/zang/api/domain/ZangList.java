package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Iterator;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ZangList<T> implements Iterable<T> {

    Integer page;
    @JsonProperty(value = "num_pages")
    Integer numpages;
    @JsonProperty(value = "page_size")
    Integer pagesize;
    Integer total;
    Integer start;
    Integer end;
    String uri;
    @JsonProperty(value = "first_page_uri")
    String firstPageUri;
    @JsonProperty(value = "previous_page_uri")
    String previousPageUri;
    @JsonProperty(value = "next_page_uri")
    String nextPageUri;
    @JsonProperty(value = "last_page_uri")
    String lastPageUri;

    List<T> elements;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNumpages() {
        return numpages;
    }

    public void setNumpages(Integer numpages) {
        this.numpages = numpages;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFirstPageUri() {
        return firstPageUri;
    }

    public void setFirstPageUri(String firstPageUri) {
        this.firstPageUri = firstPageUri;
    }

    public String getPreviousPageUri() {
        return previousPageUri;
    }

    public void setPreviousPageUri(String previousPageUri) {
        this.previousPageUri = previousPageUri;
    }

    public String getNextPageUri() {
        return nextPageUri;
    }

    public void setNextPageUri(String nextPageUri) {
        this.nextPageUri = nextPageUri;
    }

    public String getLastPageUri() {
        return lastPageUri;
    }

    public void setLastPageUri(String lastPageUri) {
        this.lastPageUri = lastPageUri;
    }

    protected abstract void mapElements(List<T> elements);

    protected void setElements(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> iterator() {
        if (elements == null) return null;
        return elements.iterator();
    }
}
