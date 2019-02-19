package comp3350.schrodingers.presentation;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;

import comp3350.schrodingers.R;

public class PersonInfo extends AppCompatActivity {
    private UsersPersistence userList = Services.getUsersPersistence();
    private User user = userList.getUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        EditText userName = (EditText) findViewById(R.id.username);
        user = userList.getUser();
        userName.setText(user.getUserName());
        EditText userEmail = (EditText) findViewById(R.id.email);
        userEmail.setText(user.getEmail());

        if(!user.getAddress().isEmpty()) {
            EditText userAddress = (EditText) findViewById(R.id.address);
            userAddress.setText(user.getAddress().getAddress());
            EditText userState = (EditText) findViewById(R.id.province);
            userState.setText(user.getAddress().getState());
            EditText userZip = (EditText) findViewById(R.id.zip);
            userZip.setText(user.getAddress().getPostalCode());
            EditText userCountry = (EditText) findViewById(R.id.country);
            userCountry.setText(user.getAddress().getCountry());
        }
        EditText userPhone = (EditText) findViewById(R.id.phone);
        //userPhone.setText(User.getPhone());
    }

    public void buttonInfoUpdate(View v){
        EditText editName = (EditText)findViewById(R.id.username);
        EditText editEmail = (EditText)findViewById(R.id.email);
        EditText editAddress = (EditText)findViewById(R.id.address);
        EditText editState = (EditText) findViewById(R.id.province);
        EditText editZip = (EditText) findViewById(R.id.zip);
        EditText editCountry = (EditText) findViewById(R.id.country);
        EditText editPhone = (EditText)findViewById(R.id.phone);

        String validate = validateInfo(editName.getText().toString(),editEmail.getText().toString());
        if(validate == null){
            User newUser = new User(editEmail.getText().toString(), editName.getText().toString(),user.getPassword());
            user = userList.editUser(newUser);
            //user.changeName(editName.getText().toString());
            //user.changeEmail(editEmail.getText().toString());
            System.out.println();
            Snackbar.make(findViewById(R.id.person_info), R.string.changes_applied,
                    Snackbar.LENGTH_SHORT).show();
        }else{
            Messages.warning(this, validate);
        }


    }
    private String validateInfo(String name, String email){
        if(name.length() == 0)
            return "Name required";

        if(email.length() == 0)
            return "Email required";
        else{
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if(!matcher.matches())
                return "Email not valid";
        }
        return null;
    }
}
