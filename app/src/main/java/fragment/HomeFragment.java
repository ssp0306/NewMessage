package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.ssp.newmessage.R;

/**
 * Created by ssp on 2019/12/19.
 */
public class HomeFragment extends Fragment{
    PopupWindow popupWindow;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_home,null);
        return v;
    }


        public  void  OnMenu(View view){
        // 获取自定义的菜单布局文件
        View ppW_view =getActivity().getLayoutInflater().inflate(R.layout.menu,null,false);
        handLogic(ppW_view);
        popupWindow=new PopupWindow(ppW_view,405,600,true);
        //设置菜单显示在按钮的下面
        popupWindow.showAsDropDown(getActivity().findViewById(R.id.bt),0,0);
        ppW_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;

                }

                return false;
            }
        });


    }

    /**
     *
     * @param contentView
     */
    private  void  handLogic(View contentView){
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(popupWindow!=null){
                    popupWindow.dismiss();

                }
                String showContent="";
                switch (view.getId()) {
                    case R.id.menu1:
                        showContent = "1";
                        break;
                    case R.id.bt_add:
                        showContent = "点击 Item菜单2";
                        break;
                    case R.id.bt_sewwp:
                        showContent = "点击 Item菜单3";
                        break;
                    case R.id.bt_money:
                        showContent = "点击 Item菜单4";
                        break;
                    case R.id.bt_help:
                        showContent = "点击 Item菜单5";
                        break;
                }
                Toast.makeText(getActivity(), showContent, Toast.LENGTH_SHORT).show();

            }
        };
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.bt_add).setOnClickListener(listener);
        contentView.findViewById(R.id.bt_help).setOnClickListener(listener);
        contentView.findViewById(R.id.bt_money).setOnClickListener(listener);
        contentView.findViewById(R.id.bt_sewwp).setOnClickListener(listener);
    }

/**
 * 实现fragment点击方法
 */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button=(Button)getActivity().findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnMenu(view);
            }
        });
    }
}
