package com.example.wbxu.mygreendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.wbxu.mygreendaodemo.DbManager.FruitDaoUtil;
import com.example.wbxu.mygreendaodemo.DbManager.MigrationHelper2;
import com.example.wbxu.mygreendaodemo.DbManager.MySQLiteOpenHelper;
import com.example.wbxu.mygreendaodemo.bean.Fruit;
import com.example.wbxu.mygreendaodemo.gen.DaoMaster;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[] buttons = new Button[10];
    private int[] buttonID = {R.id.insertsingle, R.id.multinsert, R.id.refresh, R.id.update, R.id.deletesingle, R.id.deleteMult, R.id.checksingle,
            R.id.checkmult, R.id.querybuilder,R.id.upDataDB};
    private FruitDaoUtil mFruitDaoUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDaoUtils();
    }
    public  void  initView(){
        for (int i = 0; i < buttonID.length; i++) {
            buttons[i] = (Button) findViewById(buttonID[i]);
            buttons[i].setOnClickListener(this);
        }
    }
    public void initDaoUtils(){
        mFruitDaoUtil=new FruitDaoUtil(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insertsingle:  //插入单个的
                mFruitDaoUtil.insertFruit(new Fruit(1L,"苹果1",1));
                break;
            case R.id.multinsert:  //插入多个的
                List<Fruit> list=new ArrayList<Fruit>();
                for (int i = 0; i < 10; i++) {
                    list.add(new Fruit(Long.parseLong(i+""),"桃子"+i,i));
                }
                mFruitDaoUtil.insertListFruit(list);
                break;
            case R.id.refresh:  //刷新单个的
                mFruitDaoUtil.reFreshFruit(new Fruit(1L,"苹果1",10));
                break;
            case R.id.update:  //更新单个的
                mFruitDaoUtil.reFreshFruit(new Fruit(1L,"苹果1",20));
                break;
            case R.id.deletesingle:  //删除单个的
                mFruitDaoUtil.deleteFruit(new Fruit(4L,"苹果1",20));
                break;
            case R.id.deleteMult:  //删除全部
                mFruitDaoUtil.deleteAll();
                break;
            case R.id.checksingle:  //按主键查询一个
              Fruit f=  mFruitDaoUtil.queryFruitById(1L);
                Log.d("flag","---------按条件查询的结果为"+f.getName()+"-----"+f.getId());
                break;
            case R.id.checkmult:  //按条件查询
              List<Fruit> l=  mFruitDaoUtil.queryFruitBySql("Name,Count",new String[]{"苹果1","1"});
                for (int i = 0; i <l.size(); i++) {
                    Log.d("flag","---------按条件查询的结果为"+l.get(i).getName()+"-----"+l.get(i).getId());
                }
                break;
            case R.id.querybuilder:  //querybuilder查询
                List<Fruit> List  =mFruitDaoUtil.queryFruitByQueryBuilder(1L);
                for (int i = 0; i <List.size(); i++) {
                    Log.d("flag","---------按条件查询的结果为"+List.get(i).getName()+"-----"+List.get(i).getId());
                }
                break;
            case R.id.upDataDB:
                MySQLiteOpenHelper o=new MySQLiteOpenHelper(this,"MyGreenDb.db",null);
                DaoMaster daoMaster = new DaoMaster(o.getWritableDatabase());
//                ss
                break;
        }
    }
}
