package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import constants.FrameworkConstants;
public class ScreenshotUtils {

    public static byte[] captureScreenshot(WebDriver driver, String scenario_Name) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            File DFile = new File(FrameworkConstants.SCREENSHOT + scenario_Name + "_" + timeStamp + ".png");

            DFile.getParentFile().mkdirs();
            Files.copy(src.toPath(), DFile.toPath());

            return screenshot;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}