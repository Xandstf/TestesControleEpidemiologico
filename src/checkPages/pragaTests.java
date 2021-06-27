package checkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

		System.out.print("\n # Checando se os campos de Cadastro de Pragas estao habilitados ");
		checkCamposHabilitados(driver);

		System.out.println("\n # Checando o campo de tipo number ");
		checkNumberInput(driver);
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
	public void checkCamposHabilitados(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/cadastroPraga.html");
		String[] names = {"codigo", "nome", "doencas_transmitidas", "tempo_vida", "modos_combate"};
		for (String name: names) {
			System.out.println("\nNome do campo: " + name);
			if(driver.findElement(By.name(name)).isEnabled()) {
				System.out.print("[PASS]");
			} else {
				System.out.print("[REPROVED]");
			}
		}
	}

	private void checkNumberInput(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/cadastroPraga.html");

			WebElement element = driver.findElement(By.name("codigo"));
			System.out.println("\nNome do campo: codigo");
			System.out.println("\n Nao permite texto: ");
			element.sendKeys("teste");
			if(element.getAttribute("value").equals("teste")) {
				System.out.print("[REPROVED]");
			} else {
				System.out.print("[PASS]");
			}
			element.clear();
			System.out.println("\n Permite numeros: ");
			element.sendKeys("123");
			if(element.getAttribute("value").equals("123")) {
				System.out.print("[PASS]");
			} else {
				System.out.print("[REPROVED]");
			}
		}
	
}
