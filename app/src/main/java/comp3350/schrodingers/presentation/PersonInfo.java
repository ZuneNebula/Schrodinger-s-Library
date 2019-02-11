package comp3350.schrodingers.presentation;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.persistence.stubs.UsersPersistenceStub;
import comp3350.schrodingers.objects.User;

import comp3350.schrodingers.R;

public class PersonInfo extends AppCompatActivity {
    private UsersPersistenceStub userList = new UsersPersistenceStub();
    private User user = userList.getUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        EditText userName = (EditText) findViewById(R.id.username);
        userName.setText(user.getUserName());
        EditText userEmail = (EditText) findViewById(R.id.email);
        userEmail.setText(user.getEmail());
        EditText userAddress = (EditText) findViewById(R.id.address);
        //userAddress.setText(User.getAddress());
        EditText userPhone = (EditText) findViewById(R.id.phone);
        //userPhone.setText(User.getPhone());
    }

    public void buttonInfoUpdate(View v){
        EditText editName = (EditText)findViewById(R.id.username);
        EditText editEmail = (EditText)findViewById(R.id.email);
        EditText editAddress = (EditText)findViewById(R.id.address);
        EditText editPhone = (EditText)findViewById(R.id.phone);

        String validate = validateInfo(editName.getText().toString(),editEmail.getText().toString());
        if(validate == null){
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
