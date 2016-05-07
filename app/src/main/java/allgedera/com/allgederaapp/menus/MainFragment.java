package allgedera.com.allgederaapp.menus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

import allgedera.com.allgederaapp.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private View view;
    private ContextMenuDialogFragment mMenuDialogFragment;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initToolbar();
        initMenuFragment();
        return view;
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView mToolBarTextView = (TextView) view.findViewById(R.id.text_view_toolbar_title);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationIcon(R.drawable.btn_back);
        /*mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/
        mToolBarTextView.setText( "ברוך הבא " + MainActivity.user);
    }

    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(View clickedView, int position) {
                //Toast.makeText(getActivity(), "Clicked on position: " + position, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        MainActivity.loggedIn = false;
                        MainActivity.user = "";
                        MainActivity.goToLogin();
                        break;
                }
            }
        });
        mMenuDialogFragment.setItemLongClickListener(new OnMenuItemLongClickListener() {
            @Override
            public void onMenuItemLongClick(View clickedView, int position) {
                //Toast.makeText(getActivity(), "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        MainActivity.loggedIn = false;
                        MainActivity.user = "";
                        MainActivity.goToLogin();
                        break;
                }
            }
        });
    }

    private List<MenuObject> getMenuObjects() {
        // You can use any [resource, bitmap, drawable, color] as image:
        // item.setResource(...)
        // item.setBitmap(...)
        // item.setDrawable(...)
        // item.setColor(...)
        // You can set image ScaleType:
        // item.setScaleType(ScaleType.FIT_XY)
        // You can use any [resource, drawable, color] as background:
        // item.setBgResource(...)
        // item.setBgDrawable(...)
        // item.setBgColor(...)
        // You can use any [color] as text color:
        // item.setTextColor(...)
        // You can set any [color] as divider color:
        // item.setDividerColor(...)

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject fb = new MenuObject("שתף ב - Facebook");
        fb.setResource(R.drawable.icon_facebook);

        MenuObject twitter = new MenuObject("שתף ב - Twitter");
        twitter.setResource(R.drawable.icon_twitter);

        MenuObject linkedIn = new MenuObject("שתף ב - LinkedIn");
        linkedIn.setResource(R.drawable.icon_linkedin);

        MenuObject wa = new MenuObject("שתף ב - WhatsApp");
        wa.setResource(R.drawable.icon_whatsapp);

        MenuObject gp = new MenuObject("שתף ב - +Google Plus");
        gp.setResource(R.drawable.icon_googleplus);

        MenuObject logout = new MenuObject("התנתק");
        logout.setResource(R.drawable.btn_logout);

        menuObjects.add(close);
        menuObjects.add(fb);
        menuObjects.add(twitter);
        menuObjects.add(linkedIn);
        menuObjects.add(wa);
        menuObjects.add(gp);
        menuObjects.add(logout);
        return menuObjects;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (MainActivity.mFragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(MainActivity.mFragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
