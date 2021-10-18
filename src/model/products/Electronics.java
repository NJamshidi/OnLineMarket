package model.products;

import model.enums.BrandOfDevice;

public class Electronics extends Product{
    private BrandOfDevice brandOfDevice;

    public Electronics(int count, double amount, BrandOfDevice brandOfDevice) {
        super(count, amount);
        this.brandOfDevice = brandOfDevice;
    }

    public BrandOfDevice getBrandOfDevice() {
        return brandOfDevice;
    }

    public void setBrandOfDevice(BrandOfDevice brandOfDevice) {
        this.brandOfDevice = brandOfDevice;
    }
}
