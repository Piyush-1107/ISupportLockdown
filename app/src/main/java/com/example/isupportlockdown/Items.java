package com.example.isupportlockdown;

public class Items {
    private String sno;

    private String item_name;

    private String quantity;

    public Items()
    {
    }

    public void setSno(String a)
    {
        sno=a;
    }

    public void setitem(String item)
    {
        item_name=item;
    }

    public void setquan(String quan)
    {
        quantity=quan;
    }

    public String  getItem_name(){
        return item_name;
    }

    public String getQuantity(){
        return quantity;
    }


    public String getSno()
    {
        return sno;
    }
}
