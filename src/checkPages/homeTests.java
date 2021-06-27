package checkPages;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homeTests {

    public void runTests(WebDriver driver) {
        System.out.println("## ## | Iniciando testes na Home | ## ##");

        System.out.print("\n # Verificando abertura da página ");
        openPageHome(driver);

        System.out.print("\n # Tentando abrir dashboard de Pragas ");
        openDashPraga(driver);

        System.out.print("\n # Tentando abrir dashboard de Locais ");
        openDashLocal(driver);

        System.out.print("\n # Verificando copyright ");
        checkCopyrightYear(driver);

    }

    public void openPageHome(WebDriver driver) {
        driver.get("http://localhost/PaginaControleEpidemiologico/index.html");
        if (driver.getTitle().compareTo("Home - ControleEpidemiologico") == 0) {
            System.out.print("[PASS]");
        } else {
            System.out.print("[REPROVED]");
        }

    }

    public void openDashPraga(WebDriver driver) {
        driver.get("http://localhost/PaginaControleEpidemiologico/index.html");
        driver.findElement(By.partialLinkText("PRAGA")).click();
        if (driver.findElements(By.xpath("//*[contains(text(),'DASHBOARD PRAGA')]")).size() > 0) {
            System.out.print("[PASS]");
        } else {
            System.out.print("[REPROVED]");
        }

    }

    public void openDashLocal(WebDriver driver) {
        driver.get("http://localhost/PaginaControleEpidemiologico/index.html");
        driver.findElement(By.partialLinkText("LOCAL")).click();
        if (driver.findElements(By.xpath("//*[contains(text(),'DASHBOARD LOCAL')]")).size() > 0) {
            System.out.print("[PASS]");
        } else {
            System.out.print("[REPROVED]");
        }

    }

    public void checkCopyrightYear(WebDriver driver) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        driver.get("http://localhost/PaginaControleEpidemiologico/index.html");
        if (driver.findElements(By.xpath("//*[contains(text(),'ControleEpidemiologico " + year + "')]")).size() > 0) {
            System.out.print("[PASS]");
        } else {
            System.out.print("[REPROVED]");
        }

    }

}
