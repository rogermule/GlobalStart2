package com.gcme.globalstart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.gcme.globalstart.Do.SubMenu_Do;
import com.gcme.globalstart.Goal.SubMenu_Goal;
import com.gcme.globalstart.GodHeart.SubMenu_GodHeart;
import com.gcme.globalstart.Learn.SubMenu_Learn;
import com.goka.blurredgridmenu.GridMenu;
import com.goka.blurredgridmenu.GridMenuFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity  extends AppCompatActivity {

    private GridMenuFragment mGridMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridMenuFragment = GridMenuFragment.newInstance(R.drawable.global_start);

//        findViewById(R.id.show_menu_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
//                tx.replace(R.id.main_frame, mGridMenuFragment);
//                tx.addToBackStack(null);
//                tx.commit();
//            }
//        });

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main_frame, mGridMenuFragment);
        tx.addToBackStack(null);
        tx.commit();

        setupGridMenu();

        mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
            @Override
            public void onClickMenu(GridMenu gridMenu, int position) {
//                Toast.makeText(MainActivity.this, "Title:" + gridMenu.getTitle() + ", Position:" + position,
//                        Toast.LENGTH_SHORT).show();
                chooseSubMenu(position);

            }
        });
    }

    public void chooseSubMenu(int position){
        if(position == 1){
            Intent intent = new Intent(MainActivity.this,Intro.class);
            startActivity(intent);
        }
        if(position == 2){
            Intent intent = new Intent(MainActivity.this, SubMenu_GodHeart.class);

//            String[] ids = new String[]{"1","2","3"};
//            String[] titles = new String[]{"Teenagers","Biblical Examples","Take Action"};
//            String[] desc = new String[]{"teenagers","examples","action"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }
        if(position == 3){
            Intent intent = new Intent(MainActivity.this, SubMenu_Learn.class);

//            String[] ids = new String[]{"1","2","3","4"};
//            String[] titles = new String[]{"Understand The Youth","Jesus's Model","How to Learn","Take Action"};
//            String[] desc = new String[]{"youth","model","learn","action time"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }
        if(position == 4){
            Intent intent = new Intent(MainActivity.this, SubMenu_Do.class);

//            String[] ids = new String[]{"1","2","3"};
//            String[] titles = new String[]{"Prayer","Find Others to Help","Take Action"};
//            String[] desc = new String[]{"pray","help","Action time"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }

        if(position == 5){
            Intent intent = new Intent(MainActivity.this, SubMenu_Goal.class);

//            String[] ids = new String[]{"1","2","3","4","5","6"};
//            String[] titles = new String[]{"Know the Goal","Win","Sowing & Evangelism","Build","Send","Send Movements"};
//            String[] desc = new String[]{"goal","win","sow","build","send","movements"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }

    }
    private void setupGridMenu() {
        List<GridMenu> menus = new ArrayList<>();
        menus.add(new GridMenu("News Feed", R.drawable.home));
        menus.add(new GridMenu("Intro", R.drawable.calendar));
        menus.add(new GridMenu("God's Heart", R.drawable.overview));
        menus.add(new GridMenu("Learn", R.drawable.groups));
        menus.add(new GridMenu("Do", R.drawable.lists));
        menus.add(new GridMenu("Goal", R.drawable.profile));
        menus.add(new GridMenu("Timeline", R.drawable.timeline));
        menus.add(new GridMenu("Testimony", R.drawable.settings));

        mGridMenuFragment.setupMenu(menus);
    }

    @Override
    public void onBackPressed() {
//        if (0 == getSupportFragmentManager().getBackStackEntryCount()) {
//            super.onBackPressed();
//        } else {
//            getSupportFragmentManager().popBackStack();
//        }
        super.onBackPressed();
        this.finish();

    }
}
