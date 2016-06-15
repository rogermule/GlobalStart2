package com.gcme.globalstart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
                Toast.makeText(MainActivity.this, "Title:" + gridMenu.getTitle() + ", Position:" + position,
                        Toast.LENGTH_SHORT).show();
                if(position == 1){
                    Intent intent = new Intent(MainActivity.this,Intro.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(MainActivity.this, SubMenu.class);
//                    ArrayList<SubMenuItem> menuItems = new ArrayList<SubMenuItem>();
//                    SubMenuItem menuItem1 = new SubMenuItem();
//                    menuItem1.setId("1");
//                    menuItem1.setTitle("Teenagers");
//                    menuItem1.setDesc("asdgasdg");
//
//                    SubMenuItem menuItem2 = new SubMenuItem();
//                    menuItem2.setId("1");
//                    menuItem2.setTitle("Teenagers");
//                    menuItem2.setDesc("asdgasdg");
//
//                    menuItems.add(menuItem1);
//                    menuItems.add(menuItem2);

                    String[] ids = new String[]{"1","2"};
                    String[] titles = new String[]{"Teenagers","Biblical Examples"};
                    String[] desc = new String[]{"dasdg","adsg asdga"};

                    Bundle b = new Bundle();
                    b.putStringArray("ids",ids);
                    b.putStringArray("titles",titles);
                    b.putStringArray("descs",desc);

                    intent.putExtras(b);

                    startActivity(intent);
                }

            }
        });
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
