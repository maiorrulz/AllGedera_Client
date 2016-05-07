package allgedera.com.allgederaapp.businesses.entities;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user0 on 02/04/2016.
 */
public class BusinessParent implements ParentObject {

    private String name;
    private String category;
    private String logo;
    List<Object> mChildren;

    public BusinessParent(String name, String category, String logo) {
        this.name = name;
        this.category = category;
        this.logo = logo;
        this.mChildren = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
