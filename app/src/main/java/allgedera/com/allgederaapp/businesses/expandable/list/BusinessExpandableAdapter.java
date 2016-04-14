package allgedera.com.allgederaapp.businesses.expandable.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;

import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.entities.BusinessChild;
import allgedera.com.allgederaapp.businesses.entities.BusinessParent;
import allgedera.com.allgederaapp.urlImages.ImageLoader;

/**
 * Created by user0 on 03/04/2016.
 */
public class BusinessExpandableAdapter extends ExpandableRecyclerAdapter<BusinessParentViewHolder, BusinessChildViewHolder> {

    private LayoutInflater mInflater;
    private Context context;

    public BusinessExpandableAdapter(Context context, List parentItemList) {
        super(context, parentItemList);
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public BusinessParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.business_parent_item, viewGroup, false);
        return new BusinessParentViewHolder(view);
    }

    @Override
    public BusinessChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.business_child_item, viewGroup, false);
        return new BusinessChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(BusinessParentViewHolder businessParentViewHolder, int i, Object parentObject) {
        BusinessParent businessParent = (BusinessParent) parentObject;
        businessParentViewHolder.mBusinessNameTV.setText(businessParent.getName());
        businessParentViewHolder.mBusinessCategoryTV.setText(businessParent.getCategory());
        if (businessParent.getLogo() != null) {
            ImageLoader imgLoader = new ImageLoader(this.context);
            imgLoader.displayImage(businessParent.getLogo(), businessParentViewHolder.mBusinessLogoIV);
        }
    }

    @Override
    public void onBindChildViewHolder(final BusinessChildViewHolder businessChildViewHolder, int i, Object childObject) {
        BusinessChild businessChild = (BusinessChild) childObject;
        if (businessChild.getImageUrl() != null) {
            ImageLoader imgLoader = new ImageLoader(this.context);
            imgLoader.displayImage(businessChild.getImageUrl(), businessChildViewHolder.mBusinessImageIV);
        }
        businessChildViewHolder.mBusinessAboutTV.setText("\n" + businessChild.getAbout() + "\n\n");
        if (businessChild.getAddress() != null)
            if (businessChild.getCity() != null)
                businessChildViewHolder.mBusinessAboutTV.append(businessChild.getAddress() + ", " + businessChild.getCity() + "\n\n");
            else
                businessChildViewHolder.mBusinessAboutTV.append(businessChild.getAddress() + "\n\n");
        else if (businessChild.getCity() != null)
            businessChildViewHolder.mBusinessAboutTV.append(businessChild.getCity() + "\n\n");

        if (businessChild.getPhone() != null)
            businessChildViewHolder.mBusinessAboutTV.append("טלפון: "  + businessChild.getPhone() + "\n");

        businessChildViewHolder.mBusinessCenterBusinessOnMapBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "center", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
