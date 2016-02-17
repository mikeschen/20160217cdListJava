import java.util.ArrayList;

public class Cd {
  private static ArrayList<Cd> instances = new ArrayList<Cd>();
  private String mArtist;
  private int mId;

  public Cd (String artist) {
    mArtist = artist;
    instances.add(this);
    mId = instances.size();
  }

  public String getArtist() {
    return mArtist;
  }

  public int getId() {
    return mId;
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
}
