package com.namy86.dtu_saforum;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main2Activity extends AppCompatActivity {

   private BottomBar bottom;
    private RecyclerView mBloglist;
    FirebaseDatabase database;
    DatabaseReference mReference;
    DrawerLayout mDrawer;
    ActionBarDrawerToggle myToggle;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(myToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mDrawer=(DrawerLayout) findViewById(R.id.drawer);
        myToggle=new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);

        mDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       bottom=(BottomBar) findViewById(R.id.bottomNavigationMenu);
       bottom.setOnTabSelectListener(new OnTabSelectListener() {
    @Override
    public void onTabSelected(int tabId) {


        if(tabId==R.id.second){

        }
        if(tabId==R.id.third){

        }
        if(tabId==R.id.forth){

        } if(tabId==R.id.fifth){

        }
    }
});





        mBloglist = findViewById(R.id.blog);
        mBloglist.setHasFixedSize(true);
        mBloglist.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        mReference = database.getReference();



    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelClass, BlogViewHolder> firebaseRecyclerAdapter = new
                FirebaseRecyclerAdapter<ModelClass, BlogViewHolder>(ModelClass.class, R.layout.new_design, BlogViewHolder.class, mReference) {

                    @Override
                    protected void populateViewHolder(BlogViewHolder viewHolder, ModelClass model, int position) {


                        viewHolder.setTitle(model.getTitle());
                        viewHolder.setDesc(model.getDesc());
                        viewHolder.setImage(getApplicationContext(), model.getImage());





                    }

                };
        mBloglist.setAdapter(firebaseRecyclerAdapter);


    }


    public static class BlogViewHolder extends RecyclerView.ViewHolder {

        View mView;
        String title2,desc2,image2;
        Context ctx2;
        public BlogViewHolder(View itemView, final ModelClass modelClass) {

            super(itemView);
            mView = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
////                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dtu.ac.in/Web/notice/2017/dec/file1219.pdf"));
////
////                    Intent browserChooserIntent = Intent.createChooser(browserIntent, "Choose Browser Of Your Choice");
////                    view.getContext().startActivity(browserChooserIntent);
//
//
//                     String b=Set();

                    TextView post2 = mView.findViewById(R.id.titletext11);
                    post2.setText(modelClass.getTitle());



//
//
////
////
////
////
////
////
////
////
//                }
//            });
//        }
//
//
////        public void setFile(final String file) {
////            postImage.setOnClickListener(new View.OnClickListener() {
////                String a=file;
////                @Override
////                public void onClick(View view) {
////                    dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
////                    Uri uri = Uri.parse(a);
////                    DownloadManager.Request request = new DownloadManager.Request(uri);
////                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
////
////                    Long reference = dm.enqueue(request);
                }
            });
        }


        public void setTitle(String title) {

            TextView post = mView.findViewById(R.id.titletext1);
            post.setText(title);





        }


        public void setDesc(String desc) {

            TextView description = mView.findViewById(R.id.titletext2);
            description.setText(desc);


        }

        public void setImage( Context ctx,  String image) {

            CircleImageView postImage = (CircleImageView) mView.findViewById(R.id.images);
            Picasso.with(ctx).load(image).into(postImage);






        }


    }

}