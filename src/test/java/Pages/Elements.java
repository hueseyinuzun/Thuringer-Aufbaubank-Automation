package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements extends Parent {
    public Elements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[title='Thüringer Aufbaubank']")
    public WebElement ThuringerAufbaubankCompanyLogo;

    @FindBy(css = "a[class='icon-facebook']")
    public WebElement facebook;

    @FindBy(css = "a[class='icon-xing']")
    public WebElement xing;

    @FindBy(css = "a[class='icon-linkedin']")
    public WebElement linkedin;

    @FindBy(css = "a[class='icon-youtube']")
    public WebElement youtube;

    @FindAll({
            @FindBy(css = "div#mainmenu>ul>li>a")
            })
    public List<WebElement> menuActualList;

    @FindBy(css = "div[class='short-contact']>div>span")
    public WebElement contactButton;

    @FindBy(css = "input[name='surname']")
    public WebElement surname;

    @FindBy(css = "input[name='name']")
    public WebElement name;

    @FindBy(css = "input[name='email']")
    public WebElement email;

    @FindBy(css = "input[name='phone']")
    public WebElement phone;

    @FindBy(css = "textarea[name='text']")
    public WebElement text;

    @FindBy(css = "label[for='form-datenverarbeitung']>em")
    public WebElement datenverarbeitungCheckbox;
    @FindBy(css = "label[for='form-datenschutz']>em")
    public WebElement datenschutzCheckbox;

    public WebElement getWebElement(String elementName){

        switch (elementName){
            case "ThuringerAufbaubankCompanyLogo":return this.ThuringerAufbaubankCompanyLogo;
            case "Facebook":return this.facebook;
            case "Xing":return this.xing;
            case "Linkedin":return this.linkedin;
            case "Youtube":return this.youtube;
            case "ContactButton":return this.contactButton;
            case "surname":return this.surname;
            case "name":return this.name;
            case "email":return this.email;
            case "phone":return this.phone;
            case "text":return this.text;
            case "datenverarbeitungCheckbox":return this.datenverarbeitungCheckbox;
            case "datenschutzCheckbox":return this.datenschutzCheckbox;

        }
        return null;
    }
}
