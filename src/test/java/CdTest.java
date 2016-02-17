import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CdTest {

  @Test
  public void newCd_instatiateCorrectly_true() {
    Cd testCd = new Cd("Beatles");
    assertEquals(true, testCd instanceof Cd);
  }

  @Test
  public void newCd_displayAartist() {
  Cd testCd = new Cd("Beatles");
  assertEquals("Beatles", testCd.getArtist());
  }

  @Test
  public void all_returnsAllInstancesOfCd_true() {
    Cd firstCd = new Cd("Beatles");
    Cd secondCd = new Cd("Guns N Roses");
    assertTrue(Cd.all().contains(firstCd));
    assertTrue(Cd.all().contains(secondCd));
  }
  @Test
   public void newId_cdsInstantiateWithAnID_true() {
     Cd testCd = new Cd("Beatles");
     assertEquals(Cd.all().size(), testCd.getId());
   }

   @Test
   public void find_returnsCdkWithSameId_secondCd() {
     Cd firstCd = new Cd("Beatles");
     Cd secondCd= new Cd("Guns N Roses");
     assertEquals(Cd.find(secondCd.getId()), secondCd);
   }

   @Test
   public void find_returnsNullWhenNoCdFound_null() {
     assertTrue(Cd.find(999)== null);
   }
}
