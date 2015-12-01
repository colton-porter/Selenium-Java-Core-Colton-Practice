package com.orasi.core.by.angular.internal;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orasi.core.Beta;

/*
 * Original Code from https://github.com/paul-hammant/ngWebDriver
 */
@Beta
public class ByAngularShow extends ByAngular.BaseBy {

    public ByAngularShow(JavascriptExecutor jse, String show) {
        super(jse);
        this.show = show;
    }

    private String show;
    private String makeJsBy(String oneOrAll) {    	
        return              
        		 "var using = arguments[0] || document;\n" +
                 "var show = '" + show + "';\n" +
                 "\n" +
                 "var rows = [];\n" +
                 "var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-'];\n" +
                 "for (var p = 0; p < prefixes.length; ++p) {\n" +
                 "  var attr = prefixes[p] + 'show';\n" +
                 "  var repeatElems = using.querySelectorAll('[' + attr + ']');\n" +
                 "  attr = attr.replace(/\\\\/g, '');\n" +
                 "  for (var i = 0; i < repeatElems.length; ++i) {\n" +
                 "    if (repeatElems[i].getAttribute(attr).indexOf(show) != -1) {\n" +
                 "      rows.push(repeatElems[i]);\n" +
                 "    }\n" +
                 "  }\n" +
                 "}\n" +
                 "return rows" + oneOrAll + ";";
    }

    @Override
    public WebElement findElement(SearchContext context) {
        if (context instanceof WebDriver) {
            context = null;
        }
        WebElement  o = (WebElement)jse.executeScript(makeJsBy("[0]"), context);
        
        errorIfNull(o);
        //WebElement e =(WebElement) o;
        Field privateStringField = null;
        try {
        	privateStringField = o.getClass().getDeclaredField("foundBy");
        	privateStringField.setAccessible(true);
            privateStringField.set(o, o.toString().replace("unknown locator", "ng-show: " + show));
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
      
        
        return o;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<WebElement> findElements(SearchContext searchContext) {
        if (searchContext instanceof WebDriver) {
            searchContext = null;
        }
        return (List<WebElement>) jse.executeScript(makeJsBy(""), searchContext);
    }
}
