package allgedera.com.allgederaapp.coupons.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Coupon;


public class CouponAdapter extends RecyclerView.Adapter<CouponViewHolder> {

    List<Coupon> coupons;
    int itemWidth;
    int itemHeight;

    public CouponAdapter(List<Coupon> coupons) {
        this.coupons = coupons;
        itemWidth = 0;
        itemHeight = 0;
    }

    public CouponAdapter(List<Coupon> coupons, int itemWidth, int itemHeight) {
        this.coupons = coupons;
        this.itemWidth = itemWidth;
        this.itemHeight = itemHeight;
    }

    @Override
    public CouponViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coupon_item, viewGroup, false);
        if (itemWidth != 0 && itemHeight != 0) {
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.width = itemWidth;
            //params.height = itemHeight;
            view.setLayoutParams(params);
        }
        CouponViewHolder couponViewHolder = new CouponViewHolder(view);
        return couponViewHolder;
    }

    @Override
    public void onBindViewHolder(CouponViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return coupons.size();
    }
}
