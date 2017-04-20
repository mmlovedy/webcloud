package com.springmvc.model;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: Streets
 * @Package com.springmvc.model
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/12 上午11:40
 */
public class Street {
//    public String provinceCode;
//    public String cityCode;
//    public String countryCode;
//    public String code;
//    public String detaillAddress;
//    public String detaillAddressPinyin;
    public String address;
    public String addressPinyin;

//    public Street(String proinceCode, String cityCode, String countryCode,
//                  String code, String detaillAddress, String detaillAddressPinyin,
//                  String address, String addressPinyin) {
//        this.provinceCode = proinceCode;
//        this.cityCode = cityCode;
//        this.countryCode = countryCode;
//        this.code = code;
//        this.detaillAddress = detaillAddress;
//        this.detaillAddressPinyin = detaillAddressPinyin;
//        this.addressPinyin = addressPinyin;
//        this.address = address;
//    }

    public Street( String address, String addressPinyin) {
        this.addressPinyin = addressPinyin;
        this.address = address;
    }

    public Street() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressPinyin() {
        return addressPinyin;
    }

    public void setAddressPinyin(String addressPinyin) {
        this.addressPinyin = addressPinyin;
    }
}