import java.util.HashMap;

public class PathAdapter {
  // private HashMap<String, String> payload

  // public PathAdapter(HashMap<String, String> payload) {
  //   this.payload = payload
  // }

  public static HashMap<String, String> adapter(HashMap<String, String> payload) {
    HashMap<String, String> paths = new HashMap<String, String>();

    for(String i: payload.keySet()) {
      if(payload.get(i) == null) {
        paths.put(i, "chessImages/BlackKing.gif");
      } else {
        paths.put(i, payload.get(i));
      }
    }
    return paths;
  }
}