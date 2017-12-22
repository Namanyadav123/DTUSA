package com.namy86.dtu_saforum;

import android.content.Context;
import android.view.Display;

/**
 * Created by namy on 12/12/17.
 */

public class ModelClass {


    String title,image,desc;
    Context ctx;


    public ModelClass(String title,String image,String desc,String file)
    {


        this.image=image;
        this.title=title;
        this.desc=desc;

    }

    public ModelClass() {

     }

    public String getTitle(){
        return title;
    }

    public String getImage(){
        return image;
    }

    public String getDesc(){
        return desc;
    }




    public void setTitle(String title){
        this.title=title;
    }

    public void setImage(Context ctx,String image){
        this.ctx=ctx;
        this.image=image;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }

}
