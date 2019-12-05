package co.id.ramadanrizky.mvvmpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import co.id.ramadanrizky.mvvmpattern.databinding.ActivityMainBinding;
import co.id.ramadanrizky.mvvmpattern.viewmodel.LoginViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setLoginViewModel(new LoginViewModel());
        mainBinding.executePendingBindings();
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message){
        if (message != null){
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
