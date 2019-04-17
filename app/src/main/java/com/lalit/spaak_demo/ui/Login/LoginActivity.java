package com.lalit.spaak_demo.ui.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lalit.spaak_demo.R;
import com.lalit.spaak_demo.ui.Base.BaseActivity;
import com.lalit.spaak_demo.ui.Main.MainActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    EditText ed_email , ed_pass ;
    Button btn_login ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);
        mPresenter.onAttach(LoginActivity.this);

        init();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.Login(ed_email.getText().toString(), ed_pass.getText().toString());
            }
        });

    }

    private void init() {

        ed_email = findViewById(R.id.ed_email);
        ed_pass = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);

    }

    @Override
    protected void setUp() {

    }

    @Override
    public void OpenHome() {
     startActivity(new Intent(LoginActivity.this , MainActivity.class));
    }
}
