package allgedera.com.allgederaapp.businesses.expandable.list;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user0 on 02/04/2016.
 */
public class BusinessParent implements ParentObject {

    private String name;
    private String logo;
    List<Object> mChildren;

    public BusinessParent(String name, String logo) {
        this.name = name;
        this.logo=logo;
        this.mChildren = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
