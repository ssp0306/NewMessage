package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssp.newmessage.R;
import com.example.ssp.newmessage.RegisterActivity;

/**
 * Created by ssp on 2019/12/19.
 */
public class PersonFragment extends Fragment{
    Button bt_login;
    ImageView bt_qq,bt_weixin,bt_weibo;
    TextView iv_register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_person,null);
        return v;
    }
    /**
     * 实现fragment点击方法
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bt_login=(Button)getActivity().findViewById(R.id.bt_login);
        bt_qq=(ImageView)getActivity().findViewById(R.id.iv_qq_login);
        bt_weixin=(ImageView)getActivity().findViewById(R.id.iv_weixin_login);
        bt_weibo=(ImageView)getActivity().findViewById(R.id.iv_sina_login);
        iv_register=(TextView)getActivity().findViewById(R.id.iv_register);
        bt_login.setOnClickListener(oClicker);
        bt_qq.setOnClickListener(oClicker);
        bt_weixin.setOnClickListener(oClicker);
        bt_weibo.setOnClickListener(oClicker);
        iv_register.setOnClickListener(oClicker);
    }

    /**
     * 实现方法
     */
    View.OnClickListener oClicker=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (view.getId()){
                    case R.id.bt_login:
                       Toast.makeText(getActivity(), "登录", Toast.LENGTH_SHORT).show() ;
                        break;
                    case R.id.iv_qq_login:
                        Toast.makeText(getActivity(), "qq登录", Toast.LENGTH_SHORT).show() ;
                        break;
                    case R.id.iv_weixin_login:
                        Toast.makeText(getActivity(), "微信登录", Toast.LENGTH_SHORT).show() ;
                        break;
                    case R.id.iv_sina_login:
                        Toast.makeText(getActivity(), "微博登录", Toast.LENGTH_SHORT).show() ;
                        break;
                    case R.id.iv_register:
                        Intent intent=new Intent(getActivity().getApplicationContext(), RegisterActivity.class);
                        startActivity(intent);

                }
        }
    };
}
