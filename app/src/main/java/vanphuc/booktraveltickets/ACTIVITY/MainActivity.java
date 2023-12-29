package vanphuc.booktraveltickets.ACTIVITY;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import vanphuc.booktraveltickets.FRAGMENT.diadiemfragment;
import vanphuc.booktraveltickets.FRAGMENT.settingfragment;
import vanphuc.booktraveltickets.FRAGMENT.thongbaofragmnet;
import vanphuc.booktraveltickets.FRAGMENT.trangchufragment;
import vanphuc.booktraveltickets.R;
import vanphuc.booktraveltickets.databinding.ActivityMainBinding;

public
class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(binding.getRoot());
        replaceFragment(new trangchufragment ());


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                replaceFragment(new trangchufragment ());
            } else if (item.getItemId() == R.id.thongbao) {
                replaceFragment(new thongbaofragmnet ());
            } else if (item.getItemId() == R.id.diadiem) {
                replaceFragment(new diadiemfragment ());
            }else if (item.getItemId() == R.id.taikhoan) {
                replaceFragment(new settingfragment ());
            }

            return true;
        });

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}