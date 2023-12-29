package vanphuc.booktraveltickets.FRAGMENT;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vanphuc.booktraveltickets.R;

public
class settingfragment extends Fragment {



    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.settingfragment, container, false);
    }
}