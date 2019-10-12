package com.example.cooless.POJOs;


import java.util.List;

public class Offer {

    private Owner owner;
    private List<RequestSlice> slices = null;
    private String totalAmount;
    private String totalEmissionsKg;

    /**
     * No args constructor for use in serialization
     *
     */
    public Offer() {
    }

    /**
     *
     * @param slices
     * @param totalEmissionsKg
     * @param totalAmount
     * @param owner
     */
    public Offer(Owner owner, List<RequestSlice> slices, String totalAmount, String totalEmissionsKg) {
        super();
        this.owner = owner;
        this.slices = slices;
        this.totalAmount = totalAmount;
        this.totalEmissionsKg = totalEmissionsKg;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Offer withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public List<RequestSlice> getSlices() {
        return slices;
    }

    public void setSlices(List<RequestSlice> slices) {
        this.slices = slices;
    }

    public Offer withSlices(List<RequestSlice> slices) {
        this.slices = slices;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Offer withTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTotalEmissionsKg() {
        return totalEmissionsKg;
    }

    public void setTotalEmissionsKg(String totalEmissionsKg) {
        this.totalEmissionsKg = totalEmissionsKg;
    }

    public Offer withTotalEmissionsKg(String totalEmissionsKg) {
        this.totalEmissionsKg = totalEmissionsKg;
        return this;
    }

}


