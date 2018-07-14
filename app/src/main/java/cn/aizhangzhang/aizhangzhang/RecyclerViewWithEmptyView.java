package cn.aizhangzhang.aizhangzhang;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class RecyclerViewWithEmptyView extends RecyclerView{
    private View emptyView;
    private static final String TAG ="RecyclerViewWithEmpty";

 final private AdapterDataObserver observer = new AdapterDataObserver() {
     @Override
     public void onChanged() {
         checkIfEmpty();
     }

     @Override
     public void onItemRangeInserted(int positionStart, int itemCount) {
         Log.i(TAG, "onItemRangeInserted" + itemCount);
         checkIfEmpty();
     }

     @Override
     public void onItemRangeRemoved(int positionStart, int itemCount) {
         checkIfEmpty();
     }
 };

    private void checkIfEmpty() {
        if (emptyView != null && getAdapter() != null) {
            final boolean emptyViewVisible =
                    getAdapter().getItemCount() == 0;
            emptyView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
            setVisibility(emptyViewVisible ? GONE : VISIBLE);
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }

        checkIfEmpty();
    }

    //设置没有内容时，提示用户的空布局
    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        checkIfEmpty();
    }

    public RecyclerViewWithEmptyView(Context context) {
        super(context);
    }

    public RecyclerViewWithEmptyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewWithEmptyView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
