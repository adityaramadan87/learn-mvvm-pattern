package co.id.ramadanrizky.mvvmpattern.viewmodel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import co.id.ramadanrizky.mvvmpattern.pojo.User;

public class LoginViewModel extends BaseObservable {
    private User user;

    private String messageSuccess = "Login Successfull";
    private String messageFailed = "Login Failed";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage(){
        return toastMessage;
    }

    private void setToastMessage(String toastMessage){
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail(){
        return user.getEmail();
    }

    public void  setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    @Bindable
    public String getUserPassword(){
        return user.getPassword();
    }

    public LoginViewModel(){
        user = new User("", "");
    }

    public void onLoginClicked(){
        if (isInputDataValid()){
            setToastMessage(messageSuccess);
        }else {
            setToastMessage(messageFailed);
        }
    }

    private boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}
