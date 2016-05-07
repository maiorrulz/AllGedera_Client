package allgedera.com.allgederaapp.coupons.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Coupon;
import allgedera.com.allgederaapp.urlImages.ImageLoader;


public class CouponAdapter extends RecyclerView.Adapter<CouponViewHolder> {

    List<Coupon> coupons;
    Context context;
    int itemWidth;
    int itemHeight;

    public CouponAdapter(List<Coupon> coupons) {
        this.coupons = coupons;
        itemWidth = 0;
        itemHeight = 0;
    }

    public CouponAdapter(Context context, List<Coupon> coupons, int itemWidth, int itemHeight) {
        this.context = context;
        this.coupons = coupons;
        this.itemWidth = itemWidth;
        this.itemHeight = itemHeight;
    }

    @Override
    public CouponViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.coupon_item, viewGroup, false);
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
        holder.mCouponId.setText(context.getString(R.string.coupon_number, coupons.get(position).getId()));
        if (coupons.get(position).getImage() != null) {
            ImageLoader imgLoader = new ImageLoader(this.context);
            imgLoader.displayImage(coupons.get(position).getImage(), holder.mCouponImageIV);
        }
        holder.mCouponBusinessNameTV.setText("" + coupons.get(position).getBusiness_id());
        holder.mCouponPriceTV.setText(context.getString(R.string.coupon_price, coupons.get(position).getPrice()));
        holder.mCouponDetails.setText(context.getString(R.string.purchase_details, coupons.get(position).getDetails()));
    }

    @Override
    public int getItemCount() {
        return coupons.size();
    }
}
