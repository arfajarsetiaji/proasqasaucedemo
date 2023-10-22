package constants;

public class SharedString {
    public static String baseUrl = "https://www.saucedemo.com/";
    public static String productUrl = baseUrl + "inventory.html";
    public static String socialTwitterUrl = "https://twitter.com/saucelabs";
    public static String socialFacebookUrl = "https://www.facebook.com/saucelabs";
    public static String socialLinkedinUrl = "https://www.linkedin.com/company/sauce-labs/";

    public static String dataTestAttributePrefix = "[data-test='";
    public static String dataTestAttributeSuffix = "']";

    public static String addToCartDataTestPrefix = "add-to-cart-";
    public static String removeFromCartDataTestPrefix = "remove-";

    public static String appLogoText = "Swag Labs";

    public static String inventoryPageTitleText = "Products";


    public static String loginStatusSuccess = "success";
    public static String loginStatusLockedOut = "locked_out";
    public static String loginStatusFailed = "failed";


    public static String loginErrorAlertText = "Epic sadface: Username and password do not match any user in this service";
    public static String loginLockedOutAlertText = "Epic sadface: Sorry, this user has been locked out.";

    public static String standardUserUsername = "standard_user";
    public static String standardUserPassword = "secret_sauce";
}
