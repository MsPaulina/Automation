package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Generators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;


public class SignUpPage extends BasePage {

    @FindBy(id = "id_gender2")
    private WebElement titleRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement dayDateOfBirthDropdown;

    @FindBy(id = "months")
    private WebElement monthOfBirthDropdown;

    @FindBy(id = "years")
    private WebElement yearOfBirthDropdown;

    @FindBy(id = "optin")
    private WebElement receiveOffersCheckBox;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement stateDropdown;

    @FindBy(id = "postcode")
    private WebElement zipCode;

    @FindBy(id = "id_country")
    private WebElement countryDropdown;

    @FindBy(id = "other")
    private WebElement additionalTextBox;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement additionalEmailAlias;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage selectTitle() {
//        TODO DODAC W PARAMETRACH POZNIEJ ZEBY ROBILO DLA PANI I PANA
        titleRadioButton.click();
        titleRadioButton.isSelected();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    public SignUpPage enterFirstName() {
        firstName.clear();
        firstName.sendKeys(Generators.getAlphaString(7));
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    public SignUpPage enterLastName() {
        lastName.clear();
        lastName.sendKeys(Generators.getAlphaString(9));
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    public SignUpPage createPassword() {
        password.clear();
        password.sendKeys(Generators.randomAlphaNumeric(10));
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    public SignUpPage selectDateOfBirth(int date, int month, int year) {
        Select dropdownDateOfBirth = new Select(dayDateOfBirthDropdown);
        Select dropdownMonthOfBirth = new Select(monthOfBirthDropdown);
        Select dropdownYearOfBirth = new Select(yearOfBirthDropdown);
        dropdownDateOfBirth.selectByValue(String.valueOf(date));
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        dropdownMonthOfBirth.selectByValue(String.valueOf(month));
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        dropdownYearOfBirth.selectByValue(String.valueOf(year));
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    public SignUpPage setReceiveOffers(String yesOrNo) {
        if (yesOrNo.equalsIgnoreCase("YES")) {
            if (!receiveOffersCheckBox.isSelected()) {
                receiveOffersCheckBox.click();
                System.out.println("Checkbox selected");
            }
        } else {
            System.out.println("Checkbox not selected");
        }
        return this;
    }

    public SignUpPage enterAddress() {
        address.clear();
        address.sendKeys(Generators.getAlphaString(8) +
                " St " +
                Generators.randomIntegerGenerator(20));
        return this;
    }
//    hehehe
    public SignUpPage enterCity(String parameterCity) {
        city.clear();
        city.sendKeys(parameterCity);
        return this;
    }

    public SignUpPage selectState(String enteredStateName) {
        Select selectStateDropdown = new Select(stateDropdown);
        List<WebElement> allOptions = selectStateDropdown.getOptions();

        boolean found = false;
        for (WebElement model : allOptions) {
//            System.out.println(model.getText());
            if (model.getText().equals(enteredStateName)) {
                found = true;
                break;
            }
        }

        if (found) {
            selectStateDropdown.selectByVisibleText(enteredStateName);
            System.out.println("State: " + enteredStateName + " exists");
        } else {
            System.out.println("Error, state: " + enteredStateName + " doesn't exist in the dropdown");
        }
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //validation
        assertTrue(found);
        return this;
    }

    public SignUpPage enterPostalCode(String enteredPostcode) {

        String regex = "[0-9]{5}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(enteredPostcode);

        if (matcher.matches()) {
            System.out.println("Zipcode: " + enteredPostcode + " exists");
        } else {
            System.out.println("Error, zipcode: " + enteredPostcode + " is not correct US postal code format");
        }

        Assert.assertTrue(matcher.matches());

        zipCode.clear();
        zipCode.sendKeys(enteredPostcode);
        return this;
    }

    public SignUpPage selectCountry(String enteredCountryName) {
        Select selectCountryDropdown = new Select(countryDropdown);

        List<WebElement> allOptionsCountries = selectCountryDropdown.getOptions();

        boolean found = false;
        for (WebElement model : allOptionsCountries) {
            if (model.getText().equals(enteredCountryName)) {
                found = true;
                break;
            }
        }

        if (found) {
            selectCountryDropdown.selectByVisibleText(enteredCountryName);
            System.out.println("Country: " + enteredCountryName + " exists");
        } else {
            System.out.println("Error, Country: " + enteredCountryName + " doesn't exist in the dropdown");
        }
        assertTrue(found);
        return this;
    }

    public SignUpPage enterAdditionalInformation() {

        List<String> additionalInfolist = new ArrayList<>();
        additionalInfolist.add("Jsdfsdf");
        additionalInfolist.add(" sdfdsfdsdsds");
        additionalInfolist.add(" sdfdsfdsfdsf");

        additionalTextBox.clear();
        String additionalInfInputText = String.join(" ", additionalInfolist);

        additionalTextBox.sendKeys(additionalInfInputText);

//        additionalTextBox.sendKeys(new StringBuilder()
//                .append(additionalInfolist.get(0))
//                .append(additionalInfolist.get(1))
//                .append(additionalInfolist.get(2)));

        return this;
    }

    public SignUpPage enterMobilePhoneNo() {

        mobilePhone.clear();
//         fixed length random number of 10 digits
        String number = String.valueOf(((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L));
        mobilePhone.sendKeys(number);
//        mobilePhone.sendKeys(new StringBuilder()
        return this;

    }

    public SignUpPage enterAliasEmail() {
        additionalEmailAlias.clear();
        additionalEmailAlias.sendKeys("jakisemail" +
                Generators.randomIntegerGenerator(10000) + "@dfsdfd.asdas");
        return this;
    }

    public RegistrationConfirmation clickRegister() {
        registerButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new RegistrationConfirmation(driver);
    }

}


// I SPOSOB
    /*public SignUpPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public SignUpPage enterPassword(String passw) {
        passInput.clear();
        passInput.sendKeys(passw);
        return this;
    }

    public SignUpPage clickSignInButton() {
        signInBtn.click();
        return this;
    }*/


/*2 sposob*/

   /* public void enterEmail1(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword1(String passw) {
        passInput.clear();
        passInput.sendKeys(passw);
    }

    public void clickSignInButton1() {
        signInBtn.click();
    }


    public String getEmailValue() {
        return emailInput.getAttribute("value");
    }*/
//    public SignInPage signIn(String email, String pass) {
//        emailInput.clear();
//        emailInput.sendKeys(email);
//        return
//
//        passInput.clear();
//        passInput.sendKeys(pass);
//        //        return
//        signInBtn.click();
//        return this;
//    }

//    to bylo dobrze
    /*    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;*/

