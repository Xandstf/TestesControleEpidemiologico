package checkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.List;

public class localTests {

	public void runTests(WebDriver driver) {
		System.out.println("\n\n## ## | Iniciando testes de Local | ## ##");
		
		System.out.print("\n # Verificando abertura da pagina ");
		openPageHome(driver);
		
		System.out.print("\n # Abrir adicao de local ");
		openCadastro(driver);
		
		System.out.print("\n # Abrir alteracao de local ");
		openAlterar(driver);
		
		System.out.print("\n # Abrir exclusao de local ");
		openExcluir(driver);
		
		System.out.print("\n # Abrir listagem de um local ");
		openLocal(driver);
		
		System.out.print("\n # Abrir listagem de locais ");
		openLocais(driver);

		System.out.print("\n # Checando se os campos de Cadastro de Locais estao habilitados ");
		checkCamposHabilitados(driver);

		System.out.print("\n # Checando os campos de tipo number ");
		checkNumberInput(driver);
		
		System.out.print("\n # Checando avanço, retorno e atualização da página ");
		checkNavegation(driver);
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
	
	public void openLocal(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		driver.findElement(By.partialLinkText("LISTAR UM LOCAL")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Selecione o local que gostaria de ver:')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
		
	}
	
	public void openLocais(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/dashLocal.html");
		driver.findElement(By.partialLinkText("LISTAR LOCAIS")).click();
		if(driver.findElements(By.xpath("//*[contains(text(),'Raio')]")).size() > 0) {
			System.out.print("[PASS]");
		}else {
			System.out.print("[REPROVED]");
		}
	}

	public void checkCamposHabilitados(WebDriver driver) {
		driver.get("http://localhost/PaginaControleEpidemiologico/local/cadastroLocal.html");
		String[] names = {"cep_ponto_central", "raio", "populacao", "caracteristicas"};
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
		driver.get("http://localhost/PaginaControleEpidemiologico/local/cadastroLocal.html");
		String[] names = {"cep_ponto_central", "raio", "populacao"};
		for (String name: names) {
			WebElement element = driver.findElement(By.name(name));
			System.out.println("\nNome do campo: " + name);
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
	
	public void checkNavegation(WebDriver driver) {
		int testes = 0;
		driver.get("http://localhost/PaginaControleEpidemiologico/index.html");
        driver.findElement(By.partialLinkText("LOCAL")).click();
        driver.navigate().back();
        if (driver.getTitle().compareTo("Home - ControleEpidemiologico") == 0) {
        	testes++;
        } 
        driver.navigate().forward();
        if (driver.findElements(By.xpath("//*[contains(text(),'DASHBOARD LOCAL')]")).size() > 0) {
        	testes++;
        }
        driver.navigate().refresh();
        if (driver.findElements(By.xpath("//*[contains(text(),'DASHBOARD LOCAL')]")).size() > 0) {
        	testes++;
        }
        if(testes == 3) {
			System.out.print("[PASS]");
		} else {
			System.out.print("[REPROVED]");
		}
	}
	
}
