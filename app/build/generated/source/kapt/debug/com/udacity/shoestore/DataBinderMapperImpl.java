package com.udacity.shoestore;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.udacity.shoestore.databinding.ActivityMainBindingImpl;
import com.udacity.shoestore.databinding.FragmentDetailShoeBindingImpl;
import com.udacity.shoestore.databinding.FragmentInstructionBindingImpl;
import com.udacity.shoestore.databinding.FragmentLoginBindingImpl;
import com.udacity.shoestore.databinding.FragmentRegisterBindingImpl;
import com.udacity.shoestore.databinding.FragmentShoesBindingImpl;
import com.udacity.shoestore.databinding.FragmentWelcomeBindingImpl;
import com.udacity.shoestore.databinding.ItemShoeLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTDETAILSHOE = 2;

  private static final int LAYOUT_FRAGMENTINSTRUCTION = 3;

  private static final int LAYOUT_FRAGMENTLOGIN = 4;

  private static final int LAYOUT_FRAGMENTREGISTER = 5;

  private static final int LAYOUT_FRAGMENTSHOES = 6;

  private static final int LAYOUT_FRAGMENTWELCOME = 7;

  private static final int LAYOUT_ITEMSHOELAYOUT = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.fragment_detail_shoe, LAYOUT_FRAGMENTDETAILSHOE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.fragment_instruction, LAYOUT_FRAGMENTINSTRUCTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.fragment_shoes, LAYOUT_FRAGMENTSHOES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.fragment_welcome, LAYOUT_FRAGMENTWELCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.udacity.shoestore.R.layout.item_shoe_layout, LAYOUT_ITEMSHOELAYOUT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDETAILSHOE: {
          if ("layout/fragment_detail_shoe_0".equals(tag)) {
            return new FragmentDetailShoeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_detail_shoe is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINSTRUCTION: {
          if ("layout/fragment_instruction_0".equals(tag)) {
            return new FragmentInstructionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_instruction is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTER: {
          if ("layout/fragment_register_0".equals(tag)) {
            return new FragmentRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSHOES: {
          if ("layout/fragment_shoes_0".equals(tag)) {
            return new FragmentShoesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_shoes is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWELCOME: {
          if ("layout/fragment_welcome_0".equals(tag)) {
            return new FragmentWelcomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_welcome is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSHOELAYOUT: {
          if ("layout/item_shoe_layout_0".equals(tag)) {
            return new ItemShoeLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_shoe_layout is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "shoe");
      sKeys.put(2, "user");
      sKeys.put(3, "viewModelBinding");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/activity_main_0", com.udacity.shoestore.R.layout.activity_main);
      sKeys.put("layout/fragment_detail_shoe_0", com.udacity.shoestore.R.layout.fragment_detail_shoe);
      sKeys.put("layout/fragment_instruction_0", com.udacity.shoestore.R.layout.fragment_instruction);
      sKeys.put("layout/fragment_login_0", com.udacity.shoestore.R.layout.fragment_login);
      sKeys.put("layout/fragment_register_0", com.udacity.shoestore.R.layout.fragment_register);
      sKeys.put("layout/fragment_shoes_0", com.udacity.shoestore.R.layout.fragment_shoes);
      sKeys.put("layout/fragment_welcome_0", com.udacity.shoestore.R.layout.fragment_welcome);
      sKeys.put("layout/item_shoe_layout_0", com.udacity.shoestore.R.layout.item_shoe_layout);
    }
  }
}
