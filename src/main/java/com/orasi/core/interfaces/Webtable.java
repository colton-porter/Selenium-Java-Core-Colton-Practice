package com.orasi.core.interfaces;

import org.openqa.selenium.WebElement;

import com.orasi.core.interfaces.impl.WebtableImpl;
import com.orasi.core.interfaces.impl.internal.ImplementedBy;
import com.orasi.utils.TestEnvironment;

/**
 * Interface that wraps a WebElement in CheckBox functionality.
 */
@ImplementedBy(WebtableImpl.class)
public interface Webtable extends Element {
        /**
     * @summary - Get the row count of the Webtable
     */
    int getRowCount(TestEnvironment te);

    /**
     * @summary - Get the column count for the Webtable on a specified Row
     */
    int getColumnCount(TestEnvironment te, int row) ;

    /**
     * @summary - Get cell data of the specified row and Column in a Webtable
     */
    String getCellData( TestEnvironment te, int row, int column) ;
    

   
    /**
     * @summary - Return the Cell of the specified row and Column in a Webtable
     */
    WebElement getCell( TestEnvironment te, int row, int column) ;
    

    /**
     * @summary - Click cell in the specified row and Column in a Webtable
     */
    void clickCell( TestEnvironment te, int row, int column)  ;
    
    
    /**
     * @summary - Get Row number where text is found
     */
    int getRowWithCellText(TestEnvironment te, String text);

    /**
     * @summary - Get Row number where text is found in a specific column
     */    
    int getRowWithCellText(TestEnvironment te, String text, int columnPosition);

    /**
     * @summary - Get Row number where text is found in a specific column and starting row
     */    
    int getRowWithCellText(TestEnvironment te, String text, int columnPosition, int startRow);
    
    /**
     * @summary - Get Row number where text is found in a specific column and starting row and case can be ignored
     */    
    int getRowWithCellText(TestEnvironment te, String text, int columnPosition, int startRow, boolean exact);
    
    /**
     * @summary - Get Column number where text is found
     */  
    int getColumnWithCellText(TestEnvironment te, String text);
    
    /**
     * @summary - Get Column number where text is found in a specific row
     */  
    int getColumnWithCellText(TestEnvironment te, String text, int rowPosition);
    
}