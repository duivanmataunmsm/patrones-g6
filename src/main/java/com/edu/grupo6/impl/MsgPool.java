
package com.edu.grupo6.impl;
//import com.edu.grupo6.com.edu.grupo6.impl.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class MsgPool {
  private static List<Mensaje> activeList;
  private List<Mensaje> reserveList;

  private int noActive;
  private int noReserved;

  private static MsgPool instance;

  //constructor
  private MsgPool(int reserve) {
    //default values
    this.activeList = new ArrayList<Mensaje>();
    this.reserveList = new ArrayList<Mensaje>();
    this.noActive = 0;
    this.noReserved = 0;
    //Initialize the reserve
    InitializeReserve(reserve);
  }

  private void InitializeReserve(int reserveSize) {
    for(int i=0; i<reserveSize; i++) {
      Mensaje msg = new Mensaje("");
      this.reserveList.add(msg);
      this.noReserved++;
    }
  }
  
  public static MsgPool getInstance(int reserve) {
    if(instance == null)
      instance = new MsgPool(reserve);
    return instance;
  }

  public Mensaje acquireReusable(String content) {
    if(this.noReserved == 0) {
      Mensaje tmp = new Mensaje("");
      this.reserveList.add(tmp);
      this.noReserved++;
    }

    Mensaje msg = this.reserveList.get(0);
    this.reserveList.remove(msg);
    this.noReserved--;

    this.activeList.add(msg);
    this.noActive++;

    msg.setContent(content);

    return msg;
  }

  public void releaseReusable(Mensaje item) {
    this.activeList.remove(item);
    this.noActive--;

    this.reserveList.add(item);
    this.noReserved++;
  }


}
