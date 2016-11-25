package base.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by optaros on 7/25/14.
 */
public class Table extends WebPage {

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	private String template;

    /*
    * Table recieves a string pattern for a css selector
    * using this it will construct the selector and retrieve content
    */
    public Table(WebDriver driver) {
		super(driver);
    }

    private By getBy(int row, int col){
        String formated = String.format(template, row, col);
        By selector = By.cssSelector(formated);
        return selector;
    }

    private boolean cellExists(int row, int col){
        try{
            driver.findElement(getBy(row, col));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public WebElement getCell(int row, int col){
        log.info("geting cell with row/col" +row+"-"+col);
        if(cellExists(row, col)){
        return driver.findElement(getBy(row, col));}
        throw new RuntimeException(String.format( "Did not find cell at row %s and col %s", row, col));
    }

    public List<WebElement> getRow(int row){
        log.info(String.format("geting row %s", row));
        int col = 1;
        List<WebElement> cells = new ArrayList<WebElement>();
        while (cellExists(row, col)){
            cells.add(getCell(row, col));
            col++;
        }

        return cells;
    }

    public List<WebElement> getColumn(int col){
        log.info(String.format("geting column %s", col));
        int row = 1;
        List<WebElement> cells = new ArrayList<WebElement>();
        while (cellExists(row, col)){
            cells.add(getCell(row, col));
            row++;
        }
        return cells;
    }

    public int getRowIndex(int col, String lookup){
        List<WebElement> cells = getColumn(col);
        for (int i = 0; i < cells.size(); i++) {
             String current = cells.get(i).getText().trim();
            if(current.equalsIgnoreCase(lookup)){
                return i+1;
            }
        }
        return -1;
    }

    public int getColIndex(int row, String lookup){
        List<WebElement> cells = getRow(row);
        for (int i = 0; i < cells.size(); i++) {
            String current = cells.get(i).getText().trim();
            if(current.equalsIgnoreCase(lookup)){
                return i+1;
            }
        }
        return -1;
    }

}
