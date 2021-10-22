package model.products;

import model.enums.BrandOfDevice;
import model.enums.TypeOfProducts;

public class Electronics extends Product{
    private BrandOfDevice brandOfDevice;
    private Product producet;

    public Electronics(int count, double cost, BrandOfDevice brandOfDevice) {
        super(count, cost);
        this.brandOfDevice = brandOfDevice;
        typeOfProducts = TypeOfProducts.ELECTRONICS;
    }

    public Electronics(int id, int count, double cost, BrandOfDevice brandOfDevice) {
        super(id, count, cost);
        this.brandOfDevice = brandOfDevice;
        typeOfProducts = TypeOfProducts.ELECTRONICS;
    }

    public Electronics() {
        super();
    }



    public BrandOfDevice getBrandOfDevice() {
        return brandOfDevice;
    }

    public void setBrandOfDevice(BrandOfDevice brandOfDevice) {
        this.brandOfDevice = brandOfDevice;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                super.toString() + '\'' +
                "brandOfDevice=" + brandOfDevice +
                '}';
    }
}
