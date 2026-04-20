package iseecars.model;

public class Brand {
    private int brandId;
    private String brandName;

    public int getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}