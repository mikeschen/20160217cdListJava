import java.util.ArrayList;

public class Album {
  private static ArrayList<Album> instances = new ArrayList<Album>();

  private final String mName;
  private final Cd mArtist;
  private final int mId;

  public Album (String name, Cd cd) {
    mName = name;
    mArtist = cd;
    instances.add(this);
    mId = instances.size();
  }

  public static ArrayList<Album> all() {
    return instances;
  }

  public static Album find(int id) {
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

  public Cd getArtist() {
    return mArtist;
  }
}
