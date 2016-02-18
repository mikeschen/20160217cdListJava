import org.junit.*;
import static org.junit.Assert.*;

public class AlbumTest {

  @Rule
  public AlbumClearRule clearRule = new AlbumClearRule();

  @Test
  public void title_titleBasedonArtist_Beatles() {
    Cd testCd = new Cd("Beatles");
    Album testAlbum = new Album("Let It Be", testCd);
    assertEquals("Let It Be", testAlbum.getName());
  }

  @Test
  public void all_returnsAllAlbums_true() {
    Album testAlbum1 = new Album("Let It Be", new Cd("Beatles"));
    Album testAlbum2 = new Album("Welcome to the Jungle", new Cd("Guns n rosses"));
    assertTrue(Album.all().contains(testAlbum1));
    assertTrue(Album.all().contains(testAlbum2));
  }

  @Test
  public void find_returnsAlbumWithCorrectId() {
    Album testAlbum1 = new Album("Let It Be", new Cd("Beatles"));
    Album testAlbum2 = new Album("Welcome to the Jungle", new Cd("Guns n Rosses"));
    assertEquals(Album.find(testAlbum2.getId()), testAlbum2);
  }

  @Test
  public void find_returnsNullWhenNoInstances_null() {
    assertTrue(Album.find(1) == null);
  }

}
