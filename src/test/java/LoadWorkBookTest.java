import com.garrett.Workbook.LoadWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class LoadWorkBookTest {
   private String path;
   private LoadWorkbook wb;
/*
    @Test (expected = IOException.class)
       public void testIOException(){
            wb = new LoadWorkbook(null);
        }

*/
   @Test (expected = FileNotFoundException.class)
    public void testFileNotExist() {
       wb = new LoadWorkbook("C:\\Users\\Jara\\Desktop\\test\\test.xls");
    }
}
