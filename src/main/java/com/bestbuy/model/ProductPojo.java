package com.bestbuy.model;

public class ProductPojo {
private String name;
private String type;
private double price ;
private Integer shipping;
private String upc;
private String description ;
private String manufacturer;
private String model;
private String image ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(double price) {
        this.price = price;
    }



    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
/*{
  "name": "string",
  "type": "string",
  "price": 0,
  "shipping": 0,
  "upc": "string",
  "description": "string",
  "manufacturer": "string",
  "model": "string",
  "url": "string",
  "image": "string"
}*/