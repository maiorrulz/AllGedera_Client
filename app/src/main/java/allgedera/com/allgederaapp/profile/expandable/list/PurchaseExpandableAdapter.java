package allgedera.com.allgederaapp.profile.expandable.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Purchase;
import allgedera.com.allgederaapp.profile.entities.PurchaseChild;
import allgedera.com.allgederaapp.profile.entities.PurchaseParent;

public class PurchaseExpandableAdapter extends ExpandableRecyclerAdapter<PurchaseParentViewHolder, PurchaseChildViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    List<Purchase> mPurchases;

    public PurchaseExpandableAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public PurchaseParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.purchase_parent_item, viewGroup, false);
        return new PurchaseParentViewHolder(view);
    }

    @Override
    public PurchaseChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.purchase_child_item, viewGroup, false);
        return new PurchaseChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(PurchaseParentViewHolder purchaseParentViewHolder, int i, Object parentObject) {
        PurchaseParent purchaseParent = (PurchaseParent) parentObject;
        purchaseParentViewHolder.mCouponPurchased.setText(context.getString(R.string.coupon_purchased, purchaseParent.getCoupon_id()));
        purchaseParentViewHolder.mPurchaseDate.setText(context.getString(R.string.purchase_date));
        purchaseParentViewHolder.mDate.setText(context.getString(R.string.date, purchaseParent.getDate()));
    }

    @Override
    public void onBindChildViewHolder(PurchaseChildViewHolder purchaseChildViewHolder, int i, Object childObject) {
        PurchaseChild purchaseChild = (PurchaseChild) childObject;
        purchaseChildViewHolder.mPaidTV.setText(context.getString(R.string.paid, purchaseChild.getPrice()));
        purchaseChildViewHolder.mCreditCardTV.setText(context.getString(R.string.credit, purchaseChild.getCredit_number()));
        purchaseChildViewHolder.mReceiptTV.setText(context.getString(R.string.receipt));
        purchaseChildViewHolder.mReceiptNumberTV.setText(context.getString(R.string.receipt_number, purchaseChild.getReceipt()));
    }
}
