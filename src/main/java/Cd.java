import java.util.ArrayList;

public class Cd {
  private static ArrayList<Cd> instances = new ArrayList<Cd>();
  private String mTitle;
  private int mId;

  public Cd (String title) {
    mTitle = title;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<Cd> all() {
    return instances;
  }
}
