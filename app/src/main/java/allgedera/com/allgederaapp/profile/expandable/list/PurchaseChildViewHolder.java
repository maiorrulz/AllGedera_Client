package allgedera.com.allgederaapp.profile.expandable.list;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import allgedera.com.allgederaapp.R;

/**
 * Created by user0 on 02/06/2016.
 */
public class PurchaseChildViewHolder extends ChildViewHolder {

    public TextView mPaidTV;
    public TextView mCreditCardTV;
    public TextView mReceiptTV;
    public TextView mReceiptNumberTV;

    public PurchaseChildViewHolder(View itemView) {
        super(itemView);
        mPaidTV = (TextView) itemView.findViewById(R.id.tv_pricePaid);
        mCreditCardTV = (TextView) itemView.findViewById(R.id.tv_creditCardUsed);
        mReceiptTV = (TextView) itemView.findViewById(R.id.tv_receipt);
        mReceiptNumberTV = (TextView) itemView.findViewById(R.id.tv_receiptNumber);
    }
}
