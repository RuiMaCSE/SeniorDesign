package com.rent_it_app.rent_it;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;//test
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.rent_it_app.rent_it.activity.FragmentDrawer;
import com.rent_it_app.rent_it.activity.FriendsFragment;
import com.rent_it_app.rent_it.activity.HomeFragment;
import com.rent_it_app.rent_it.activity.MessagesFragment;



public class MainActivity extends BaseActivity
        implements FragmentDrawer.FragmentDrawerListener{

    private TextView myStatusText;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button mSignOutButton;

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String userId;
    private static final String TAG = "Main";

    //text
//声明ListView控件
    private ListView listView;
    //创建简单适配器(并不简单,功能很强大)
    private SimpleAdapter simpleAdapter;
    //定义List泛型集合,里面存放的是Map键值对, listDate作为ListView的数据源
    private List<Map<String, Object>> listDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * requestWindowFeature(Window.FEATURE_NO_TITLE);
         * 这段代码的目的是为了去除Activity的头部,在myEclipse里面设置有效,
         * 但在Android Studio无效
         *
         * 而且在AndroidManifest.xml 修改这段代码程序会崩溃,可见Android Studio也有
         * 美中不足的地方,相信会有其他的解决办法,此时此处暂且搁置
         * android:theme="@android:style/Theme.NoTitleBar"
         * Android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
         */
        setContentView(R.layout.activity_main);
        //得到ListView控件
        //listView = (ListView) findViewById(R.id.listView);

        /*
         * 把ListView要显示的图片和文字声明出来,暂时存放在数组中,为插入到listDate做准备
         * 三个数组对应三个不同的显示信息,ListView每一个Item会根据你自定义的
         * 布局样式依次显示img[1],text1[1],text2[1]的内容
         * 其实我们还差一个,就是最右边的播放图标,由于每一个item的图标都是相同的,
         * 我们直接添加到集合中即可
         */
        int[] img = new int[]{R.drawable.ic_profile, R.drawable.ic_profile, R.drawable.ic_profile, R.drawable.ic_profile, R.drawable.ic_profile, R.drawable.ic_profile, R.drawable.ic_profile};
        //图片右边的第一排文字
        String[] text1 = new String[]{"Ben78", "emily4", "kyoto7", "gigi7", "holistic5"};
        //图片右边的第二排文字
        String[] text2 = new String[]{"for Tent1", "for Tent1", "for Tent1", "for Tent1", "for Tent1"};

        /*
         * 实例化泛型集合listDate
         * 使用MyEclipse开发的朋友,你的实例化代码应该是这样的
         * listDate = new ArrayList<Map<String,Object>>();
         *
         * 但请注意:对于Android Studio来说这样写,你的代码底下会有烦人的波浪线,
         * 为什么会这样,有一种说法是:
         * 因为Android Studio需要的JDK版本是7.0及以上,这种JDK版本不支持此种写法
         */

        myStatusText = (TextView)findViewById(R.id.greetingMessage);
        mSignOutButton = (Button) findViewById(R.id.sign_out_button);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        // display the first navigation drawer view on app launch
        displayView(0);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userId = user.getUid().toString();
        Log.e(TAG, "Imy user id is " + userId);


        mFirebaseInstance = FirebaseDatabase.getInstance();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("Users");
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                // Check for null
                if (user == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                myStatusText.setText("Hello " + user.displayname);
                Log.e(TAG, "your display name is " + user.displayname);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });

    }

    public void logOut(View view) {
        mAuth.signOut();
        Toast.makeText(MainActivity.this, "Successfully signed out", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, SignInActivity.class);
        //if you want to pass parameter
        //intent.putExtra("EXTRA_SESSION_ID", sessionId);
        startActivity(intent);
        /*Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);

        snackbar.show();*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }
    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new FriendsFragment();
                title = getString(R.string.title_friends);
                break;
            case 2:
                fragment = new MessagesFragment();
                title = getString(R.string.title_messages);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

}
