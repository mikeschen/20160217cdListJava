import java.util.ArrayList;

public class Cd {
  private static ArrayList<Cd> instances = new ArrayList<Cd>();

  private final String mName;
  private int mId;

  public Cd (String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
  }

  public static ArrayList<Cd> all() {
    return instances;
  }

  public static Cd find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

    public String getName() {
      return mName;
    }

    public int getId() {
      return mId;
    }

}
