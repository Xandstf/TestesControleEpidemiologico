package checkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pragaTests {

	public void runTests(WebDriver driver) {
		System.out.println("\n\n## ## | Iniciando testes de Praga | ## ##");
		
		System.out.print("\n # Verificando abertura da página ");
		openPageHome(driver);
		
		System.out.print("\n # Abrir adição de praga ");
		openCadastro(driver);
		
		System.out.print("\n # Abrir alteração de praga ");
		openAlterar(driver);
		
		System.out.print("\n # Abrir exclusão de praga ");
		openExcluir(driver);
		
		System.out.print("\n # Abrir listagem de uma praga ");
		openPraga(driver);
		
		System.out.print("\n # Abrir listagem de pragas ");
		openPragas(driver);
	}
	
	public void openPageHome(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/praga/dashPraga.html");
		if(driver.findElements(By.xpath("//*[contains(text(),'DASHBOARD PRAGA')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
	}
	
	public void openCadastro(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/praga/dashPraga.html");
		driver.findElement(By.partialLinkText("ADICIONAR PRAGA")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'CADASTRAR PRAGA')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openAlterar(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/praga/dashPraga.html");
		driver.findElement(By.partialLinkText("ALTERAR PRAGA")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Alterar')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openExcluir(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/praga/dashPraga.html");
		driver.findElement(By.partialLinkText("EXCLUIR PRAGA")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Excluir')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openPraga(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/praga/dashPraga.html");
		driver.findElement(By.partialLinkText("LISTAR UMA PRAGA")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Selecione a praga que gostaria de ver:')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openPragas(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/praga/dashPraga.html");
		driver.findElement(By.partialLinkText("LISTAR PRAGAS")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Modos de combate')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	
}
