package checkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class localTests {

	public void runTests(WebDriver driver) {
		System.out.println("\n\n## ## | Iniciando testes de Local | ## ##");
		
		System.out.print("\n # Verificando abertura da página ");
		openPageHome(driver);
		
		System.out.print("\n # Abrir adição de local ");
		openCadastro(driver);
		
		System.out.print("\n # Abrir alteração de local ");
		openAlterar(driver);
		
		System.out.print("\n # Abrir exclusão de local ");
		openExcluir(driver);
		
		System.out.print("\n # Abrir listagem de um local ");
		openPraga(driver);
		
		System.out.print("\n # Abrir listagem de locais ");
		openPragas(driver);
	}
	
	public void openPageHome(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		if(driver.findElements(By.xpath("//*[contains(text(),'DASHBOARD LOCAL')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
	}
	
	public void openCadastro(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		driver.findElement(By.partialLinkText("ADICIONAR LOCAL")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'CADASTRAR LOCAL')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openAlterar(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		driver.findElement(By.partialLinkText("ALTERAR LOCAL")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Alterar')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openExcluir(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		driver.findElement(By.partialLinkText("EXCLUIR LOCAL")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Excluir')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openPraga(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		driver.findElement(By.partialLinkText("LISTAR UM LOCAL")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Selecione o local que gostaria de ver:')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openPragas(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		driver.findElement(By.partialLinkText("LISTAR LOCAIS")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Características')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
}
