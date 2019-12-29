package com.example.ssp.newmessage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import fragment.PersonFragment;

public class RegisterActivity extends ActionBarActivity {
    EditText ed_code;
    ImageView iv_code;
    String realCode;
    Button bt_regist;
  Button button;
    ImageView iv_banck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);
        //验证码
        iv_code=(ImageView)findViewById(R.id.iv_shanCode);
        //必须先创建一个空 不然 realCode会空指针
        iv_code.setImageBitmap(Code.getInstance().createBitmap());
        ed_code=(EditText)findViewById(R.id.ed_writeCode);
        bt_regist=(Button)findViewById(R.id.bt_zhuce);
        realCode=Code.getInstance().getCode().toLowerCase();
        bt_regist.setOnClickListener(onclr);
        iv_code.setOnClickListener(onclr);
        //返回
       iv_banck=(ImageView)findViewById(R.id.im_back);
       iv_banck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 判断验证码
     */
    View.OnClickListener onclr=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.iv_shanCode:
                    iv_code.setImageBitmap(Code.getInstance().createBitmap());
                    realCode=Code.getInstance().getCode().toLowerCase();
                    break;
                case R.id.bt_zhuce:
                    String ed=ed_code.getText().toString().toLowerCase();
                    if(ed.equals(realCode)){
                      /*  Intent intent=new Intent(RegisterActivity.this, PersonFragment.class);
                        startActivity(intent);*/
                        Toast.makeText(RegisterActivity.this, "验证码正确", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }
    };

}
