package allgedera.com.allgederaapp.profile.entities;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

public class PurchaseParent implements ParentObject {

    int coupon_id;
    String date;
    List<Object> mChildren;

    public PurchaseParent(int coupon_id, String date) {
        this.coupon_id = coupon_id;
        this.date = date;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mChildren;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mChildren = list;
    }
}
