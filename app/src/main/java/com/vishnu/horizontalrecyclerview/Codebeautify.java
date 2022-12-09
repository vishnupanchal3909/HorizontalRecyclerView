package com.vishnu.horizontalrecyclerview;

import java.util.ArrayList;

public class Codebeautify {

    private float page;
    private float per_page;
    private float totalrecord;
    private float total_pages;
    ArrayList< Object > data = new ArrayList < Object > ();


    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getPer_page() {
        return per_page;
    }

    public float getTotalrecord() {
        return totalrecord;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setPer_page(float per_page) {
        this.per_page = per_page;
    }

    public void setTotalrecord(float totalrecord) {
        this.totalrecord = totalrecord;
    }

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }
}
