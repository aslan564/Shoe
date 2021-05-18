package com.udacity.shoestore.databinding;
import com.udacity.shoestore.R;
import com.udacity.shoestore.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentDetailShoeBindingImpl extends FragmentDetailShoeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.save_button, 5);
        sViewsWithIds.put(R.id.cancel_button, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentDetailShoeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentDetailShoeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[6]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[4]
            , (android.widget.Button) bindings[5]
            );
        this.etShoeCompany.setTag(null);
        this.etShoeDesc.setTag(null);
        this.etShoeName.setTag(null);
        this.etShoeSize.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.shoe == variableId) {
            setShoe((com.udacity.shoestore.models.Shoe) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setShoe(@Nullable com.udacity.shoestore.models.Shoe Shoe) {
        this.mShoe = Shoe;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.shoe);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String stringValueOfShoeSize = null;
        com.udacity.shoestore.models.Shoe shoe = mShoe;
        java.lang.String shoeName = null;
        java.lang.String shoeCompany = null;
        double shoeSize = 0.0;
        java.lang.String shoeDescription = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (shoe != null) {
                    // read shoe.name
                    shoeName = shoe.getName();
                    // read shoe.company
                    shoeCompany = shoe.getCompany();
                    // read shoe.size
                    shoeSize = shoe.getSize();
                    // read shoe.description
                    shoeDescription = shoe.getDescription();
                }


                // read String.valueOf(shoe.size)
                stringValueOfShoeSize = java.lang.String.valueOf(shoeSize);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etShoeCompany, shoeCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etShoeDesc, shoeDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etShoeName, shoeName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etShoeSize, stringValueOfShoeSize);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): shoe
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}